package com.camel.apachecamel.JmsRoute;

import org.apache.camel.builder.RouteBuilder;

/**
 * @author $ {USERS}
 **/
public class JmsRoute extends RouteBuilder {
    @Override
    public void configure() {
        from("jms:queue:SWIFT.IN.TEST")
                .log("Message JMS reçu: ${body}")
                .to("file:jms-received");
    }
}
