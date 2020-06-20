package com.wuqingshi.cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 缓存的使用：
 *      步骤：
 *          1、开启基于注解的缓存 @EnableCaching
 *          2、标注注解即可
 * @
 */
@MapperScan("com.wuqingshi.cache.mapper")
@SpringBootApplication
@EnableCaching
public class Springboot07CacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot07CacheApplication.class, args);
    }

}
