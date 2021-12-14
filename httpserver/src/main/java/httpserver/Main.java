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
import java.net.ServerSocket;
import java.net.Socket;

import javax.print.Doc;

public class Main{
    public static int server;
    public static int port;
    public static String directory;
    public static String portstring;
    public static String command1;
    public static String command2;
        

    public static void main(String[] args) throws IOException {
        command1 = args[0];
        portstring = args[1];
        directory = args[3];
        command2 = args[2];

        if("".equals(command1) && "".equals(command2)){
                port = 3000;
                directory = "src\\main\\java\\httpserver\\static";
        }
        else if ("port".equals(command1)){
            port = 3000;
            directory = "src\\main\\java\\httpserver\\static";
            }
        else if ("port".equals(command1) && null != args[1]){
            port = Integer.parseInt(portstring);
            directory = "src\\main\\java\\httpserver\\static";
        }else if ("docRoot".equals(command1)){
            port = 3000;
            directory = args[3];
        }else if ("docRoot".equals(command1) && null !=args[3]){
            port = 3000;
            directory = args[3];
        }else if ("port".equals(command1) && ("docRoot").equals(command2)){
            port = Integer.parseInt(args[1]);
            directory = args[3];
        }

        Server.server(port,directory);



            

        }
  }