package com.lsn.test;

import java.io.IOException;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

public class ValidateSendGridDomain {
	public static void main(String[] args) throws IOException {
		
		
		try {
			SendGrid sg = new SendGrid("SG.DREulPO9TRmufQ1hQebdQg.FH9BSslfzdK-iCsvsDbP0v6lbLfIfv2ciXQqj1MpI");
			Request request = new Request();
		      request.setMethod(Method.POST);
		      request.setEndpoint("whitelabel/domains/220754/validate");
		      Response response = sg.api(request);
		      System.out.println(response.getStatusCode());
		      System.out.println(response.getBody());
		      System.out.println(response.getHeaders());
		    } catch (IOException ex) {
		      throw ex;
		    }
		  
		
		
		
		
		
		
		
		
		
		
		/*
			    try {
			    	SendGrid sg = new SendGrid("SG.DREulPO9TRmufhQebdQg.ucFH9BSslfzdK-iCsvsDbP0v6lbLfIfv2ciXQqj1MpI");
					 Request request = new Request();
			      request.setMethod(Method.GET);
			     // request.setEndpoint("whitelabel/domains/subuser");
			      request.setEndpoint("whitelabel/domains");
			      request.addQueryParam("username", "kespl_wuwwt@mtng.info");
			      Response response = sg.api(request);
			      System.out.println(response.getStatusCode());
			      System.out.println(response.getBody());
			      System.out.println(response.getHeaders());
			    } catch (IOException ex) {
			      System.out.println(ex);
			    }
			  }
			
*/
	
}
}