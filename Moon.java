import java.awt.*;
import java.util.*;

public class Moon extends Dingus {
    
    protected int radius;
    private Color[] colors = {Color.YELLOW, Color.ORANGE}; //Array of colors, can randomly choose color from here
    private int[] type = {1, 2}; //To choose the random type of moon
    
    public Moon (int maxX, int maxY) {
        // intialize randomly the properties
        super(maxX, maxY);
        // initialize randomly radius
        radius = random.nextInt(maxX/8);
    }
    
    @Override
    void draw(Graphics g) {
        if (type[random.nextInt(2)]==1) { // Type 1: Full moon
            g.setColor(colors[random.nextInt(2)]);
            g.fillArc(x, y, radius, radius,0, 360); 
        } else if (type[random.nextInt(2)]==2) { // Type 2: Crescent moon
            g.setColor(colors[random.nextInt(2)]);
            g.fillArc(x, y, radius, radius,0, 360); //First make a full moon
            g.setColor(Color.BLUE); 
            g.fillArc(x+15, y, radius, radius, 0, 360); //Then make a circle of the same color as the background and cover a part of the full moon that has been created
        }
    }
}
