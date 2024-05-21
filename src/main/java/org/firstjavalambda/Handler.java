package org.firstjavalambda;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

import java.util.Map;
import java.util.HashMap;

public class Handler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent request, Context context) {
        Map<String, String> queryStringParameters = request.getQueryStringParameters();

        String message = queryStringParameters != null ? queryStringParameters.get("message") : "Hello world!";
        
        Map<String, String> responseMap = new HashMap<>();
        responseMap.put("message", message);

        String responseJson;
        try {
            responseJson = objectMapper.writeValueAsString(responseMap);
        } catch (Exception e) {
            e.printStackTrace();
            responseJson = "{}";
        }

        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
        response.setStatusCode(200);
        response.setHeaders(Map.of("Content-Type", "application/json"));
        response.setBody(responseJson);

        return response;
    }
}