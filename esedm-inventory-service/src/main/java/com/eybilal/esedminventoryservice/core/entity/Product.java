package com.eybilal.esedminventoryservice.core.entity;


import com.eybilal.esedminventoryservice.core.pojo.DescriptiveEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@SuperBuilder
public class Product extends DescriptiveEntity {
    private BigDecimal price;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
