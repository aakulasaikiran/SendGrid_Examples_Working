package com.lsn.test;

import java.io.IOException;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

public class GetSpecificUserSendGridDomain {
	public static void main(String[] args) throws IOException {
		
		
			    try {
			    	SendGrid sg = new SendGrid("SG.DREulPO9TRmufQ1hQebdQg.ucFH9slfzdK-iCsvsDbP0v6lbLfIfv2ciXQqj1MpI");
					 Request request = new Request();
			      request.setMethod(Method.GET);
			     // request.setEndpoint("whitelabel/domains/subuser");
			      request.setEndpoint("whitelabel/domains");
			      request.addQueryParam("username", "kespl_wuwwmktng.info");
			      Response response = sg.api(request);
			      System.out.println(response.getStatusCode());
			      System.out.println(response.getBody());
			      System.out.println(response.getHeaders());
			    } catch (IOException ex) {
			      System.out.println(ex);
			    }
			  }
			
		
		
		
		
		
		
		// Retrieve a domain whitelabel.
		// GET /whitelabel/domains/{domain_id}


		
		  /*  try {
		    	SendGrid sg = new SendGrid("SG.DRlPO9TRmufQ1hQebdQg.ucFH9BSslfzdK-iCsvsDbP0v6lbLfIfv2ciXQqj1MpI");
				Request request = new Request();
		      request.setMethod(Method.GET);
		      request.setEndpoint("whitelabel/domains/220754");
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