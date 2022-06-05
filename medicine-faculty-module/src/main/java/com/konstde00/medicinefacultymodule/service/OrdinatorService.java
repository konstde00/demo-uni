package com.konstde00.medicinefacultymodule.service;

import com.konstde00.medicinefacultymodule.domain.entity.Ordinator;
import com.konstde00.medicinefacultymodule.domain.enums.Speciality;
import com.konstde00.medicinefacultymodule.repository.OrdinatorRepository;
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
public class OrdinatorService {

    OrdinatorRepository ordinatorRepository;

    public List<String> getAllEmailsBySpeciality(Speciality speciality) {

        log.debug("Finding all ordinators emails by speciality '{}'", speciality);

        List<String> emails = ordinatorRepository.getAllEmailsBySpeciality(speciality.toString());

        log.debug("Found all ordinators emails by speciality '{}', result = '{}'", speciality, emails);

        return emails;
    }

    public List<Ordinator> findAll() {

        log.debug("Finding all ordinators");

        List<Ordinator> ordinators = ordinatorRepository.findAll();

        log.debug("Found all ordinators, result = '{}'", ordinators);

        return ordinators;
    }
}
