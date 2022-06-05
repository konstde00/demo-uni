package com.konstde00.businessfacultymodule.service;

import com.konstde00.medicinefacultymodule.domain.enums.Speciality;
import com.konstde00.medicinefacultymodule.service.OrdinatorService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class HireService {

    MailService mailService;
    OrdinatorService ordinatorService;

    public String sendHireEmails(Speciality speciality) {

        List<String> emails = ordinatorService.getAllEmailsBySpeciality(speciality);

        return mailService.sendHireEmails(emails);
    }
}
