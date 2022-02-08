package com.eybilal.esedminventoryservice.core.event;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public abstract class BaseEvent<T> {
    private final T id;
}
