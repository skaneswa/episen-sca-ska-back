package com.example.demo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@CrossOrigin(origins="*", allowedHeaders="*")
public class Service {
	
	@PostMapping(value = "/add/order")
	@ResponseBody
	public void add_order(@RequestParam(value = "name", required = true) String name) {
		try {
			FileWriter file = new FileWriter("orders.txt");
			file.write(name);
			file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
