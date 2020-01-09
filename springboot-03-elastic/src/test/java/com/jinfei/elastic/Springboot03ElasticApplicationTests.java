package com.jinfei.elastic;

import com.jinfei.elastic.bean.Article;
import com.jinfei.elastic.bean.Book;
import com.jinfei.elastic.repository.BookRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class Springboot03ElasticApplicationTests {

    @Autowired
    JestClient jestClient;

    @Autowired
    BookRepository bookRepository;

    @Test
    public void test02() {
//        Book book = new Book();
//        book.setId(1);
//        book.setName("hahahh");
//        book.setAuthor("jinfei");
//        bookRepository.index(book);
        for (Book book : bookRepository.findByNameLike("ha")) {
            System.out.println(book);
        }
        ;
    }
    @Test
    void contextLoads() {
        //1、给ES中索引（保存一个文档）
        Article article = new Article();
        article.setId(1);
        article.setAuthor("jinfei");
        article.setTitle("Hello");
        article.setContent("Hello World!");

        //构建一个索引功能
        Index index = new Index.Builder(article).index("jinfei").type("news").build();

        try {
            //执行
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //测试搜索
    @Test
    public void search() {

        //查询表达式
        String json = "{\n" +
                "\"query\" : {\n" +
                "\"match\" : {\n" +
                "\"content\" : \"Hello\"\n" +
                "}\n" +
                "}\n" +
                "}";
        //构建搜索功能
        Search search = new Search.Builder(json).addIndex("jinfei").addType("news").build();

        try {
            SearchResult result = jestClient.execute(search);
            System.out.println(result.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
