package config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"com.softideas.weather.*", "com.softideas.common.*"})
public class Application {
    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }
}
