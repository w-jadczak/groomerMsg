package com.wjadczak.groomerMsg.service.EmailFactory;

import com.wjadczak.groomerMsg.enums.MessageType;

import java.util.HashMap;
import java.util.Map;

public class EmailBuilderFactory {
    private static final Map<MessageType, EmailBuilder> EMAIL_BUILDER_MAP = new HashMap<>();

    static {
        EMAIL_BUILDER_MAP.put(MessageType.REGISTRATION_CONFIRMATION, new RegistrationConfirmationEmailBuilder());
        EMAIL_BUILDER_MAP.put(MessageType.APPOINTMENT_CANCELLATION, new AppointmentCancellationEmailBuilder());
        EMAIL_BUILDER_MAP.put(MessageType.APPOINTMENT_CONFIRMATION, new AppointmentConfirmationEmailBuilder());
    }

    public static EmailBuilder createBuilder(MessageType messageType){
        return EMAIL_BUILDER_MAP.get(messageType);
    }
}
