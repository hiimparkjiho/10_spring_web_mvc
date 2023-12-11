package com.ohgiraffers.securitysession.config;

import com.ohgiraffers.securitysession.common.UserRole;
import com.ohgiraffers.securitysession.config.handler.AuthFailHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration // 스프링에서 필요한 빈을 여기서 관리하겠다.
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private AuthFailHandler authFailHandler;

    /*
     * 비밀번호를 인코딩하기 위한 Bean
     * Bcrypt는 비밀번호 해싱에 가장 많이 사용되는 알고리즘 중 하나이다.
     *
     * 사용 이유
     * 1. 보안성 : 해시 함수에 무작위 솔트를 적용하여 생성한다.
     * 2. 비용 증가 : 매개변수에 값을 주면 암호 생성 시간을 조절할 수 있어 무차별 공격을 어렵게 한다.
     * 3. 호환성 : 높은 보완 수준 및 데이터베이스에 저장하기 쉬운 특징
     * 4. 알고리즘 신뢰성 : 보안에 논의 평가를 거친 알고리즘으로 문제 없이 계속 사용중*/
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean // 정적 리소스에 대한 요청을 제외하겠다는 설정, static 파일 하위..
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(auth -> { // 서버의 리소스에 접근 가능한 권한을 설정함
            auth.requestMatchers("/auth/login", "/user/signup", "/auth/fail", "/").permitAll(); // 모든이에게 요청 허용
            auth.requestMatchers("/admin/*").hasAnyAuthority(UserRole.ADMIN.getRole()); // admin 권한자 요청 가능
            auth.requestMatchers("/user/*").hasAnyAuthority(UserRole.USER.getRole()); // 유저 권한자 요청 가능
            auth.anyRequest().authenticated(); // authenticated() : 모든 요청에 대해서 인증된 사용자들만 사용 가능
        }).formLogin(login -> { // 람다식
            login.loginPage("/auth/login"); // 로그인 페이지에 해당하는 서블릿이 존재해야 한다. // 컨트롤러에 이 페이지 만들거임
            login.usernameParameter("user"); // input name 바꿔주기
            login.passwordParameter("pass");
            login.defaultSuccessUrl("/"); // 해당 서블릿이 존재해야 한다.
            login.failureHandler(authFailHandler); // 실패했을 때 처리법
        }).logout(logout -> {
            logout.logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout")); // 어떤 요청이 들어오면 로그아웃인지
            logout.deleteCookies("JSESSIONID"); // 기존 세션 제거
            logout.invalidateHttpSession(true); // 세션을 소멸하도록 허용하는 것(true)
            logout.logoutSuccessUrl("/"); // 로그아웃 완료시 이동할 페이지 url 설정
        }).sessionManagement(session -> {
            session.maximumSessions(1); // 세션의 개수 제한 // 1 - 중복 로그인 불가
            session.invalidSessionUrl("/"); // 세션 만료시 이동할 페이지 url
        }).csrf(csrf -> csrf.disable()); // 공격방지?

        return http.build();

    }

}

