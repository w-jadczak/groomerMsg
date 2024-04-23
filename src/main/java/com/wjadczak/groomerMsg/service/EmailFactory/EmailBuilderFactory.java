package com.wjadczak.groomerMsg.service.EmailFactory;

import com.wjadczak.groomerMsg.enums.MessageType;

import java.util.HashMap;
import java.util.Map;

public class EmailBuilderFactory {
    private static final Map<MessageType, EmailBuilder> builderMap = new HashMap<>();

    static {
        builderMap.put(MessageType.REGISTRATION_CONFIRMATION, new RegistrationConfirmationEmailBuilder());
        builderMap.put(MessageType.APPOINTMENT_CANCELLATION, new AppointmentCancellationEmailBuilder());
        builderMap.put(MessageType.APPOINTMENT_CONFIRMATION, new AppointmentConfirmationEmailBuilder());
    }

    public static EmailBuilder createBuilder(MessageType messageType){
        return builderMap.get(messageType);
    }
}
