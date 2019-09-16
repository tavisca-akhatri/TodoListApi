package com.TodoListApi.TodoList;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

public class TodoListApplicationTests {

	@Autowired
	private MockMvc mvc;
	
	@InjectMocks
	private TodoListController controller;


	
    @Before
	public void setup() {
		MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	@Test
	public void getRequestTest() throws Exception {
		mvc.perform(get("/todo").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}

	@Test
	public void postRequestTest() throws Exception {
		String json = "{\"id\":\"4\",\"item\":\"wakeup\"}";
		mvc.perform(post("/todo")
		.content(json)
		.contentType(MediaType.APPLICATION_JSON)
		.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}
	
	@Test
	public void putRequestTest() throws Exception {
		String json = "{\"id\":\"2\",\"item\":\"wakeup\"}";
		long id = 2;
		mvc.perform(put("/todo/"+id)
		 .content(json).contentType(MediaType.APPLICATION_JSON)
		 .accept(MediaType.APPLICATION_JSON))
		 .andExpect(status().isOk());
	}
	
	@Test
	public void deleteRequestTest() throws Exception {
			mvc.perform(delete("/todo/2")
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
	}
	
}
