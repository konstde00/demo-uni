package com.konstde00.medicinefacultymodule.service.mapper;

import com.konstde00.medicinefacultymodule.domain.dto.OrdinatorDto;
import com.konstde00.medicinefacultymodule.domain.entity.Ordinator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class OrdinatorMapper {

    public static OrdinatorDto toDto(Ordinator ordinator) {

        OrdinatorDto dto = new OrdinatorDto();

        dto.setId(ordinator.getId());
        dto.setName(ordinator.getName());
        dto.setSurname(ordinator.getSurname());
        dto.setEmail(ordinator.getEmail());
        dto.setSpeciality(ordinator.getSpeciality());

        return dto;
    }

    public static List<OrdinatorDto> toDtoList(List<Ordinator> ordinators) {

        if (ordinators != null) {

            return ordinators.stream()
                .filter(Objects::nonNull)
                .map(OrdinatorMapper::toDto)
                .collect(Collectors.toList());

        } else {

            return new ArrayList<>();
        }
    }
}
