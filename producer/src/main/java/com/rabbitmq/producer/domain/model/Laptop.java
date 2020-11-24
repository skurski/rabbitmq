package com.rabbitmq.producer.domain.model;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Laptop implements Serializable {

    @NotBlank(message = "Field cannot be empty")
    private String name;

    @NotBlank(message = "Field cannot be empty")
    private String key;

    @NotBlank(message = "Field cannot be empty")
    private BigDecimal price;

}
