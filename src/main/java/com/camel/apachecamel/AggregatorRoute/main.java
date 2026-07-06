package com.camel.apachecamel.AggregatorRoute;

import com.camel.apachecamel.WireTapRoute.WireTapRoute;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * @author $ {USERS}
 **/
public class main {
    public static void main(String args[]) throws Exception {
        CamelContext context = new DefaultCamelContext();
        AggregatorRoute aggregatorRoute=new AggregatorRoute();
        context.addRoutes(aggregatorRoute);
        while (true){
            context.start();
        }
    }
}
