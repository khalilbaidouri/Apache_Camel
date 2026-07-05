package com.camel.apachecamel.CopyFile;

import org.apache.camel.builder.RouteBuilder;

/**
 * @author $ {USERS}
 **/
public class MyFirstRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:input?delay=5000&noop=true")
                .to("file:output");
    }
}
