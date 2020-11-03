package ru.spbstu.security;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/articles").setViewName("articles");
        registry.addViewController("/addArticle").setViewName("articles");
        registry.addViewController("/getArticle").setViewName("articles");
        registry.addViewController("/showArticles").setViewName("articles");
        registry.addViewController("/deleteArticle").setViewName("articles");
        registry.addViewController("/balance").setViewName("balance");
        registry.addViewController("/addBalance").setViewName("balance");
        registry.addViewController("/getBalance").setViewName("balance");
        registry.addViewController("/showBalance").setViewName("balance");
        registry.addViewController("/deleteBalance").setViewName("balance");
        registry.addViewController("/operations").setViewName("operations");
        registry.addViewController("/getOperation").setViewName("operations");
        registry.addViewController("/showOperations").setViewName("operations");
        registry.addViewController("/deleteOperation").setViewName("operations");
    }

}