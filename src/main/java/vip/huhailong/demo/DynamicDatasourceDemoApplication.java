package vip.huhailong.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("vip.huhailong.demo.mapper")
@SpringBootApplication
public class DynamicDatasourceDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DynamicDatasourceDemoApplication.class, args);
	}

}
