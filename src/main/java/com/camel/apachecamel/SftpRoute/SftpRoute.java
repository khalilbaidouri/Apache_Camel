package com.camel.apachecamel.SftpRoute;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * @author $ {USERS}
 **/
@Component
public class SftpRoute extends RouteBuilder {
    @Override
    public void configure() {
        from("sftp://testuser@localhost:2222/upload"
                + "?password=testpass"
                + "&delay=10000"
                + "&delete=false")
                .log("Fichier SFTP reçu: ${header.CamelFileName}")
                .to("file:sftp-received");
    }
}