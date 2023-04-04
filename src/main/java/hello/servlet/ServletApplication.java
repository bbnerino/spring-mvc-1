package hello.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


@ServletComponentScan // 서블릿 자동 등록
@SpringBootApplication // 스프링 부트 자동 설정, 스프링 Bean 읽기와 생성을 모두 자동으로 설정
public class ServletApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServletApplication.class, args);
	}

}
