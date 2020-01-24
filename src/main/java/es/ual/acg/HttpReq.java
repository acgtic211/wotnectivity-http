package es.ual.acg;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;
import java.util.ArrayList;
import java.util.List;

import java.net.http.*;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.URI;


/**
 * This is a class used to send HTTP request.
 *
 * @see java.lang.Object
 * @author Manel Mena
 */
public class HttpReq implements IRequester {

    private HttpClient client;

    
    /** 
     * Default constructor of the class HttpReq.
     * @return 
     */
    public HttpReq() {
        this.client = HttpClient.newHttpClient();
    }

    
    /** 
     * @param address
     * @param headers
     * @param payload
     * @return CompletableFuture<String>
     */
    private CompletableFuture<String> sendPostRequest(String address, HashMap<String, Object> headers, String payload) {
            

            List<String> headersArrayList =  new ArrayList<>();
            headers.forEach((k,v)-> {headersArrayList.add(k); headersArrayList.add(v.toString());});
            String[] headersArray = new String[headersArrayList.size()];

            
            var request = HttpRequest.newBuilder()
                            .POST(BodyPublishers.ofString(payload))
                            .uri(URI.create(address))
                            .headers(headersArrayList.toArray(headersArray))
                            .build();
                            
        
            return client.sendAsync(request, BodyHandlers.ofString())
                            .thenApply(HttpResponse::body)
                            .exceptionally(e -> "Error: " + e.getMessage());

    }

    
    /** 
     * @param address
     * @param headers
     * @return CompletableFuture<String>
     */
    private CompletableFuture<String> sendGetRequest(String address, HashMap<String, Object> headers) {

        List<String> headersArrayList =  new ArrayList<>();
        headers.forEach((k,v)-> {headersArrayList.add(k); headersArrayList.add(v.toString());});
        String[] headersArray = new String[headersArrayList.size()];

        
        var request = HttpRequest.newBuilder()
                        .GET()
                        .uri(URI.create(address))
                        .headers(headersArrayList.toArray(headersArray))
                        .build();
                        
    
        return client.sendAsync(request, BodyHandlers.ofString())
                        .thenApply(HttpResponse::body)
                        .exceptionally(e -> "Error: " + e.getMessage());

    }
    
    
    /** 
     * @param address
     * @param headers
     * @param payload
     * @return CompletableFuture<String>
     */
    private CompletableFuture<String> sendPutRequest(String address, HashMap<String, Object> headers, String payload) {


        List<String> headersArrayList =  new ArrayList<>();
        headers.forEach((k,v)-> {headersArrayList.add(k); headersArrayList.add(v.toString());});
        String[] headersArray = new String[headersArrayList.size()];

        var request = HttpRequest.newBuilder()
                        .PUT(BodyPublishers.ofString(payload))
                        .uri(URI.create(address))
                        .headers(headersArrayList.toArray(headersArray))
                        .build();
                        
    
        return client.sendAsync(request, BodyHandlers.ofString())
                        .thenApply(HttpResponse::body)
                        .exceptionally(e -> "Error: " + e.getMessage());

    }

    
    /** 
     * @param address
     * @param headers
     * @return CompletableFuture<String>
     */
    private CompletableFuture<String> sendDeleteRequest(String address, HashMap<String, Object> headers) {

        List<String> headersArrayList =  new ArrayList<>();
        headers.forEach((k,v)-> {headersArrayList.add(k); headersArrayList.add(v.toString());});
        String[] headersArray = new String[headersArrayList.size()];

        var request = HttpRequest.newBuilder()
                        .DELETE()
                        .uri(URI.create(address))
                        .headers(headersArrayList.toArray(headersArray))
                        .build();
                        
    
        return client.sendAsync(request, BodyHandlers.ofString())
                        .thenApply(HttpResponse::body)
                        .exceptionally(e -> "Error: " + e.getMessage());

    }

    
    /**
     * This method send an HTTP request to an address
     * @param address the address where the request is going to be sent.
     * @param configuration contains the parameters of the HTTP request, in this case the methodType as well as the headers.
     * @param payload contains the message sent to the server.
     * @return CompletableFuture<?>
     */
    @Override
    public CompletableFuture<?> sendRequest(String address, HashMap<String, Object> configuration, Object payload) {
        String methodType = configuration.get("MethodType").toString();
        configuration.remove("MethodType");
        CompletableFuture<String> output;

        if (methodType.equals("POST")){
            output = this.sendPostRequest(address, configuration, payload.toString());
        }else if (methodType.equals("PUT")){
            output = this.sendPutRequest(address, configuration, payload.toString());
        }else if (methodType.equals("DELETE")){
            output = this.sendDeleteRequest(address, configuration);
        }else if (methodType.equals("GET")){
            output = this.sendGetRequest(address, configuration);
        }else{
            output = null;
        }

        return output;
    }

}