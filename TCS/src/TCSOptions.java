import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class TCSOptions extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3964414772980443999L;

	public TCSOptions()
	{
		JButton addPlaneButton = new JButton("Add Plane");
	    JButton clearButton = new JButton("Clear Planes");
	
	    addPlaneButton.setActionCommand("Add");
	    clearButton.setActionCommand("Clear");
	
	    addPlaneButton.addActionListener(new ButtonClickListener()); 
	    clearButton.addActionListener(new ButtonClickListener()); 
	
	    add(addPlaneButton);
	    add(clearButton);
	}
    
    private class ButtonClickListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
           String command = e.getActionCommand();  
           
           if (command.equals( "Add" ))
           {
              
           }
           else if(command.equals( "Clear" ))
           {
              
           }
           else
           {
              
           }
        }		
     }
}
