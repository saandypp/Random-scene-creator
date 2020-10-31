import java.awt.*;
import java.util.*;

public class Sun extends Dingus {
    
    protected int radius;
    
    public Sun (int maxX, int maxY) {
        // intialize randomly the sun properties
        super(maxX, maxY);
        // initialize the radius of the sun
        radius = 180;
    }
    
    @Override
    void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillArc(330, 280, radius, radius,0, 180); //Draw a circle of the color RED
    }
    
}

