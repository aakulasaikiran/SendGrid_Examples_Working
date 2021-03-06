package com.lsn.test;
import java.io.IOException;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

// Get the default domain whitelabel.
// GET /whitelabel/domains/default


public class GetAllDefault {
  public static void main(String[] args) throws IOException {
    try {
    	SendGrid sg = new SendGrid("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");
		 Request request = new Request();
      request.setMethod(Method.GET);
     // request.addQueryParam("exclude_subusers", "true");
     request.setEndpoint("whitelabel/domains");
      Response response = sg.api(request);
      System.out.println(response.getStatusCode());
      System.out.println(response.getBody());
      System.out.println(response.getHeaders());
    } catch (IOException ex) {
      throw ex;
    }
  }
}