package com.jinfei.springboot08actuator.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

@Component
public class MyAppHealthIndicator extends AbstractHealthIndicator {
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
    }

    @Override
    public Health getHealth(boolean includeDetails) {
        return Health.down().withDetail("msg", "服务异常").build();
    }
}
