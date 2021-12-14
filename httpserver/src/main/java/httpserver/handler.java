package httpserver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.lang.model.type.UnknownTypeException;

public class handler{

    public static Boolean checkdirectoryExist(File directory) throws IOException {
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
    }

    public String checkFileExists(File directoryfolder, String resource) throws IOException {
        String msg = "";
        for (File file:directoryfolder.listFiles()){
            if(!file.equals(resource)){
                msg = resource + "not found \r\n";
            return msg;
            }
            else
            System.out.println("file exists");
                if(file.getName().contains(".png")){
                    msg = "Content-Type image/png\r\n" + "resource contents as bytes" ; 
                return msg;
                }
                else{
                    msg = "resource contents as bytes";
                    return msg;
                }
        }
        return msg;
    }

}


    


