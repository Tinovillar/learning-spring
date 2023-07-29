package com.patients.managment.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table(name = "person")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(name = "dni")
        private Integer dni;
        @Column(name = "name")
        private String name;
        @Column(name = "last_name")
        private String lastName;
        @Column(name = "description")
        private String description;
        @Column(name = "insurance")
        private String insurance;
        @Column(name = "role")
        private Role role;
}
