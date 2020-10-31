import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import static java.awt.image.ImageObserver.WIDTH;
import javax.imageio.ImageIO;
import java.io.*;

public class Painting extends JPanel implements ActionListener {

   /*---- Randomness ----*/
    final static long SEED = 37; // seed for the random number generator; any number works

    /** do not change the following two lines **/
    final static Random random = new Random( SEED ); // random generator to be used by all classes
    int numberOfRegenerates = 0;

   /*---- Screenshots ----*/
    char current = '0';
    String filename = "randomshot_"; // prefix
    
   /*---- Dinguses ----*/
    ArrayList<Dingus> shapes = new ArrayList<Dingus>(); //New arraylist to store dinguses

    public Painting() {
        setPreferredSize(new Dimension(800, 450)); // make panel 800 by 450 pixels.
        //...
    }

    @Override
    protected void paintComponent(Graphics g) { // draw all the shapes
        super.paintComponent(g);     // clears the panel
        Graphics2D g2 = (Graphics2D) g; // To use graphics 2d
        // draw all shapes
        new Background(WIDTH, WIDTH).draw(g); //First create background behind every shape
        
        for (Dingus shape : shapes) {
            shape.draw(g);
        } //Draws every dingus shape in the arraylist
        
        
    }

    /**
     * reaction to button press
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if ( "Regenerate".equals(e.getActionCommand()) ) {
            regenerate();
            repaint();
        } else { // screenshot
            saveScreenshot( this, filename+current++ ); // ++ to show of compact code :-)
        }
    }

    void regenerate() {
        numberOfRegenerates++;
        
        // clear the shapes list
        shapes = new ArrayList<>();

        // create random shapes
        shapes.add(new Moon(700, 40));
        shapes.add(new Stars(800, 450, 300));
        shapes.add(new Sun(WIDTH, WIDTH));
        shapes.add(new Building(800, 500, 10));
        shapes.add(new Building(800, 450, 11));
        shapes.add(new Building(800, 550, 9));
        shapes.add(new Building(800, 650, 18));
        shapes.add(new Building(800, 600, 9));
        shapes.add(new Building(800, 500, 15));
        shapes.add(new River(WIDTH, WIDTH));
    }

    /*
     * saves a screenshot of a Component on disk
     *  overides existing files
     *
     * @param component - Component to be saved
     * @param name - filename of the screenshot, followed by a sequence number
     * 
     */
    void saveScreenshot(Component component, String name) {
        String randomInfo = ""+SEED+"+"+ (numberOfRegenerates-1); //minus 1 because the initial picture should not count
        System.out.println( SwingUtilities.isEventDispatchThread() );
        BufferedImage image =
            new BufferedImage(
                              component.getWidth(),
                              component.getHeight(),
                              BufferedImage.TYPE_INT_RGB
                             );
        // call the Component's paint method, using
        // the Graphics object of the image.
        Graphics graphics = image.getGraphics();
        component.paint( graphics ); // alternately use .printAll(..)
        graphics.drawString(randomInfo, 0, component.getHeight());
        
        try {
            ImageIO.write(image, "PNG", new File(name+".png"));
            System.out.println( "Saved screenshot as "+ name );
        } catch( IOException e ) {
            System.out.println( "Saving screenshot failed: "+e );
        }
    }
    
}
