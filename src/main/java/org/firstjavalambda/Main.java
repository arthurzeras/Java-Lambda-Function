package org.firstjavalambda;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

// This file is only used to test the function using IDE
public class Main {
    public static void main(String[] args) {
        Handler handler = new Handler();

        APIGatewayProxyRequestEvent request = new APIGatewayProxyRequestEvent();

        APIGatewayProxyResponseEvent response = handler.handleRequest(request, null);

        System.out.println(response.getBody());
    }
}
