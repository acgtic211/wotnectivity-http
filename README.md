# WoTnectivity-http
Implementation of WoTnectivity Requester to manage HTTP requests

## Installation Method

If you want to compile your own source code, you will need to add the generated .jar to the local mvn repository.

```console
foo@bar:~$ mvn install:install-file "-Dfile=wotnectivity-0.0.1-ALPHA-SNAPSHOT.jar" "-DgroupId=es.ual.acg" "-DartifactId=wotnectivity-http" "-Dversion=0.0.1-ALPHA-SNAPSHOT" "-Dpackaging=jar"
```

After installing it to your local maven repository you will only need to add it to the dependencies of the project where you want to use it.

```xml
<dependency>
    <groupId>es.ual.acg</groupId>
    <artifactId>wotnectivity-http</artifactId>
    <version>0.0.1-ALPHA-SNAPSHOT</version>
</dependency>
```

## Use Example

In the next fragment of code you can see a use case of `HttpReq`.

```java
String address = "https://postman-echo.com/post";
String payload = "{\"body\":\"example request\"}";
String parameterMethodType="POST";
String parameterContentType="text/plain";
String parameterAuthorization="authkey";

HashMap<String, Object> configuration = new HashMap<>();
configuration.put("MethodType", parameterMethodType);
configuration.put("content-type", parameterContentType);
configuration.put("Authorization", parameterAuthorization);

HttpReq tester = new HttpReq();

try{
    var response = tester.sendRequest(address, configuration, payload).get();
    System.out.println(response);
}catch(Exception e){
    System.out.println(e.getMessage());
}
```

The configuration parameter of the request needs to have at least one parameter `MethodType` where the type of request will be declared, everything else is considered a parameter of the header of the request.

