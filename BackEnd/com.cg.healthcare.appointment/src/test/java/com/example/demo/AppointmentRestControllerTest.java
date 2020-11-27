package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.hms.entity.StatusEntity;
import com.cg.hms.model.AppointmentModel;
import com.cg.hms.service.AppointmentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/*******************************************************************************************************************************
-Author                   :     Piyush Srivastav
-Created/Modified Date    :     26-11-2020
-Description              :     Test Class Junit5 Testing

*******************************************************************************************************************************/

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {com.cg.hms.Application.class})
@AutoConfigureMockMvc 
//@WebMvcTest(value=com.cg.hms.Application.class)
public class AppointmentRestControllerTest {
	@Autowired
    private MockMvc mockMvc;
 
	@MockBean
	private AppointmentService appointmentService;
	
	@Test
    public void testMakeAppointment() throws Exception {
        AppointmentModel mockAppointmentModel = new AppointmentModel();
        mockAppointmentModel.setAppointmentId(1);
        mockAppointmentModel.setUserId("03");
        mockAppointmentModel.setCentreId("104");
        mockAppointmentModel.setDateTime("2020-12-27 14:30");
        mockAppointmentModel.setTestId("t107");
        mockAppointmentModel.setStatus(StatusEntity.pending);
        
        String inputJson = this.mapToJson(mockAppointmentModel);
        
        String URI = "/api/v1/appointment/makeappointment";
        
        Mockito.when(appointmentService.makeAppointment(Mockito.any(AppointmentModel.class))).thenReturn(mockAppointmentModel);
        
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON_VALUE).content(inputJson);
        
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        
        MockHttpServletResponse response =result.getResponse();
        String outputJson = response.getContentAsString();
//        System.out.println(outputJson);
        
        assertThat(outputJson).isEqualTo(inputJson);
//        assertThat(HttpStatus.OK.value(),response.getStatus());
        //        assertThat(HttpStatus.OK.value(),response.getStatus());

    }
	
	
//	Maps Object to Json String using Jackson ObjectMapper
	
	private String mapToJson(Object object) throws JsonProcessingException{
		ObjectMapper om = new ObjectMapper();
		return om.writeValueAsString(object);
	}
}
