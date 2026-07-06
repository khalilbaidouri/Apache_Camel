package com.camel.apachecamel.WireTapRoute;

import org.apache.camel.builder.RouteBuilder;

/**
 * @author $ {USERS}
 **/
public class WireTapRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:input?delay=5000&noop=true")
                .wireTap("file:audit")
                .log("Traitement principal en cours...")
                .to("file:output");
    }
}
