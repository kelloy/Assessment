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
import java.net.Socket;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HttpClientConnection implements Runnable{
        private final Socket socket;
        private String directory;
        public HttpClientConnection(Socket socket, String directory){
            this.socket = socket; 
            this.directory = directory;
        }
        handler handler = new handler();


    @Override
    public void run() {

        try(OutputStream os = socket.getOutputStream()){
          BufferedOutputStream bos = new BufferedOutputStream(os);
          DataOutputStream dos = new DataOutputStream(bos);
          InputStream is = socket.getInputStream();
          BufferedInputStream bis = new BufferedInputStream(is);
          DataInputStream dis = new DataInputStream(bis);
          BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
          String line = "";
          String msg = "";
          String[] linesplit;

        while (!line.equals("close")){
            line = br.readLine();
            linesplit = line.split("\\s");
            Path directorypath = Paths.get(directory);
            File directoryfolder = directorypath.toFile();
            String resource = linesplit[1];
            String command = linesplit[0];
            if (command.equals("GET")){
                msg = handler.checkFileExists(directoryfolder, resource);
                dos.writeUTF(msg);
                dos.flush();}
            else{
                System.out.println(line + "not supported\r\n");
            }
            dis.readUTF();
        }
        dis.close();
        socket.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
  }
    
}
