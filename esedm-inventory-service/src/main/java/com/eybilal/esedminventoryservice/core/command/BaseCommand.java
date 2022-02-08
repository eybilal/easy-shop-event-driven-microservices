package com.eybilal.esedminventoryservice.core.command;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

/**
 *
 * @param <T>
 * Command are immutable
 */
@Getter
@SuperBuilder
public abstract class BaseCommand<T> {
    @TargetAggregateIdentifier
    private final T id;
}
