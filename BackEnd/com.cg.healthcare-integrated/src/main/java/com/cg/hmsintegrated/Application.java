package com.cg.hmsintegrated;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*******************************************************************************************************************************
-Author                   :     Piyush Srivastav
-Created/Modified Date    :     26-11-2020
-Description              :     Main Application Class 

*******************************************************************************************************************************/

@SpringBootApplication(scanBasePackages = {"com.cg.hmsintegrated"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
