package collections;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.Timer;
import java.awt.event.*;

import javax.swing.JPanel;

public class BallPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int delay = 10;
	private ArrayList<Ball> list = new ArrayList<Ball>();
// Create a timer with the initial delay
	protected Timer timer = new Timer(delay, new TimerListener());

	private class TimerListener implements ActionListener {
		@Override /** Handle the action event */
		public void actionPerformed(ActionEvent e) {
			repaint();
		}
	}
	
	public BallPanel() {
		timer.start();
		this.addMouseListener(new MouseListener() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	int x=e.getX();
		        int y=e.getY();
		        for (int j=0; j<list.size(); j++) {
				   Ball ball = (Ball) list.get(j);
		    	   if(Math. sqrt((x-ball.x)*(x-ball.x) + (y-ball.y)*(y-ball.y))<= ball.radius){
		    		   list.remove(j);
		    		   break;
		    	   }
		        }
		    }

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});

	}

	public void add() {
		list.add(new Ball());
	}

	public void subtract() {
		if (list.size() > 0)
			list.remove(list.size() - 1); // Remove the last ball
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i= 0; i<list.size(); i++) {
			for (int j=0; j<list.size(); j++) {
				Ball ball1 = (Ball) list.get(i);
				Ball ball2 = (Ball) list.get(j);
				if(i!=j && (ball1.radius+ball2.radius)>= Math. sqrt((ball1.x-ball2.x)*(ball1.x-ball2.x) + (ball1.y-ball2.y)*(ball1.y-ball2.y))) {
					if(i<j) {
						ball1.radius+= ball2.radius;
						list.remove(j);
					}else {
						ball2.radius+= ball1.radius;
						list.remove(i);
					}
				}
			}
		}
		for (int i = 0; i < list.size(); i++) {
			Ball ball = (Ball) list.get(i); // Get a ball
			g.setColor(ball.color); // Set ball color
			// Check boundaries
			if (ball.x < 0 || ball.x > getWidth())
				ball.dx = -ball.dx;
			if (ball.y < 0 || ball.y > getHeight())
				ball.dy = -ball.dy;
			// Adjust ball position
			ball.x += ball.dx;
			ball.y += ball.dy;
			g.fillOval(ball.x - ball.radius, ball.y - ball.radius, ball.radius * 2, ball.radius * 2);
		}
	}

	public void suspend() {
		timer.stop();
	}

	public void resume() {
		timer.start();
	}

	public void setDelay(int delay) {
		this.delay = delay;
		timer.setDelay(delay);
	}
}