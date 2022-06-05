package com.konstde00.businessfacultymodule.service;

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
public class MailService {

    static String MOCK_RESPONSE_BEGINNING = "Sent hire emails to: \n";

    //there has to be implemented logic of sending email
    //for example, using 'Java mail' library & AWS SES
    public String sendHireEmails(List<String> emails) {

        return performMockResponse(emails);
    }

    private String performMockResponse(List<String> emails) {

        StringBuilder stringBuilder = new StringBuilder(MOCK_RESPONSE_BEGINNING);

        emails.forEach(e -> stringBuilder.append(e).append("\n"));

        return stringBuilder.toString();
    }
}
