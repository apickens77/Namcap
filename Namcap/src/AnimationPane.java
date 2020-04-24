import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class AnimationPane extends JPanel 
{
    private BufferedImage boat;
    private int xPos = 0;
    private int direction = 20;

    public AnimationPane() {
        try {
            boat = ImageIO.read(new File("C:\\\\Users\\\\Adam Pickens\\\\git\\\\Namcap\\\\Namcap\\\\src\\\\images\\\\ghost.jpg"));
            boat = getScaledImage(boat, 40, 40);
            Timer timer = new Timer(40, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    xPos += direction;
                    if (xPos + boat.getWidth() > getWidth()) {
                        xPos = getWidth() - boat.getWidth();
                        direction *= -1;
                    } else if (xPos < 0) {
                        xPos = 0;
                        direction *= -1;
                    }
                    repaint();
                }

            });
            timer.setRepeats(true);
            timer.setCoalesce(true);
            timer.start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /*@Override
    public Dimension getPreferredSize() {
    	Dimension d = new Dimension(800, 600);
    	return d;
        //return boat == null ? super.getPreferredSize() : new Dimension(boat.getWidth() * 4, boat.getHeight());
    }*/
    
    private BufferedImage getScaledImage(Image srcImg, int w, int h)
	{
	    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TRANSLUCENT);
	    Graphics2D g2 = resizedImg.createGraphics();
	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(srcImg, 0, 0, w, h, null);
	    g2.dispose();
	    return resizedImg;
	}

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int y = getHeight() - boat.getHeight();
        g.drawImage(boat, xPos, y, this);

    }

}