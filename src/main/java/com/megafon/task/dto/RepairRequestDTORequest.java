package com.megafon.task.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class RepairRequestDTORequest {

    private String description;
    @NotEmpty
    private String address;
    @NotEmpty
    private String phoneNumber;
}
