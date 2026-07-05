package com.camel.apachecamel.CopyFile;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * @author $ {USERS}
 **/
public class FileCopy {
    public static void main(String[] args) throws Exception {
        CamelContext camelContext = new DefaultCamelContext();
        //MyFirstRoute myFirstRoute = new MyFirstRoute();
        TransformRoute transformRoute =new TransformRoute();
        camelContext.addRoutes(transformRoute);
        while (true)
            camelContext.start();
    }
}
