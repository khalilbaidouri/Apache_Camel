package com.camel.apachecamel.JmsRoute;

import com.camel.apachecamel.IdempotentConsumer.IdempotentRoute;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * @author $ {USERS}
 **/
public class main {
    public static void main(String[] args) throws Exception {
        CamelContext context = new DefaultCamelContext();

        ActiveMQConnectionFactory connectionFactory =
                new ActiveMQConnectionFactory("tcp://localhost:61616");
        connectionFactory.setUser("admin");
        connectionFactory.setPassword("admin");
        context.getComponent("jms", JmsComponent.class)
                .setConnectionFactory(connectionFactory);

        context.addRoutes(new JmsRoute());
        context.start();
        Thread.sleep(60000); // garde l'app active pour observer
        context.stop();
    }
}