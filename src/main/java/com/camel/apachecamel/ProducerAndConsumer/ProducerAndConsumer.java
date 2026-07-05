package com.camel.apachecamel.ProducerAndConsumer;

import org.apache.camel.*;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;


/**
 * @author $ {USERS}
 **/
public class ProducerAndConsumer {
    public static void main(String[] args) throws Exception {
        CamelContext context = new DefaultCamelContext();
        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("direct:start")
                        .process(new Processor() {
                            @Override
                            public void process(Exchange exchange) throws Exception {
                                //System.out.println("I m the processor ...");
                                String message =exchange.getIn().getBody(String.class);
                                System.out.printf(message +" before \n");
                                message = message + "_ khalil baidouri";
                                exchange.getOut().setBody(message);
                            }
                        })
                        .to("seda:end");
            }
        });
        context.start();
        ProducerTemplate producerTemplate =context.createProducerTemplate();
        producerTemplate.sendBody("direct:start", "hello Everyone");
        ConsumerTemplate consumerTemplate = context.createConsumerTemplate();
        String message =consumerTemplate.receiveBody("seda:end", String.class);
        System.out.println(message);
    }
}
