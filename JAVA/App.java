package chaoticFractals;

import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class App {
	public static int sides = 3;
	public static int points = 50;
	
	public static Point[] pts;

	private JFrame frame;
	private Panel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//generate points of regular polygon
	public void generatePolygon(Point[] pt){
		int i, x=0, y=0;
		double theta = 2*Math.PI/sides;
		for(i=0;i<sides;i++){
			x = (int)(291+250*Math.sin(i*theta));
			y = (int)(282-250*Math.cos(i*theta));
			
			pt[i].x = x;
			pt[i].y = y;
		}
	}
	/**
	 * Create the application.
	 */
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		pts = new Point[10];
		for(int i=0;i<10;i++){
			pts[i] = new Point(0,0);
		}
		generatePolygon(pts);
		
		frame = new JFrame("Geometic_Fractals");
		frame.setBounds(100, 100, 600, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new Panel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 582, 565);
		frame.getContentPane().add(panel);
		
		JLabel lblSides = new JLabel("SIDES");
		lblSides.setHorizontalAlignment(SwingConstants.CENTER);
		lblSides.setBounds(0, 565, 75, 38);
		frame.getContentPane().add(lblSides);
		
		final JSlider slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				sides = slider.getValue();
				generatePolygon(pts);
				panel.repaint();
			}
		});
		slider.setValue(3);
		slider.setMaximum(10);
		slider.setMinimum(3);
		slider.setBounds(87, 565, 200, 38);
		frame.getContentPane().add(slider);
		
		JLabel lblPoints = new JLabel("POINTS");
		lblPoints.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoints.setBounds(299, 565, 75, 38);
		frame.getContentPane().add(lblPoints);
		
		final JSlider slider_1 = new JSlider();
		slider_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				points = slider_1.getValue();
				panel.repaint();
			}
		});
		slider_1.setMaximum(10000);
		slider_1.setMinimum(20);
		slider_1.setBounds(382, 565, 200, 38);
		frame.getContentPane().add(slider_1);
	}
}
