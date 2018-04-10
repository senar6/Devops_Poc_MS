package com.tcs.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tcs.spring.dao.PersonDAO;
import com.tcs.spring.model.BaseResponse;
import com.tcs.spring.model.Person;

@Service
public class PersonServiceImpl implements PersonService {
	
	private PersonDAO personDAO;

	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}

//	@Override
//	@Transactional
//	public void addPerson(Person p) {
//		this.personDAO.addPerson(p);
//	}
//
//	@Override
//	@Transactional
//	public void updatePerson(Person p) {
//		this.personDAO.updatePerson(p);
//	}

	@Override
	@Transactional
	public List<Person> listPersons() {
		return this.personDAO.select();
	}
	@Override
	public BaseResponse authenticate(String user, String password) {
		// TODO Auto-generated method stub
		return this.personDAO.authenticate(user, password);
	}
//	@Override
//	@Transactional
//	public Person getPersonById(int id) {
//		return this.personDAO.getPersonById(id);
//	}
//
//	@Override
//	@Transactional
//	public void removePerson(int id) {
//		this.personDAO.removePerson(id);
//	}

	@Override
	public boolean acknowledgeUser(String user, Date date) {
		// TODO Auto-generated method stub
		return this.personDAO.acknowledgeUser(user, date);
	}

}