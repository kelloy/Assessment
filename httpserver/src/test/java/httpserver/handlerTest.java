package httpserver;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class handlerTest {

    handler handler = new handler();
    
    @Test
    public void checkFileExists() throws IOException {
        File directory = new File("C:\\Users\\keldr\\OneDrive\\Desktop\\gitfolder\\Assessment\\httpserver\\Assessment\\httpserver\\src\\main\\java\\httpserver\\static");
        File resource = new File("Mario.png");
        assertTrue(handler.checkFileExists(directory,resource)==true);
        
    }

    @Test
    public void writeFile() throws IOException{
        File inputfile = new File ("C:\\Users\\keldr\\OneDrive\\Desktop\\gitfolder\\Assessment\\httpserver\\Assessment\\httpserver\\src\\main\\java\\httpserver\\static\\123.txt");
        assertTrue(handler.writefile(inputfile) != null);

    }
}
