/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code.reading.application.SelfBuildClasses;

import code.reading.application.CenterPanel;
import code.reading.application.View;
import code.reading.application.WriteFile;

/**
 *
 * @author Sam
 */
public class CreateJavaApplications {
    public CreateJavaApplications(String title) {
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
    private String addForLoopHeader() {
        return "";
    }
    private String addForEachLoop() {
        return "";
    }
    private String addWhileLoop() {
        return "";
    }
}
