package com.cg.hms;

import static org.assertj.core.api.Assertions.assertThat;



import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;

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
        mockAppointmentModel.setUserId("01");
        mockAppointmentModel.setCentreId("102");
        mockAppointmentModel.setDateTime("2020-11-29 14:30");
        mockAppointmentModel.setTestId("t102");
        mockAppointmentModel.setStatus(StatusEntity.pending);
        
        String inputJson = this.mapToJson(mockAppointmentModel);
        
        String URI = "/api/v1/appointment/makeappointment";
        
        Mockito.when(appointmentService.makeAppointment(Mockito.any(AppointmentModel.class))).thenReturn(mockAppointmentModel);
        
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(inputJson);
        
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
