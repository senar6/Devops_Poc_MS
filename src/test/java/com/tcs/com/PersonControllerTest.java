package com.tcs.com;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.tcs.spring.PersonController;
import com.tcs.spring.model.Person;
import com.tcs.spring.service.PersonService;

public class PersonControllerTest {

	private MockMvc mockMvc;
	@Mock
	private PersonService personservice;
	@InjectMocks
	private PersonController personcontroller;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(personcontroller).build();
	}

	@Test
	public void test_get_all_success() throws Exception {
		List<Person> users = Arrays.asList(new Person(1, "John", "India"),
				new Person(2, "Snow", "India"));

		when(personservice.listPersons()).thenReturn(users);

		mockMvc.perform(get("/emp")).andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(2)))
				.andExpect(jsonPath("$[0].id", is(1)))
				.andExpect(jsonPath("$[0].name", is("John")))
				.andExpect(jsonPath("$[0].country", is("India")))
				.andExpect(jsonPath("$[1].id", is(2)))
				.andExpect(jsonPath("$[1].name", is("Snow")))
				.andExpect(jsonPath("$[1].country", is("India")));

		verify(personservice, times(1)).listPersons();
		verifyNoMoreInteractions(personservice);
	}

	

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
