package com.megafon.task.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;


@NoArgsConstructor
@Data
@Table(name = "repair_request")
@Entity
@EntityListeners(AuditingEntityListener.class)
public class RepairRequest extends StandardEntity {

    @Column(name = "description")
    private String description;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    public RepairRequest(String description,
                         String address,
                         String phoneNumber) {
        this.description = description;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
}



