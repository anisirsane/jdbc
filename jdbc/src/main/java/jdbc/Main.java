package jdbc;

//this code was taken from a tutorial on : geeksforgeeks website with some minor moddifications
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
// https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/Executors.html
//https://docs.oracle.com/javase/8/docs/api/java/net/InetSocketAddress.html
// https://stackoverflow.com/questions/3732109/simple-http-server-in-java-using-only-java-se-api
// https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ThreadPoolExecutor.html
public class Main {

	public static void main(String[] args) throws Exception{
                //le tutoriel suit pour creer le serveur : https://dzone.com/articles/simple-http-server-in-java
        HttpServer server = HttpServer.create(new InetSocketAddress(8001), 0);
        // TheHttpHandler.handle(null);

        
        server.createContext("/data", new  TheHttpHandler());
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor)Executors.newFixedThreadPool(10);

        server.setExecutor(threadPoolExecutor);
        server.start();
        System.out.println(" Server started on port 8001");
        
        
        CheckDb check = new CheckDb();
        
        check.check();
        switch (UserInput.choixMenu()) {
                case 1:
                UserInput.insertObjet();
                        break;
                case 2:
                UserInput.modifieobjet();
                        break;
                case 3:
                UserInput.showObjet();

                        break;
                case 4:
                UserInput.supprimerobjet();
                        break;

                default:
                        break;
        }
        }
}