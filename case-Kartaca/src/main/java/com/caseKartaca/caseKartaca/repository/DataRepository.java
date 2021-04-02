package com.caseKartaca.caseKartaca.repository;

import com.caseKartaca.caseKartaca.entity.Data;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DataRepository extends MongoRepository<Data,String> {
}
