import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import net.miginfocom.swing.MigLayout;

public class TCSWindow
{

	private JFrame mainFrame;
	private JPanel controlPanel;
	   
	public TCSWindow()
	{
		/*EventQueue.invokeLater(new Runnable()
		{
            @Override
            public void run()
            {
                try
                {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                }
                catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex)
                {
                	
                }

                PrepareGUI();
            }
        });*/
		
		PrepareGUI();
	}
	
	private void PrepareGUI()
	{
		mainFrame = new JFrame("Air Traffic Control System");
		mainFrame.setSize(1024,768);
		
		TCSMovePanel testPlane = new TCSMovePanel();
		mainFrame.setGlassPane(testPlane);
		
		mainFrame.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent windowEvent)
			{
				System.exit(0);
			}
		});
		
		controlPanel = new TCSOptions();
		controlPanel.setLayout(new MigLayout());
		
		mainFrame.setLayout(new BorderLayout());
		mainFrame.add(controlPanel, BorderLayout.SOUTH);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
		
		testPlane.setResult(0, 1);
	}

}
