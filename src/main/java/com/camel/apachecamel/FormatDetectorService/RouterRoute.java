package com.camel.apachecamel.FormatDetectorService;

import org.apache.camel.builder.RouteBuilder;

/**
 * @author $ {USERS}
 **/
public class RouterRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:input?delay=5000&noop=true")
                .choice()
                .when(header("CamelFileName").endsWith(".xml"))
                .to("file:xml-processed")
                .when(header("CamelFileName").endsWith(".txt"))
                .to("file:txt-processed")
                .otherwise()
                .to("file:unknown")
                .end();
    }
}
