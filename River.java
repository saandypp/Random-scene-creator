import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class River extends Dingus {
    
    private int reflectionX; // X location of the reflection of the sun on the river
    private int reflectionY; // Y location of the reflection of the sun on the river
    private Color [] colors = {Color.RED, Color.RED.darker()}; // Array for the colours of the reflection of the sun on the river
    
    public River (int maxX, int maxY) {
        super (maxX, maxY);
    }
    
    void reflection(Graphics g) { // Method to create the reflection of the sun on the river
        Graphics2D g2 = (Graphics2D) g;
        
        reflectionX = random.nextInt(490 + 1 - 280) + 280; // X location randomly chosen with min and max value
        reflectionY = random.nextInt(410 + 1 - 350) + 350; // Y location randomly chosen with min and max value
        
        g2.setColor(colors[random.nextInt(2)]); //Randomly chooses the color
        g2.fill(new Rectangle2D.Double(reflectionX, reflectionY, 70, 4)); // Creates the rectangle for the reflection
    }
    
    @Override
    void draw (Graphics g) {
        Graphics2D g2 = (Graphics2D) g; //Uses graphics 2d to create shapes
        
        g2.setColor(color.BLUE.darker()); 
        g2.fill(new Rectangle2D.Double(0, 350, 800, 100)); // Creates the shape for a river
        
        for (int i = 0; i<15; i++) {
            reflection(g);
        } // Repeats creating the reflection
        
        for (int i2 = 0; i2<3; i2++) {
            reflectionX = random.nextInt(490 + 1 - 300) + 300;
            reflectionY = random.nextInt(390 + 1 - 350) + 350;
            g2.setColor(color.ORANGE);
            g2.fill(new Rectangle2D.Double(reflectionX, reflectionY, 70, 4));
        } // Orange colored reflection 
        
    }
    
}
