package com.example.springbeanscopes;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@Configuration
public class ScopesConfig {

    @Bean
    @Scope("singleton")  //singleton создаётся один раз для всего жизненного цикла приложения
    public Person personSingleton() {
        return new Person();
    }

    @Bean
    @Scope("prototype")   //prototype создаётся каждый раз, когда он запрашивается
    public Person personPrototype() {
        return new Person();
    }

    @Bean
    @RequestScope   //request создаётся для каждого HTTP-запроса
    public HelloMessageGenerator requestScopedBean() {
        return new HelloMessageGenerator();
    }

    @Bean
    @SessionScope   //session создаётся один раз на сессию пользователя
    public HelloMessageGenerator sessionScopedBean() {
        return new HelloMessageGenerator();
    }

    @Bean
    @ApplicationScope   //application создаётся один раз для всего приложения и существует так же долго, как само приложение
    public HelloMessageGenerator applicationScopedBean() {
        return new HelloMessageGenerator();
    }
}
