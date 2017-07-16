
package code.reading.application;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Sam
 */
public class FrameDesign extends JFrame {
    public FrameDesign()  {
        
      setFrame();
                 
    }

    private void setFrame() {
        setUndecorated(true);//Start frame undecorated
        setLayout(new BorderLayout());//Set the layout of frame to border layout
        add("North", new NavigationBar());
        add("Center", CenterPanel.getInstance());
        setSize(800, 600);//set size of frame to 750 wide, 600 height

        setVisible(true);//Set the frame to visible        
    }
}