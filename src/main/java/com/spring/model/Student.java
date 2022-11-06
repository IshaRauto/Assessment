package com.spring.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection ="stud")
@Getter
@Setter
@NoArgsConstructor

public class Student {
	@Id
    private  String id;
	private int s_id;
	private String name;
	private String language ;
	private String framework;
	
	
}
