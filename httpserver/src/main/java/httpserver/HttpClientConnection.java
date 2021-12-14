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
          byte[] msg = new byte[1024];
          String[] linesplit;

        while (!line.equals("close")){
            line = br.readLine();
            linesplit = line.split("\\s");
            Path directorypath = Paths.get(directory);
            File directoryfolder = directorypath.toFile();
            String resource = linesplit[1];
            Path filepath = Paths.get(resource);
            File filetocheck = filepath.toFile();
            Boolean fileexist;
            String command = linesplit[0];
            if (command.equals("GET")){
                fileexist = handler.checkFileExists(directoryfolder, filetocheck);
                if(fileexist == true){
                System.out.println("HTTP/1.1 200 OK\r\n");
                msg = handler.writefile(filetocheck);
                dos.write(msg);
                dos.flush();
                dos.close();
                }else{
                    System.out.println("File does not exist");
                    dos.close();   
                }
            }else{
                System.out.println(line + "not supported\r\n");
            }
            dis.readUTF();
        }
        dis.close();
        socket.close();
        br.close();
        os.close();
        dos.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
  }
    
}
