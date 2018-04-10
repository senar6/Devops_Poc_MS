package com.tcs.spring.dao;

import java.util.Date;
import java.util.List;

import com.tcs.spring.model.BaseResponse;
import com.tcs.spring.model.Person;
import com.tcs.spring.model.WorkOrder;


public interface PersonDAO {

	public BaseResponse authenticate(String email,String password);
	public List<Person> select();
	public List<WorkOrder> getWordOrderDetails(String userid);
	public boolean acknowledgeUser(String user, Date date);
}