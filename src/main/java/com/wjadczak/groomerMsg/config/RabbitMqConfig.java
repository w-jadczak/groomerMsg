package com.wjadczak.groomerMsg.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMqConfig {

    public static final String REGISTRATION_QUEUE = "q.user_registration";
    private final String REGISTRATION_ROUTING_KEY = "k.registration";
    public static final String APPOINTMENT_CONFIRMATION_QUEUE = "q.appointment_confirmation";
    private final String CONFIRMATION_ROUTING_KEY = "k.confirmation";
    public static final String APPOINTMENT_CANCELLATION_QUEUE = "q.appointment_cancellation";
    private final String CANCELLATION_ROUTING_KEY = "k.cancellation";
    public static final String EXCHANGE_NAME = "x.message_exchange";

    @Bean
    public Queue createUserRegistrationQueue() {
        return QueueBuilder
                .durable(REGISTRATION_QUEUE)
                .build();
    }

    @Bean
    public Queue createAppointmentConfirmationQueue() {
        return QueueBuilder
                .durable(APPOINTMENT_CONFIRMATION_QUEUE)
                .build();
    }

    @Bean
    public Queue createAppointmentCancellationQueue() {
        return QueueBuilder
                .durable(APPOINTMENT_CANCELLATION_QUEUE)
                .build();
    }

    @Bean
    public Exchange messageExchange() {
        return ExchangeBuilder
                .directExchange(EXCHANGE_NAME)
                .build();
    }
    @Bean
    public Binding registrationQueueBinding(DirectExchange exchange, @Qualifier("createUserRegistrationQueue") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with(REGISTRATION_ROUTING_KEY);
    }
    @Bean
    public Binding confirmationQueueBinding(DirectExchange exchange, @Qualifier("createAppointmentConfirmationQueue") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with(CONFIRMATION_ROUTING_KEY);
    }
    @Bean
    public Binding cancellationQueueBinding(DirectExchange exchange, @Qualifier("createAppointmentCancellationQueue") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with(CANCELLATION_ROUTING_KEY);
    }
    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}

