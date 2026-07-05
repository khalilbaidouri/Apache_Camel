package com.camel.apachecamel.IdempotentConsumer;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.support.processor.idempotent.MemoryIdempotentRepository;
import org.springframework.stereotype.Component;
import org.apache.commons.codec.digest.DigestUtils;
/**
 * @author $ {USERS}
 **/
@Component
public class IdempotentRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:input?delay=5000&noop=true")
                .process(exchange -> {
                    String body = exchange.getIn().getBody(String.class);
                    String hash = DigestUtils.sha256Hex(body);
                    exchange.getIn().setHeader("contentHash", hash);
                })
                .idempotentConsumer(header("contentHash"), MemoryIdempotentRepository.memoryIdempotentRepository(200))
                .log("Fichier accepter  (nouveau contenu)")
                .to("file:output");
    }
}
