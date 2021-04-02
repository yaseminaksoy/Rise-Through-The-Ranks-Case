package com.caseKartaca.caseKartaca;
import com.caseKartaca.caseKartaca.entity.Data;
import com.caseKartaca.caseKartaca.repository.DataRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaListenerService {
    @Autowired
    private DataRepository dataRepository;
    @KafkaListener(
            topics = "${caseKartaca.caseKartaca.topic}",
            groupId = "${caseKartaca.caseKartaca.group.id}"
    )

    public void listen(@Payload String message) {
        String[] messageArray=message.split(",");
        long startTime = Long.parseLong(messageArray[1]);
        long endTime = System.currentTimeMillis();
        long responseTime = endTime-startTime;
        log.info("Message received.. Message : {} ",
                messageArray[0]+", "+responseTime+" ms");
        Data data = new Data();
        data.setMethodName(messageArray[0]);
        data.setResponseTime(responseTime+" ms");
        dataRepository.save(data);
    }
}
