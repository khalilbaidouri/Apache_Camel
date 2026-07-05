package com.camel.apachecamel.CopyFile;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * @author $ {USERS}
 **/
@Component
public class TransformRoute extends RouteBuilder {
    @Override
    public void configure() {
        from("file:input?delay=5000&noop=true")
                .log("Fichier reçu: ${header.CamelFileName}, taille: ${header.CamelFileLength}")
                .process(exchange -> {
                    String body = exchange.getIn().getBody(String.class);
                   exchange.getIn().setHeader("Auteur" ,"khalil");
                    body = body +" "+exchange.getIn().getHeader("CamelFileName", String.class);
                    body = body +" "+exchange.getIn().getHeader("Auteur",String.class);
                    exchange.getIn().setBody(body.toUpperCase());
                })
                .setHeader("CamelFileName",
                        simple("${header.CamelFileName}-${date:now:yyyyMMddHHmmss}"))
                .to("file:output");
    }
}