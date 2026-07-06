package com.camel.apachecamel.AggregatorRoute;

import org.apache.camel.AggregationStrategy;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * @author $ {USERS}
 **/
@Component
public class AggregatorRoute extends RouteBuilder {
    @Override
    public void configure() {
        from("file:input?delay=1000&noop=true")
                .aggregate(constant(true), new AggregationStrategy() {
                    @Override
                    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
                        if (oldExchange == null) return newExchange;
                        String combined = oldExchange.getIn().getBody(String.class)
                                + "\n---\n" + newExchange.getIn().getBody(String.class);
                        oldExchange.getIn().setBody(combined);
                        return oldExchange;
                    }
                })
                .completionTimeout(10000)
                .to("file:output?fileName=rapport-${date:now:yyyyMMddHHmmss}.txt");
    }
}
