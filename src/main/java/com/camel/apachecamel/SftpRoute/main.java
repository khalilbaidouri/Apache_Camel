package com.camel.apachecamel.SftpRoute;

import com.camel.apachecamel.WireTapRoute.WireTapRoute;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * @author $ {USERS}
 **/
public class main {
    public static void main(String args[]) throws Exception {
        CamelContext context = new DefaultCamelContext();
        SftpRoute sftpRoute = new SftpRoute();
        context.addRoutes(sftpRoute);
        while (true){
            context.start();
        }
    }
}
