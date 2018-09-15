package com.lsn.test;

import java.io.IOException;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

public class AddIPAddressToSpecificUser {
	public static void main(String[] args) throws IOException {
		
		
		 try {
			 SendGrid sg = new SendGrid("SG.DREulPO9TRmufQ1hQebdQg.ucFH9BSslfzdK-iCsvsDbP0v6lbLfIfv2ciXQqj1M");
				 Request request = new Request();
		      request.setMethod(Method.POST);
		      request.setEndpoint("whitelabel/domains/222075/ips");
		      request.setBody("{\"ip\":\"192.168.0.1\"}");
		      Response response = sg.api(request);
		      System.out.println(response.getStatusCode());
		      System.out.println(response.getBody());
		      System.out.println(response.getHeaders());
		    } catch (IOException ex) {
		      throw ex;
		    }
		  }
		
		
		
		
		
		
		
		
		
		
	
		// Retrieve a domain whitelabel.
		// GET /whitelabel/domains/{domain_id}


		
		   /* try {
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
