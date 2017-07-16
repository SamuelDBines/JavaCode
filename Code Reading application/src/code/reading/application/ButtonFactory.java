/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code.reading.application;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 *
 * @author Sam
 */
public class ButtonFactory {

    public ButtonFactory(String title) throws ClassNotFoundException {

        try {
            Class c = Class.forName("code.reading.application." + title);
            System.out.println("Class found");
            System.out.println(c.getName());
            try { 
                CenterPanel.addView((View) c.newInstance(), title);
                System.out.println("Passed");
            } catch(Exception e) {
                System.out.println("Failed");
            }
        } catch (Exception e) {
            WriteFile r = new WriteFile(title + ".java", basicTest(title));
            System.out.println("Create file" + WriteFile.path);
            System.out.println("failed");
        }
    }

    public String basicTest(String title) {
        return "package code.reading.application;\n"
                + "\n"
                + "import javax.swing.JTextField;\n"
                + "\n"
                + "\n"
                + "\n"
                + "/**\n"
                + " *\n"
                + " * @author Sam\n"
                + " */\n"
                + "public class "+ title + " extends View {\n"
                + "    public "+ title +"()  {\n"
                + "        \n"
                + "                 \n"
                + "    }\n"
                + "}";
    }


}
