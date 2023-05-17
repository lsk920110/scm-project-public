package com.gamsung.scmproject.member.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Primary;

@Entity
@Getter
@Setter
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String department;

    @Column
    private String loginId;

    @Column
    private String password;

    @Column
    private String state;

    @Column
    private String role;


}
