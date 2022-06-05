package com.konstde00.medicinefacultymodule.domain.dto;

import com.konstde00.medicinefacultymodule.domain.enums.Speciality;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(level = PRIVATE)
public class OrdinatorDto {

    long id;

    String name;

    String surname;

    Speciality speciality;

    String email;
}
