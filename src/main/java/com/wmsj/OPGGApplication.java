package com.wmsj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableCaching
@EnableAsync
@EnableScheduling
@SpringBootApplication
public class OPGGApplication extends SpringBootServletInitializer {
    /**
     * @EnableCaching
     * 功能：启用 Spring 的缓存支持。
     * 作用：当你在方法上使用 @Cacheable、@CachePut 或 @CacheEvict 等注解时，Spring 会自动缓存方法的返回值，以提高性能。
     * 使用场景：在处理耗时操作时可以减少不必要的重复计算或数据库查询。
     * @EnableAsync
     * 功能：启用 Spring 的异步方法执行支持。
     * 作用：允许使用 @Async 注解的方法在独立线程中异步执行，而不是阻塞主线程，提升并发性能。
     * 使用场景：在需要执行耗时操作而不想阻塞主线程时（例如发送邮件、远程调用等），可以使用异步执行。
     * @EnableScheduling
     * 功能：启用 Spring 的任务调度支持。
     * 作用：允许在方法上使用 @Scheduled 注解来配置定时任务。
     * 使用场景：需要定期执行某些任务，例如定时备份、定时清理数据等。
     */
    public static void main(String[] args) {
        SpringApplication.run(OPGGApplication.class);
    }
}