package com.lsn.test;

import java.io.IOException;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

public class CreateSendGridDomain {
	public static void main(String[] args) throws IOException {
		try {
			SendGrid sg = new SendGrid("SG.DREulPO9TRmufQ1hQebdQg.ucFH9BSslfzdK-iCsvsDbP0v6lbLfIfv2ciXQqj1");
			Request request = new Request();

			request.setEndpoint("whitelabel/domains");
			request.setBody(
					"{\"automatic_security\":false,\"username\":\"kespwwt@mktng.info\",\"domain\":\"aakulasaikiran@gmail.com\",\"default\":true,\"custom_spf\":true,\"ips\":[\"192.168.1.1\",\"192.168.1.2\"],\"subdomain\":\"aakulasaikiran\"}");
			request.setMethod(Method.POST);
			Response response = sg.api(request);
			System.out.println(response.getStatusCode());
			System.out.println(response.getBody());
			System.out.println(response.getHeaders());
		} catch (IOException ex) {
			throw ex;
		}
	}
}