import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.border.TitledBorder;

public class MoveImage extends JFrame {
	ShowCanvas canvas;

	public MoveImage() {
		super();
		Container container = getContentPane();
		canvas = new ShowCanvas();
		container.add(canvas);
		setSize(300, 200);
		setVisible(true);
	}

	public static void main(String arg[]) {
		new MoveImage();
	}
}

class ShowCanvas extends JPanel {
	int x, y;
	BufferedImage image;

	ShowCanvas() {
		setBackground(Color.white);
		setSize(450, 400);
		addMouseMotionListener(new MouseMotionHandler());

		Image img = getToolkit().getImage("node.jpg");

		MediaTracker mt = new MediaTracker(this);
		mt.addImage(img, 1);
		try {
			mt.waitForAll();
		} catch (Exception e) {
			System.out.println("Image not found.");
		}
		image = new BufferedImage(img.getWidth(this), img.getHeight(this),
				BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = image.createGraphics();
		g2.drawImage(img, 0, 0, this);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D) g;
		g2D.drawImage(image, x, y, this);
	}

	class MouseMotionHandler extends MouseMotionAdapter {
		public void mouseDragged(MouseEvent e) {
			x = e.getX();
			y = e.getY();
			repaint();
		}

		public void mouseMoved(MouseEvent e) {
		}
	}
}