package com.dave.sun.vo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "second_mongo")
public class SecondaryMongoObject {

	@Id
	private String id;

	private String value;

	public SecondaryMongoObject(String id, String value) {
		this.id = id;
		this.value = value;
	}

	@Override
	public String toString() {
        return "SecondaryMongoObject{" + "id='" + id + '\'' + ", value='" + value + '\''
				+ '}';
	}

}
