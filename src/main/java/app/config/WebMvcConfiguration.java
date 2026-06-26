package app.config;

import app.security.SessionInterceptor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

//    private final SessionInterceptor sessionInterceptor;
//
//    public WebMvcConfiguration(SessionInterceptor sessionInterceptor) {
//        this.sessionInterceptor = sessionInterceptor;
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(sessionInterceptor)
//                .addPathPatterns("/**")
//                .excludePathPatterns("/css/**", "/images/**");
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
                .authorizeHttpRequests(
                        authorize -> authorize
                                .requestMatchers(PathRequest.toStaticResources().atCommonLocations())
                                .permitAll()
                                .requestMatchers("/", "/home", "/login", "/register", "/error")
                                .permitAll()
                                .requestMatchers( "/reports/**")
                                .hasRole("ADMIN")
                                // .hasAuthority("ROLE_ADMIN")
                                .anyRequest()
                                .authenticated()
                )
                .formLogin(formLogin -> formLogin
                        .loginPage("/login")
                        .defaultSuccessUrl("/home", true)
                        .failureUrl("/login?error=true")
                        .permitAll()
                )
                .logout(logout -> logout
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
                        .logoutSuccessUrl("/")
                );


        return httpSecurity.build();
    }
}
