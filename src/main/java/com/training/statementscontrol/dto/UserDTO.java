package com.training.statementscontrol.dto;

import lombok.Builder;

/**
 * Data Transfer Object para la entidad User.
 */
@Builder
public class UserDTO {
    private String name;
    private double balance;
}
