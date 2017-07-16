/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code.reading.application;

import java.io.IOException;

/**
 *
 * @author Sam
 */
public class CodeReadingApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        ReadFile r = new ReadFile();
        String s = r.readFile("test.txt");
        System.out.println(s);
        FrameDesign f = new FrameDesign();
    }
    
}
