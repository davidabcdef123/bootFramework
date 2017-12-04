package com.dave.sun.dao.mongo.second;

import com.dave.sun.vo.SecondaryMongoObject;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SecondaryRepository extends MongoRepository<SecondaryMongoObject, String> {
}
