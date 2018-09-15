package com.lsn.test;
import java.io.IOException;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

public class Listalldomain {
  public static void main(String[] args) throws IOException {
	  try {
		     // SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
		  SendGrid sg = new SendGrid("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");
				
		      Request request = new Request();
		      request.setMethod(Method.GET);
		      request.setEndpoint("whitelabel/domains");
		     // request.addQueryParam("username", "aakulasaikiran");
		      request.addQueryParam("domain", "aakulasaikiran9400@gmail.com");
		      
		      request.addQueryParam("exclude_subusers", "true");
		      request.addQueryParam("limit", "1");
		      
		      request.addQueryParam("offset", "1");
		      Response response = sg.api(request);
		      System.out.println(response);
		     
		      System.out.println(response.getStatusCode());
		      System.out.println(response.getBody());
		      System.out.println(response.getHeaders());
		      
		    } catch (IOException ex) {
		      System.out.println(ex);
		    }
  }
}