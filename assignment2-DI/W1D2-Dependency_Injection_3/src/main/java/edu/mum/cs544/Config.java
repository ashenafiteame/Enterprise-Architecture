package edu.mum.cs544;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
@ComponentScan("edu.mum.cs544")
public class Config {
    @Bean
    public List<IBookSupplier> suppliers(){
        return Arrays.asList(
                new Amazon(),
                new BarnesAndNoble(),
                new EBooks(),
                new Borders()
        );
    }
}
