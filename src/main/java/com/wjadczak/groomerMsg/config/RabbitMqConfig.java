package com.wjadczak.groomerMsg.config;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {
    @Configuration
    public class RabbitMqConfig {

        public static final String REGISTRATION_QUEUE = "q.user_registration";
        public static final String REGISTRATION_ROUTING_KEY = "k.registration";
        public static final String APPOINTMENT_CONFIRMATION_QUEUE = "q.appointment_confirmation";
        public static final String APPOINTMENT_CANCELLATION_QUEUE = "q.appointment_cancellation";
        public static final String EXCHANGE_NAME = "x.message_exchange";
        @Bean
        public Queue createUserRegistrationQueue(){
            return QueueBuilder
                    .durable(REGISTRATION_QUEUE)
                    .build();
        }
        @Bean
        public Queue createAppointmentConfirmationQueue(){
            return QueueBuilder
                    .durable(APPOINTMENT_CONFIRMATION_QUEUE)
                    .build();
        }
        @Bean
        public Queue createAppointmentCancellationQueue(){
            return QueueBuilder
                    .durable(APPOINTMENT_CANCELLATION_QUEUE)
                    .build();
        }
        @Bean
        public Exchange messageExchange(){
            return ExchangeBuilder
                    .directExchange(EXCHANGE_NAME)
                    .build();
        }
        @Bean
        public MessageConverter messageConverter(){
            return new Jackson2JsonMessageConverter();
        }
    }
}
