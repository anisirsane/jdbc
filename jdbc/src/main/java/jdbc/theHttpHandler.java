package jdbc;
import java.io.IOException;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.BufferedReader;
import java.io.InputStreamReader;
// https://docs.oracle.com/javase/8/docs/api/java/io/BufferedReader.html
// https://stackoverflow.com/questions/3732109/simple-http-server-in-java-using-only-java-se-api
//le tutoriel suit pour creer le serveur : https://dzone.com/articles/simple-http-server-in-java
class TheHttpHandler implements HttpHandler {    

  public static String requestBody;

  public TheHttpHandler() {
    //TODO Auto-generated constructor stub
  }

  @Override    

  public void handle(HttpExchange exchange) throws IOException {
    
    if("POST".equals(exchange.getRequestMethod())) { 
      BufferedReader reader = new BufferedReader(new InputStreamReader(exchange.getRequestBody()));
      String requestBody = reader.readLine();
      reader.close();
      System.out.println(requestBody);
      exchange.sendResponseHeaders(200, 0);
      // System.out.println("Server IP Address: " + server.getAddress().getHostString());
      
    }
  }
}