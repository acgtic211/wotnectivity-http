package es.ual.acg;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.HashMap;

public class HttpReqTest{

    @Test
    public void TestPostReq() {
        String address = "https://postman-echo.com/post";
        HashMap<String, Object> headers = new HashMap<>();
        HashMap<String, Object> headers2 = new HashMap<>();
        
        String parameterMethodType="POST";
        String parameterContentType="text/plain";
        String parameterAuthorization="authkey";
        String alternateParameterMethodType = "POST";
        String alternateParameterContentType="application/json";
        String alternateParameterAuthorization="authkey2";

        headers.put("MethodType", parameterMethodType);
        headers.put("content-type", parameterContentType);
        headers.put("Authorization", parameterAuthorization);
        headers2.put("MethodType", alternateParameterMethodType);
        headers2.put("content-type", alternateParameterContentType);
        headers2.put("Authorization", alternateParameterAuthorization);
        String payload = "{\"body\":\"vaya tela\"}";
        
        HttpReq tester = new HttpReq();

        try{
            var response = tester.sendRequest(address, headers, payload).get();
            var response2 = tester.sendRequest(address, headers2, payload).get();
            System.out.println(response);
            System.out.println(response2);
            assertNotEquals(response2,"");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }

    @Test
    public void TestGetReq() {
        String address = "https://postman-echo.com/get?q=hola";
        HashMap<String, Object> headers = new HashMap<>();
        HashMap<String, Object> headers2 = new HashMap<>();
        
        String parameterMethodType="GET";
        String parameterContentType="text/plain";
        String parameterAuthorization="authkey";
        String alternateParameterMethodType = "GET";
        String alternateParameterContentType="application/json";
        String alternateParameterAuthorization="authkey2";

        headers.put("MethodType", parameterMethodType);
        headers.put("content-type", parameterContentType);
        headers.put("Authorization", parameterAuthorization);
        headers2.put("MethodType", alternateParameterMethodType);
        headers2.put("content-type", alternateParameterContentType);
        headers2.put("Authorization", alternateParameterAuthorization);

        HttpReq tester = new HttpReq();
        try{
            var response = tester.sendRequest(address, headers,"").get();
            var response2 = tester.sendRequest(address, headers2, "").get();
            System.out.println(response);
            System.out.println(response2);
            assertNotEquals(response2,"");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }

    @Test
    public void TestPutReq() {
        String address = "https://postman-echo.com/put?q=adios";
        HashMap<String, Object> headers = new HashMap<>();
        HashMap<String, Object> headers2 = new HashMap<>();
        
        String parameterMethodType="PUT";
        String parameterContentType="text/plain";
        String parameterAuthorization="authkey";
        String alternateParameterMethodType = "PUT";
        String alternateParameterContentType="application/json";
        String alternateParameterAuthorization="authkey2";

        headers.put("MethodType", parameterMethodType);
        headers.put("content-type", parameterContentType);
        headers.put("Authorization", parameterAuthorization);
        headers2.put("MethodType", alternateParameterMethodType);
        headers2.put("content-type", alternateParameterContentType);
        headers2.put("Authorization", alternateParameterAuthorization);
        String payload = "{\"body\":\"BODYVALUE\"}";

        HttpReq tester = new HttpReq();
        try{
            var response = tester.sendRequest(address, headers, payload).get();
            var response2 = tester.sendRequest(address, headers2, payload).get();
            System.out.println(response);
            System.out.println(response2);
            assertNotEquals(response2,"");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }

    @Test
    public void TestDeleteReq() {
        String address = "https://postman-echo.com/delete";
        
        HashMap<String, Object> headers = new HashMap<>();
        HashMap<String, Object> headers2 = new HashMap<>();
        
        String parameterMethodType="DELETE";
        String parameterContentType="text/plain";
        String parameterAuthorization="authkey";
        String alternateParameterMethodType = "DELETE";
        String alternateParameterContentType="application/json";
        String alternateParameterAuthorization="authkey2";

        headers.put("MethodType", parameterMethodType);
        headers.put("content-type", parameterContentType);
        headers.put("Authorization", parameterAuthorization);
        headers2.put("MethodType", alternateParameterMethodType);
        headers2.put("content-type", alternateParameterContentType);
        headers2.put("Authorization", alternateParameterAuthorization);

        HttpReq tester = new HttpReq();
        try{
            var response = tester.sendRequest(address, headers, "").get();
            var response2 = tester.sendRequest(address, headers2, "").get();
            System.out.println(response);
            System.out.println(response2);
            assertNotEquals(response2,"");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
}