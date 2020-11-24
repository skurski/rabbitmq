package com.rabbitmq.consumer.domain.model;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Laptop implements Serializable {

    private String name;

    private String key;

    private BigDecimal price;

}
