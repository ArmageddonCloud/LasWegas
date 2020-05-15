package lasbegas;
import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.BoxLayout;
import javax.swing.AbstractAction;
import javax.swing.Box;

public class Menu extends JPanel {
    
    boolean started = false ;
    
    public Menu(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        add(Box.createVerticalStrut(280));
        
        //CustomButton button = new CustomButton("START");
        //button.setAlignmentX(CENTER_ALIGNMENT);
        //button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start();
            }
        });
        //add(button);
        
        add(Box.createVerticalGlue());
        
        
    }
    
    public void start(){
        started = true;
    }
}