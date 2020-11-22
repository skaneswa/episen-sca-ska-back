package com.example.demo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

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
			Path path = Paths.get("orders.txt");
			if(!Files.exists(path, LinkOption.NOFOLLOW_LINKS)) {
				 File f = new File("orders.txt");
				 f.createNewFile();
			}
			Files.write(Paths.get("orders.txt"), (name + "\n").getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping(value = "/get/order")
	public List<String> getOrder() {
		Path path = Paths.get("orders.txt");
		if(Files.exists(path, LinkOption.NOFOLLOW_LINKS)) {
			try {
				return Files.readAllLines(Paths.get("orders.txt"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;

	}

}
