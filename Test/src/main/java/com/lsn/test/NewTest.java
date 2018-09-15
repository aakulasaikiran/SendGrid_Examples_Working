package com.lsn.test;

import java.io.IOException;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

public class NewTest {
public static void main(String[] args) {
	try {
		 SendGrid sg = new SendGrid("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");
			 Request request = new Request();
	    request.setMethod(Method.POST);
	    request.setEndpoint("whitelabel/domains");
	    request.setBody("{\"automatic)_security\":false,\"username\":\"aakula saikiran\",\"domain\":\"example.com\",\"default\":true,\"custom_spf\":true,\"ips\":[\"192.168.1.164\"],\"subdomain\":\"news\"}");
	    Response response = sg.api(request);
	    System.out.println(response.getStatusCode());
	    System.out.println(response.getBody());
	    System.out.println(response.getHeaders());
	  } catch (IOException ex) {
	   System.out.println(ex);
	  }
}
}
