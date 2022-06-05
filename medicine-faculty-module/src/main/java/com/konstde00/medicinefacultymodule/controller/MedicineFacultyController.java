package com.konstde00.medicinefacultymodule.controller;

import com.konstde00.medicinefacultymodule.domain.dto.OrdinatorDto;
import com.konstde00.medicinefacultymodule.domain.entity.Ordinator;
import com.konstde00.medicinefacultymodule.service.OrdinatorService;
import com.konstde00.medicinefacultymodule.service.mapper.OrdinatorMapper;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/medical-faculty")
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class MedicineFacultyController {

    OrdinatorService ordinatorService;

    @GetMapping("/v1")
    @Operation(summary = "Find all ordinators")
    public ResponseEntity<List<OrdinatorDto>> findAll() {

        List<Ordinator> ordinators = ordinatorService.findAll();

        List<OrdinatorDto> ordinatorDtos = OrdinatorMapper.toDtoList(ordinators);

        return new ResponseEntity<>(ordinatorDtos, HttpStatus.OK);
    }
}
