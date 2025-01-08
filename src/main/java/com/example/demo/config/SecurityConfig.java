package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	UserDetailsService userDetailsService() {
		return new LoginUserDetailService();
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.formLogin(login -> login //  フォーム認証を使う
						.loginPage("/login")
						.defaultSuccessUrl("/todo", true)
						.permitAll()) //  フォーム認証画面は認証不要
				.logout(logout -> logout
						.logoutUrl("/logout") // ログアウトURL
						.logoutSuccessUrl("/login?logout=true") // ログアウト成功後のリダイレクト先
						.invalidateHttpSession(true) // セッションを無効化
						.deleteCookies("JSESSIONID")) // クッキーを削除
				.authorizeHttpRequests(authz -> authz
						.requestMatchers("/css/**", "/js/**", "/webjars/**", "/").permitAll()
						.anyRequest().authenticated() //  他のURLはログイン後アクセス可能
				);

		return http.build();
	}
}
