package com.konstde00.medicinefacultymodule.domain.entity;

import com.konstde00.medicinefacultymodule.domain.enums.Speciality;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ordinators")
@FieldDefaults(level = PRIVATE)
public class Ordinator {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    long id;

    String name;

    String surname;

    @Enumerated(value = EnumType.STRING)
    Speciality speciality;

    String email;
}
