package com.caseKartaca.caseKartaca.api;


import com.caseKartaca.caseKartaca.entity.Data;
import com.caseKartaca.caseKartaca.repository.DataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/personals")
@RequiredArgsConstructor
public class PersonalController {   //http://localhost:8080/personals

    @Value("${caseKartaca.caseKartaca.topic}")
    private String topic;

    private final KafkaTemplate<String,String> kafkaTemplate;
    public int s=LocalDateTime.now().getSecond();

    @GetMapping
    public String getPersonal(){
        long startTime=System.currentTimeMillis();
        String message = "GET,"+startTime;
        kafkaTemplate.send(topic,message);
        return "get personal was called";
    }

    @PostMapping
    public String createPersonal(){
        long startTime=System.currentTimeMillis();
        String message = "POST,"+startTime;
        kafkaTemplate.send(topic,message);
        return "create personal was called";
    }

    @PutMapping
    public String updatePersonal(){
        long startTime=System.currentTimeMillis();
        String message = "PUT,"+startTime;
        kafkaTemplate.send(topic,message);
        return "update personal was called";
    }

    @DeleteMapping
    public String deletePersonal(){
        long startTime=System.currentTimeMillis();
        String message = "DELETE,"+startTime;
        kafkaTemplate.send(topic,message);
        return "delete personal was called";
    }
}
