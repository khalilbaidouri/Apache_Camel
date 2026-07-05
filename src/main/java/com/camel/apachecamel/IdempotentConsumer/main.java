package com.camel.apachecamel.IdempotentConsumer;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * @author $ {USERS}
 **/
public class main {
    public static void main(String args[]) throws Exception {
        CamelContext context = new DefaultCamelContext();
        IdempotentRoute idempotentRoute = new IdempotentRoute();
        context.addRoutes(idempotentRoute);
        while (true){
            context.start();
        }
    }
}
