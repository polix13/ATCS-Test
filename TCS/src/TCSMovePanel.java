import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


public class TCSMovePanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2889771603509021544L;
	private JLabel result;
    private Timer timer;
    private float PlaneDirection;
    private float PlaneSpeed;
    

    private int xDelta = (Math.random() > 0.5) ? 1 : -1;
    private int yDelta = (Math.random() > 0.5) ? 1 : -1;
    
	public TCSMovePanel()
	{
        setOpaque(false);
        setLayout(null);
        
        result = new JLabel();
        Font font = result.getFont();
        font = font.deriveFont(Font.BOLD, 26f);
        result.setFont(font);
        result.setText("PLANE");
        add(result);
        
        timer = new Timer(10, new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Point point = result.getLocation();
                //point.x += xDelta;
               // point.y += yDelta;
                
                point.x = (int) (point.x + Math.round(PlaneSpeed * Math.cos(Math.toRadians(PlaneDirection))));
                point.y = (int) (point.y + Math.round(PlaneSpeed * Math.sin(Math.toRadians(PlaneDirection))));
                
                //System.out.printf("" + (int) (point.x + Math.round(PlaneSpeed * Math.cos(PlaneDirection))) + "\n");
                //System.out.printf("" + Math.cos( Math.toRadians(PlaneDirection)) + "\n");
                
                if (point.x < 0)
                {
                	DestroyPlane();
                	
                    point.x = 0;
                    xDelta *= -1;
                }
                else if (point.x + result.getWidth() > getWidth())
                {
                	DestroyPlane();
                	
                    point.x = getWidth() - result.getWidth();
                    xDelta *= -1;
                }
                if (point.y < 0)
                {
                	DestroyPlane();
                	
                    point.y = 0;
                    yDelta *= -1;
                }
                else if (point.y + result.getHeight() > getHeight())
                {
                	DestroyPlane();
                	
                    point.y = getHeight() - result.getHeight();
                    yDelta *= -1;
                }
                
                result.setLocation(point);
                repaint();
            }
        });
        
        timer.start();
    }
	
	public void setResult(float Angle, float Speed)
	{
		PlaneDirection = Angle;
		PlaneSpeed = Speed;
		
		result.setSize(result.getPreferredSize());
		
		Point point = new Point();
		point.x = getWidth() / 2;
		point.y = getHeight() / 2;
		
		result.setLocation(point);
		
		setVisible(true);
    }
	
	public void DestroyPlane()
	{
		setVisible(false);
	}
}
