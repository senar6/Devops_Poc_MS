package com.tcs.spring;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tcs.spring.model.AcknowledgeUser;
import com.tcs.spring.model.BaseResponse;
import com.tcs.spring.model.Person;
import com.tcs.spring.model.Users;
import com.tcs.spring.service.PersonService;

@Controller
public class PersonController {

	private PersonService personService;

	
	@Autowired(required = true)
	@Qualifier(value = "personService")
	public void setPersonService(PersonService ps) {
		this.personService = ps;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String redirect(Model model) {
		return "redirect:/welcome";
	}

	@RequestMapping(value="/test",method = RequestMethod.GET, headers="Accept=application/json")
	public ResponseEntity<List<Person>> generateJsonResponses() {
		List<Person> e = personService.listPersons();//new Person(1001, "Papun", "india");
		return new ResponseEntity<List<Person>>(e,HttpStatus.OK);
	}
	@RequestMapping(value="/emp",method = RequestMethod.GET)
	public @ResponseBody
	List<Person> generateJsonResponse() {
		List<Person> e = personService.listPersons();//new Person(1001, "Papun", "india");
		return e;
	}
	@RequestMapping(value="/authenticate",method = RequestMethod.POST, consumes ="application/json",produces = "application/json")
	public ResponseEntity<BaseResponse> generateJsonResponses(@RequestBody Users userdetails) {
		String user= userdetails.getUser().trim();
		String password= userdetails.getPassword().trim();
    //List
		BaseResponse details = personService.authenticate(user, password);//new Person(1001, "Papun", "india");
		return new ResponseEntity<BaseResponse>(details,HttpStatus.OK);
	}
	@RequestMapping(value="/acknowledge",method = {RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody
	BaseResponse acknowledgeUser(@RequestBody AcknowledgeUser userdetails) {
		BaseResponse reponse= new BaseResponse();
		String user= userdetails.getUser().trim();
		String Datestring = userdetails.getDatetime();
		DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
		Date date = null;
		try {
			date = format.parse(Datestring);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    //List
		boolean ack = personService.acknowledgeUser(user, date);
		if(ack== true){//new Person(1001, "Papun", "india");
			reponse.setSuccess(true);
		
		}
		else{
			reponse.setSuccess(true);
		}
		return reponse;
	}
	@RequestMapping(value="/authenticates",method = {RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody
	BaseResponse generateJsonResponse(@RequestBody Users userdetails) {
		String user= userdetails.getUser().trim();
		String password= userdetails.getPassword().trim();
    //List
		BaseResponse details = personService.authenticate(user, password);//new Person(1001, "Papun", "india");
		return details;
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String listPersons(Model model) {
	//	model.addAttribute("person", new Person());
	//	model.addAttribute("listPersons", this.personService.listPersons());
		return "demo";
	}

	// For add and update person both
	// @RequestMapping(value= "/person/add", method = RequestMethod.POST)
	// public String addPerson(@ModelAttribute("person") Person p){
	//
	// if(p.getId() == 0){
	// //new person, add it
	// this.personService.addPerson(p);
	// }else{
	// //existing person, call update
	// this.personService.updatePerson(p);
	// }
	//
	// return "redirect:/persons";
	//
	// }
	//
	// @RequestMapping("/remove/{id}")
	// public String removePerson(@PathVariable("id") int id){
	//
	// this.personService.removePerson(id);
	// return "redirect:/persons";
	// }
	//
	// @RequestMapping("/edit/{id}")
	// public String editPerson(@PathVariable("id") int id, Model model){
	// model.addAttribute("person", this.personService.getPersonById(id));
	// model.addAttribute("listPersons", this.personService.listPersons());
	// return "person";
	// }

}