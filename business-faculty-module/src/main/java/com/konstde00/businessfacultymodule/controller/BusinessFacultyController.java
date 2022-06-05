package com.konstde00.businessfacultymodule.controller;

import com.konstde00.businessfacultymodule.service.HireService;
import com.konstde00.medicinefacultymodule.domain.enums.Speciality;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static lombok.AccessLevel.PRIVATE;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/business-faculty")
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class BusinessFacultyController {

    HireService hireService;

    @PostMapping("/v1/send-hire-emails")
    @Operation(summary = "Send hire emails to all ordinators of selected speciality")
    public ResponseEntity<String> sendHireEmails(@RequestParam Speciality speciality) {

        String response = hireService.sendHireEmails(speciality);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
