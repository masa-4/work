package jp.school.portal.api;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
@ComponentScan(basePackages = {"jp.school.portal.domain", "jp.school.portal.api"})
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	// アプリケーション起動時にJSTを設定
	@PostConstruct
	public void init() {
		// タイムゾーンをJST（日本標準時）に設定
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Tokyo"));
	}
}
