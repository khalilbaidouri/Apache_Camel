package com.camel.apachecamel.RestUploadRoute;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;

/**
 * @author $ {USERS}
 **/
public class RestUploadRoute extends RouteBuilder {
    @Override
    public void configure() {
        restConfiguration()
                .component("platform-http")
                .bindingMode(RestBindingMode.off)
                .port(8080);

        rest("/api/v1/upload")
                .post()
                .consumes("multipart/form-data")
                .to("direct:handleUpload");

        from("direct:handleUpload")
                .log("Fichier reçu via API, taille: ${header.Content-Length}")
                .to("file:api-received");
    }
}