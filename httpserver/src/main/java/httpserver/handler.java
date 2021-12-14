package httpserver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.lang.model.type.UnknownTypeException;

public class handler{

    /*public static Boolean checkdirectoryExist(File directory) throws IOException {
        Boolean isthere = false;
        for (File file:directory.listFiles()){
            if(file.exists())
                if(file.isDirectory())
                    if(file.canRead())
                        return isthere = true;
                    else{
                        System.out.println("unable to path");
                    }
                else{
                System.out.println("Path is not a directory");}
            else{
                System.out.println("no file exist");}
            }
        return isthere;
    }*/

    public static void serverClose() {

        
    }

    public String checkFileExists(File directoryfolder, String resource) throws IOException {
        String msg = "";
        for (File file:directoryfolder.listFiles()){
            if(!file.equals(resource)){
                msg = resource + "not found \r\n";
            return resource;
            }
            else
            System.out.println("file exists");
                if(file.getName().contains(".png")){
                    System.out.println("Content-Type image/png\r\n");
                    return resource;
                }
                else{
                    return resource;
                }
        }
        return resource;
    }

    public byte[] writefile(String resource) throws IOException {
        int size = 0;
        byte[] buffer = new byte[1024];
        InputStream is = new FileInputStream(resource);
        FileOutputStream os = new FileOutputStream(resource);
        while (-1 != (size = is.read(buffer)))
        os.write(buffer,0,size);

        os.flush();
        os.close();
        is.close();

        return buffer;

        
    }


 

}




    


