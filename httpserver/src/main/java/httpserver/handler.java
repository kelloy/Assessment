package httpserver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

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

    public boolean checkFileExists(File directoryfolder, File filetocheck) throws IOException {
        Boolean fileexist = false;
        for (File file:directoryfolder.listFiles()){
            if(file.equals(filetocheck)){
                return fileexist = false;
            }
            else{
                return fileexist =true;
            }
        }
        return fileexist;
        }



    public byte[] writefile(File file) throws IOException {
        int size = 0;
        byte[] buffer = new byte[1024];
        FileInputStream is = new FileInputStream(file);
        FileOutputStream os = new FileOutputStream(file);
        while (-1 != (size = is.read(buffer)))
        os.write(buffer,0,size);

        os.flush();
        os.close();
        is.close();

        return buffer;

        
    }


 

}




    


