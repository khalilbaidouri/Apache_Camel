package com.camel.apachecamel;

import com.camel.apachecamel.exemple1.HelloworldRoute;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApacheCamelApplication {

    public static void main(String[] args) throws Exception {

        CamelContext context = new DefaultCamelContext();
        context.addRoutes(new HelloworldRoute());
        context.start();
        SpringApplication.run(ApacheCamelApplication.class, args);
    }

}
