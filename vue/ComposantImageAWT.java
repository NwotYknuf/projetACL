package projet.vue;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Panel;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.ImageIcon;

public class ComposantImageAWT extends Panel
{
    Image image;
  
    public ComposantImageAWT(String path, int widthImage, int heightImage)
    {
        loadImage(path, widthImage, heightImage);
    }
  
    public void paint(Graphics g)
    {
        super.paint(g);
        int w = getWidth();
        int h = getHeight();
        int imageWidth = image.getWidth(this);
        int imageHeight = image.getHeight(this);
        int x = (w - imageWidth)/2;
        int y = (h - imageHeight)/2;
        g.drawImage(image, x, y, this);
    }
  
    /**
     * For the ScrollPane or other Container.
     */
    public Dimension getPreferredSize()
    {
        return new Dimension(image.getWidth(this), image.getHeight(this));
    }
  
    public void loadImage(String path, int widthImage, int heightImage)
    {
        
        try {
        	URL url = getClass().getResource(path);
        	Toolkit toolkit = Toolkit.getDefaultToolkit();
        	image = toolkit.getImage(url);
        	image = image.getScaledInstance(widthImage, heightImage, Image.SCALE_SMOOTH);
        	MediaTracker tracker = new MediaTracker(this);
        	tracker.addImage(image, 0);
        	try
        	{
        		tracker.waitForID(0);
        	}
        	catch(InterruptedException ie)
        	{
        		System.out.println("interrupt: " + ie.getMessage());
        	}
        }
        catch (Exception e){
        	e.printStackTrace();
        }
    }
}