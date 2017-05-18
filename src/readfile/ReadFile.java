/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readfile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kmacharia <https://github.com/kmacharia/>
 */
public class ReadFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream("config.properties");
            //.txt works in similar fashion, you just change extension as in comment below
//            input = new FileInputStream("config.txt");
            prop.load(input);
            System.out.println("Database = "+prop.getProperty("database"));
            System.out.println("Db user = "+prop.getProperty("dbuser"));
            System.out.println("Db password = "+prop.getProperty("dbpassword"));
        } catch (IOException ex) {
            Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(input!=null){
                try {
                    input.close();
                } catch (IOException ex) {
                    Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
}
