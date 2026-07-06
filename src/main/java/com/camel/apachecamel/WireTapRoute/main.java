package com.camel.apachecamel.WireTapRoute;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * @author $ {USERS}
 **/
public class main {
    public static void main(String args[]) throws Exception {
        CamelContext context = new DefaultCamelContext();
        WireTapRoute wireTapRoute = new WireTapRoute();
        context.addRoutes(wireTapRoute);
        while (true){
            context.start();
        }
    }
}
