package com.lsn.test;

import java.io.IOException;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

public class UpdateSpecificUserSendGridDomain {
	public static void main(String[] args) throws IOException {
		
		try {
			SendGrid sg = new SendGrid("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");
			 Request request = new Request();
		      request.setMethod(Method.PATCH);
		      request.setEndpoint("whitelabel/domains/2220754");
		      request.setBody("{\"default\":false,\"custom_spf\":false}");
		      Response response = sg.api(request);
		      System.out.println(response.getStatusCode());
		      System.out.println(response.getBody());
		      System.out.println(response.getHeaders());
		    } catch (IOException ex) {
		      throw ex;
		    }
		  }
		
		
		
		
		
		
		
			   /* try {
			    	SendGrid sg = new SendGrid("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");
					 Request request = new Request();
			      request.setMethod(Method.GET);
			     // request.setEndpoint("whitelabel/domains/subuser");
			      request.setEndpoint("whitelabel/domains");
			      request.addQueryParam("username", "kespl_wuwwt@mktng.info");
			      Response response = sg.api(request);
			      System.out.println(response.getStatusCode());
			      System.out.println(response.getBody());
			      System.out.println(response.getHeaders());
			    } catch (IOException ex) {
			      System.out.println(ex);
			    }
			  }*/
			
		
		
		
		
		
		
		// Retrieve a domain whitelabel.
		// GET /whitelabel/domains/{domain_id}


		
		  /*  try {
		    	SendGrid sg = new SendGrid("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");
				Request request = new Request();
		      request.setMethod(Method.GET);
		      request.setEndpoint("whitelabel/domains/2220754");
		      Response response = sg.api(request);
		      System.out.println(response.getStatusCode());
		      System.out.println(response.getBody());
		      System.out.println(response.getHeaders());
		    } catch (IOException ex) {
		      throw ex;
		    }
		  }
		}
	*/
	
}