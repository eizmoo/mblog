package top.lajijson.mblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("top.lajijson.mblog.*.dao")
@SpringBootApplication
public class MblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(MblogApplication.class, args);
    }

}

