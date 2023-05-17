package com.gamsung.scmproject.common.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TransprotCenterInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String deliveryArea;

    @Column
    private String contactTelephone;

    @Column
    private String state;
}
