package springmvc_with_h2;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mvc-servlet.xml")
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserControllerTest {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void method3_getUsersTest() throws Exception {
		MvcResult mvcResult = this.mockMvc.perform(get("/getUsers")).andExpect(view().name("UsersList"))
				.andExpect(model().attributeExists("usersList"))
				.andExpect(model().attribute("usersList", Matchers.hasSize(3))).andDo(MockMvcResultHandlers.print())
				.andReturn();
		assertEquals(200, mvcResult.getResponse().getStatus());
	}

	@Test
	public void method1_uploadFileViewTest() throws Exception {
		this.mockMvc.perform(get("/uploadFile")).andExpect(view().name("UploadFile"));
	}

	@Test
	public void method2_uploadFileTest() throws Exception {
		MockMultipartFile jsonFile = new MockMultipartFile("file", "", "application/json",
				"[{\"firstName\":\"a\",\"lastName\":\"b\",\"phoneNumber\":\"987\",\"phoneCompany\":\"vodafone\"},{\"firstName\":\"c\",\"lastName\":\"d\",\"phoneNumber\":\"654\",\"phoneCompany\":\"aircel\"}]"
						.getBytes());
		this.mockMvc.perform(multipart("/uploadFile").file(jsonFile)).andExpect(view().name("index"));
	}

}
