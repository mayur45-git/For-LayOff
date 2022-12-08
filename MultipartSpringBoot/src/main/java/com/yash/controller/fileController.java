package com.yash.controller;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.yash.model.User;
import com.yash.services.fileServices;

@RestController
public class fileController {

	@Autowired
	private fileServices services;
	private Logger logger = LoggerFactory.getLogger(fileController.class);

	@PostMapping("/uploadfiles")
	// @RequestMapping(path = "/uploadfiles", method = RequestMethod.POST, consumes
	// = MediaType.MULTIPART_FORM_DATA_VALUE)

	public ResponseEntity<?> uploadmultipleFiles(@RequestParam(value = "file", required = true) MultipartFile file,
			@RequestParam("name") String name, @RequestParam("city") String city) throws IOException {

		System.out.println(name + " " + city + " " + file.getSize());

		User user = new User();
		user.setName(name);
		user.setCity(city);
		user.setImageName(file.getBytes());
		// user.setImageName(file.getBytes());
		services.uploadfile(user);

		this.logger.info("number of file uploded=");

		return ResponseEntity.ok("file uploaded");
	}

	@GetMapping("/getdata")
	public List<User> getUserdata() {

		return services.findallUser();
	}

//	@PostMapping("/uploadFile")
//	public ResponseEntity<String> handleFileUpload(@RequestBody User user,@RequestParam("file") MultipartFile file)
//	{
//	     services.uploadfile(user);
//	    
//	    return ResponseEntity.ok().body("file received successfully");
//	}

}
