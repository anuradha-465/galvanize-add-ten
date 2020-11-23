package com.bootcamp.addTen.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.addTen.model.AddTenResponse;

@RestController
@RequestMapping("/api")
public class AddTenController {

	private static final Logger addTenControllerLog = LogManager.getLogger(AddTenController.class);

	@GetMapping( value ="/addTen/{number}" , produces = { "application/json" })
	public ResponseEntity<AddTenResponse> addTen(@PathVariable("number") String number) throws Exception {
		try {
			addTenControllerLog.debug(number);	
			AddTenResponse response = new AddTenResponse(Integer.parseInt(number) +10);
			return new ResponseEntity<AddTenResponse>(response, HttpStatus.OK); 
		} catch (Exception e) {
			addTenControllerLog.error("Error when adding Ten to number ", e.getMessage());	
			throw e;
		}
	}


}
