/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code.reading.application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Sam
 */
public class ReadFile {
    private FileWriter writer;
    private FileReader reader;
    private BufferedReader instream;
    public ReadFile(String file) throws FileNotFoundException, IOException {
        File files = new File("test.txt");
        files.createNewFile();
        writer = new FileWriter(files);
        writer.write("This is a writer test \n"
                + "hi");
        writer.flush();
        writer.close();        
        reader = new FileReader(files);
        
        
      //  char[] a = new char[50];
        //reader.read(a);   
        instream = new BufferedReader(reader);
        String s;
        s = instream.readLine();
        System.out.println(s);
        while((s = instream.readLine() ) != null ) {
           
        }
        instream.close();
      //  for(char c : a) 
      //      System.out.print(c);
      //  reader.close();
        
    }
}
