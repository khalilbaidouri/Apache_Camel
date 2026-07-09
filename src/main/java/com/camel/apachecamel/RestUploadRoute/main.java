
package com.camel.apachecamel.RestUploadRoute;

import com.camel.apachecamel.SftpRoute.SftpRoute;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * @author $ {USERS}
 **/
public class main {
    public static void main(String[] args) throws Exception {
        CamelContext context = new DefaultCamelContext();
        context.addRoutes(new RestUploadRoute());
        context.start();
        Thread.sleep(120000);
        context.stop();
    }
}