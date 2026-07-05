package com.camel.apachecamel.exemple1;

import org.apache.camel.builder.RouteBuilder;

/**
 * @author $ {USERS}
 **/
public class HelloworldRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        System.out.println("hello world in camel");
    }
}
