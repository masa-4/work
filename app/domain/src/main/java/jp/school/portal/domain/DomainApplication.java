package jp.school.portal.domain;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
@EnableJpaAuditing
public class DomainApplication {

	public static void main(String[] args) {
		SpringApplication.run(DomainApplication.class, args);
	}

	// アプリケーション起動時にJSTを設定
	@PostConstruct
	public void init() {
		// タイムゾーンをJST（日本標準時）に設定
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Tokyo"));
	}
}
