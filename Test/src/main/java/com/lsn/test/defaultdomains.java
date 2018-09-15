package com.lsn.test;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

public class defaultdomains {
	  public static void main(String[] args) throws Exception {
	    try {
	    	SendGrid sg = new SendGrid("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");
			 Request request = new Request();
	      request.setMethod(Method.GET);
	      request.setEndpoint("whitelabel/domains/default");
	      Response response = sg.api(request);
	      System.out.println(response.getStatusCode());
	      System.out.println(response.getBody());
	      System.out.println(response.getHeaders());
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	  }
	}