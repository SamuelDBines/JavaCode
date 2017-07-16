package code.reading.application;

import javax.swing.JTextField;



/**
 *
 * @author Sam
 */
public class TestView extends View {
    public TestView(String title)  {
        
      add(new JTextField(title, 5));
                 
    }
}