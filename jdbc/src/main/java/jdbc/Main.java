package jdbc;

//this code was taken from a tutorial on : geeksforgeeks website with some minor moddifications
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpContext;
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
        TheHttpHandler httpchoice = new  TheHttpHandler();
        HttpContext resultchoice = server.createContext("/datachoice", httpchoice);
        TheHttpHandler httpdata = new  TheHttpHandler();
        HttpContext resultdata = server.createContext("/data", httpdata);
        // TheHttpHandler httpchoiceMu = new  TheHttpHandler();
        // HttpContext resultchoiceMu = server.createContext("/datachoiceMu", httpchoiceMu);
        // TheHttpHandler httpchoiceAppareil = new  TheHttpHandler();
        // HttpContext resultchoiceAppareil = server.createContext("/datachoiceAppareil", httpchoiceAppareil);
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor)Executors.newFixedThreadPool(10);

        server.setExecutor(threadPoolExecutor);
        server.start();
        System.out.println(" Server started on port 8001");
        
        
        CheckDb check = new CheckDb();
        
        check.check();
        if(httpchoice.getRequestBody()=="1"){
                switch (httpchoice.getRequestBody()) {
                        case "11":
                        UserInputMu.insertObjet(httpdata.getRequestBody());
                                break;
                        case "12":
                        UserInputMu.modifieobjet(httpdata.getRequestBody());
                                break;
                        case "13":
                        UserInputMu.showObjet(httpdata.getRequestBody());
        
                                break;
                        case "14":
                        UserInputMu.supprimerobjet(httpdata.getRequestBody());
                                break;
        
                        default:
                                break;
                }               

        }else{
                if(httpchoice.getRequestBody()=="2"){
                        switch (httpchoice.getRequestBody()) {
                                case "21":
                                UserInputMu.insertObjet(httpdata.getRequestBody());
                                        break;
                                case "22":
                                UserInputMu.modifieobjet(httpdata.getRequestBody());
                                        break;
                                case "23":
                                UserInputMu.showObjet(httpdata.getRequestBody());
                
                                        break;
                                case "24":
                                UserInputMu.supprimerobjet(httpdata.getRequestBody());
                                        break;
                
                                default:
                                        break;
                        }               
        
                }               
        }

        }
}