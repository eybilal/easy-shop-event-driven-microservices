package com.eybilal.esedminventoryservice.core.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
// import javax.validation.constraints.NotEmpty;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class NamedEntity extends BaseEntity {
    @Column(name = "name")
    // @NotEmpty
    private String name;
}
