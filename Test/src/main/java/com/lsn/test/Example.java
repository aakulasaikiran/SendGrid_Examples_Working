package com.lsn.test;
import java.io.IOException;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

public class Example {
	public static void main(String[] args) throws IOException {
		try {
			SendGrid sg = new SendGrid("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");
			Request request = new Request();
			
			request.setEndpoint("whitelabel/domains");
			 request.setBody("{\"automatic_security\":false,\"username\":\"kespl_wuwwt@mktng.info\",\"domain\":\"aakulasaikiran9400@gmail.com\",\"default\":true,\"custom_spf\":true,\"ips\":[\"192.168.1.1\",\"192.168.1.2\"],\"subdomain\":\"aakulasaikiran940\"}");
			 request.setMethod(Method.POST);
			
			
			/*request.setBody(
					"{\"automatic_security\":false,\"username\":\"aakulasaikiran\",\"domain\":\"aakulasaikiran9400@gmail.com\",\"default\":true,\"custom_spf\":true,\"subdomain\":\"aakulasaikiran9400\"}");
			*///request.addQueryParam("exclude_subusers", "true");
			
			/*request.addQueryParam("exclude_errors", "true");
			request.addQueryParam("exclude_message", "true");*/
			Response response = sg.api(request);
			System.out.println(response.getStatusCode());
			System.out.println(response.getBody());
			System.out.println(response.getHeaders());
		} catch (IOException ex) {
			throw ex;
		}
	}
}