package com.kixikila.service.validation;

import java.util.Map;

public interface ParticipantValidationService<T> {

    Map<String,Object> validate(T item);

}
