package kg.monitoring.blevota.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**") // Укажите путь, который требуется разрешить
                        .allowedOrigins("http://localhost:3000") // Разрешенный источник (URL React-приложения)
                        .allowedMethods("GET", "POST", "PUT", "DELETE"); // Разрешенные HTTP-методы
            }
        };
    }
}
