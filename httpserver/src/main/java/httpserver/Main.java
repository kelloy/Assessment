package httpserver;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.print.Doc;

public class Main{
    public static int server;
    public static int port;
    public static String directory;
    public static String portstring;
    public static String command1;
    public static String command2;
    public static void main(String[] args) throws IOException {
        int port = 3000;
        List<String> arguments = Arrays.asList(args);

        if(arguments.contains("--port")){
            port = Integer.parseInt(arguments.get(2));
            directory = "src\\main\\java\\httpserver\\static";
        }
        else if (arguments.contains("--docRoot")){
            port = 3000;
            directory = arguments.get(2);
        }else if(arguments.contains("--port") && arguments.contains("--docRoot")){
            port = Integer.parseInt(arguments.get(2));
            directory = arguments.get(4);
        }else{
            port = 3000;
            directory = "src\\main\\java\\httpserver\\static";
        }
        
        Server.server(port,directory);
}
}