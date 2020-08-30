package com.megafon.task.dto;

import lombok.Data;

@Data
public class RepairRequestDTOResponse {

    private Long id;
    private String description;
    private String address;
    private String phoneNumber;
}
