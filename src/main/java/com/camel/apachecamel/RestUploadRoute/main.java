
package com.camel.apachecamel.RestUploadRoute;

import com.camel.apachecamel.SftpRoute.SftpRoute;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * @author $ {USERS}
 **/
public class main {
    public static void main(String args[]) throws Exception {
        CamelContext context = new DefaultCamelContext();
        RestUploadRoute restUploadRoute= new RestUploadRoute();
        context.addRoutes(restUploadRoute);
        while (true){
            context.start();
        }
    }
}
