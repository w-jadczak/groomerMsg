package com.wjadczak.groomerMsg.config;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@RequiredArgsConstructor
@PropertySource("classpath:application.yaml")
public class RabbitMqConfig {
    @Value("${spring.rabbitmq.registrationQueue}")
    private String REGISTRATION_QUEUE;
    @Value("${spring.rabbitmq.registrationRoutingKey}")
    private String REGISTRATION_ROUTING_KEY;
    @Value("${spring.rabbitmq.appointmentConfirmationQueue}")
    public String APPOINTMENT_CONFIRMATION_QUEUE;
    @Value("${spring.rabbitmq.confirmationRoutingKey}")
    private String CONFIRMATION_ROUTING_KEY;
    @Value("${spring.rabbitmq.appointmentCancellationQueue}")
    public String APPOINTMENT_CANCELLATION_QUEUE;
    @Value("${spring.rabbitmq.cancellationRoutingKey}")
    private String CANCELLATION_ROUTING_KEY;
    @Value("${spring.rabbitmq.exchangeName}")
    private String EXCHANGE_NAME;

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

