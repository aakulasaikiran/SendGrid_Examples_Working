package com.websystique.springmvc.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.websystique.springmvc.model.User;
import com.websystique.springmvc.service.UserService;

@RestController
public class HelloWorldRestController {

	@Autowired
	UserService userService; // Service which will do all data retrieval/manipulation work

	// -------------------Retrieve All Users--------------------------------------------------------

	@RequestMapping(value = "/user/", method = RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsers() {
		List<User> users = userService.findAllUsers();
		if (users.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
			// You
	       // many
		 // decide
		// to
	  // return
	// HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	// -------------------Retrieve Single User--------------------------------------------------------

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = { 
			MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<User> getUser(@PathVariable("id") long id) {
		System.out.println("Fetching User with id " + id);
		User user = userService.findById(id);
		if (user == null) {
			System.out.println("User with id " + id + " not found");
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	// -------------------Create a User--------------------------------------------------------

	@RequestMapping(value = "/user/", method = RequestMethod.POST)
	public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating User " + user.getName());

		if (userService.isUserExist(user)) {
			System.out.println("A User with name " + user.getName() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		userService.saveUser(user);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	// ------------------- Update a User --------------------------------------------------------

	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
		System.out.println("Updating User " + id);

		User currentUser = userService.findById(id);

		if (currentUser == null) {
			System.out.println("User with id " + id + " not found");
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}

		currentUser.setName(user.getName());
		currentUser.setAge(user.getAge());
		currentUser.setSalary(user.getSalary());

		userService.updateUser(currentUser);
		return new ResponseEntity<User>(currentUser, HttpStatus.OK);
	}

	// ------------------- Delete a User --------------------------------------------------------

	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<User> deleteUser(@PathVariable("id") long id) {
		System.out.println("Fetching & Deleting User with id " + id);

		User user = userService.findById(id);
		if (user == null) {
			System.out.println("Unable to delete. User with id " + id + " not found");
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}

		userService.deleteUserById(id);
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}

	// ------------------- Delete All Users --------------------------------------------------------

	@RequestMapping(value = "/user/", method = RequestMethod.DELETE)
	public ResponseEntity<User> deleteAllUsers() {
		System.out.println("Deleting All Users");

		userService.deleteAllUsers();
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}
	
	
	
	
	
	
	
	@RequestMapping(value = "/createSendGridDomain", method = RequestMethod.GET)
	public ModelAndView createSendGridDomain(ModelAndView model) {
		
		System.out.println("inside createSendGridDomain");
		//String URL="https://api.sendgrid.com/v3/whitelabel/ips{?limit,offset,ip} HTTP/1.1";
			
		
		//SendGrid sendgrid = new SendGrid("SENDGRID_APIKEY");
		
		
		 try {
		      SendGrid sg = new SendGrid("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");
			// SendGrid sg = new SendGrid(System.getenv("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"));
			 Request request = new Request();
		      request.setMethod(Method.POST);
		      request.setEndpoint("whitelabel/domains");
		      request.setBody("{\"automatic_security\":false,\"username\":\"aakulasaikiran\",\"domain\":\"440saiias@gmail.com\",\"default\":true,\"custom_spf\":true,\"subdomain\":\"440saiias@gmail.com\"}");
		      Response response = sg.api(request);
		      System.out.println(response.getStatusCode());
		      System.out.println(response.getBody());
		      System.out.println(response.getHeaders());
		    } catch (IOException ex) {
		    	ex.printStackTrace();
		    	System.out.println(ex);
		      
		    }
		
		
		
		
		
		
		
		
		
		
		
		
		/*try {
		      SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
		      Request request = new Request();
		      request.setMethod(Method.GET);
		      request.setEndpoint("whitelabel/domains");
		      request.addQueryParam("username", "test_string");
		      request.addQueryParam("domain", "test_string");
		      request.addQueryParam("exclude_subusers", "true");
		      request.addQueryParam("limit", "1");
		      request.addQueryParam("offset", "1");
		      Response response = sg.api(request);
		      System.out.println(response.getStatusCode());
		      System.out.println(response.getBody());
		      System.out.println(response.getHeaders());
		    } catch (IOException ex) {
		      
		    }*/
    // System.out.println(sendgrid);
		
			//model.addObject("employee", newEmployee);
			model.setViewName("SendGrid");
			
			return model;

		}
		
	
	
	
	
	
	
	
	@RequestMapping(value = "/listSendGridDomain", method = RequestMethod.GET)
	public ModelAndView listSendGridDomain(ModelAndView model) {
	 try {
	     // SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
	      SendGrid sg = new SendGrid("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");
			
	      Request request = new Request();
	      request.setMethod(Method.GET);
	      request.setEndpoint("whitelabel/domains");
	      request.addQueryParam("username", "aakulasaikiran");
	      request.addQueryParam("domain", "440saiias@gmail.com");
	      
	      request.addQueryParam("exclude_subusers", "true");
	      request.addQueryParam("limit", "1");
	      request.addQueryParam("offset", "1");
	      Response response = sg.api(request);
	      System.out.println(response);
	      System.out.println(response.toString());
	      System.out.println(response.getStatusCode());
	      System.out.println(response.getBody());
	      System.out.println(response.getHeaders());
	      System.out.println(response.getHeaders());
	    } catch (IOException ex) {
	      System.out.println(ex);
	    }
	 model.setViewName("SendGrid");
	return model;
		
	}
}


