package com.lsn.test;

import java.io.IOException;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

public class GetdefaultSendGridDomain {
	public static void main(String[] args) throws IOException {

		try {
			SendGrid sg = new SendGrid("SG.DREulPO9TRmufQ1hQebdQg.FH9BSslfzdK-iCsvsDbP0v6lbLfIfv2ciXQqj1MpI");
			Request request = new Request();
			request.setMethod(Method.GET);
			request.setEndpoint("whitelabel/domains/default");
			Response response = sg.api(request);
			System.out.println(response.getStatusCode());
			System.out.println(response.getBody());
			System.out.println(response.getHeaders());
		} catch (IOException ex) {
			throw ex;
		}
	}
}
