package com.gamsung.scmproject.common.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String department;
    //1.영업팀
    //2.영업관리팀
    //3.콜센터팀
    //4.물류센터
}
