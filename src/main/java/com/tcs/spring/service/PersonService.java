package com.tcs.spring.service;


import java.util.Date;
import java.util.List;

import com.tcs.spring.model.BaseResponse;
import com.tcs.spring.model.Person;

public interface PersonService {

	public List<Person> listPersons();
	public BaseResponse authenticate(String user, String password);
	public boolean acknowledgeUser(String user, Date date);
	
}