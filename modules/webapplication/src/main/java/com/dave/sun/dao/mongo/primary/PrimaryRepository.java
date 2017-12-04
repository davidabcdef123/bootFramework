package com.dave.sun.dao.mongo.primary;

import com.dave.sun.vo.PrimaryMongoObject;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Super.Sun on 2017/12/4.
 */
public interface PrimaryRepository extends MongoRepository<PrimaryMongoObject, String> {
}
