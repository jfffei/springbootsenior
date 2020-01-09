package com.jinfei.elastic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*
* SpringBoot  默认支持两种技术来和ES交互
*   1、Jest（默认不生效）
*       需要导入jest工具包（import io.searchbox.client.JestClient;）
*   2、SpringData Elasticsearch [ES版本可能不合适]
*       1）、Client  节点信息ClusterNodes ； ClusterName
*       2）、ElasticsearchTemplate  操作ES
*       3）、编写一个ElasticsearchRepository的子接口操作ES
*
* 两种用法：https://github.com/spring-projects/spring-data-elasticsearch
*   1、编写一个ElasticsearchRepository的子接口
* */
@SpringBootApplication
public class Springboot03ElasticApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot03ElasticApplication.class, args);
    }

}
