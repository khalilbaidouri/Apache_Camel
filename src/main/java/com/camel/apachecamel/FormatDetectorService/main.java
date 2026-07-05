package com.camel.apachecamel.FormatDetectorService;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * @author $ {USERS}
 **/
public class main {
    public static void main(String[] args) throws Exception {
        CamelContext camelContext = new DefaultCamelContext();
        RouterRoute routerRoute = new RouterRoute();
        camelContext.addRoutes(routerRoute);
        while (true)
        {
            camelContext.start();
        }
    }
    }
