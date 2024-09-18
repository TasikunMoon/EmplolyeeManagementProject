package com.company.employee_management.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee", schema = "chart")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "worker-ID", updatable = false)
    private Long id;

    @Column( name = "first-Name",
            nullable = false,
            columnDefinition = "Text")
    private String firstName;

    @Column(name = "last-Name",
            nullable = false,
            columnDefinition = "Text")
    private String lastName;

    @Column(name = "email-address",
            nullable = false,
            columnDefinition = "Text")
    private String email;

}