package httpserver;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    public static void server(int port, String directory) throws IOException {
        ServerSocket server = new ServerSocket(port);
        System.out.println("connected");
        ExecutorService threadPool= Executors.newFixedThreadPool(3);
        while (true){
            Socket socket= server.accept();
            HttpClientConnection worker = new HttpClientConnection(socket, directory);
            threadPool.submit(worker);
        }
    }

    }
    

