package com.eybilal.esedminventoryservice.core.pojo;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@SuperBuilder
public class DescriptiveEntity extends NamedEntity {
    @Column(name = "description")
    private String description;
}
