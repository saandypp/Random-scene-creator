import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Background extends Dingus {
    
    public Background(int maxX, int maxY) {
        super(maxX, maxY);
        
    }
    
    @Override
    void draw (Graphics g) {
        Graphics2D g2 = (Graphics2D) g; //Uses graphics 2d
        GradientPaint nightsky = new GradientPaint(0, 0, color.BLUE, 0, 400, color.PINK); // Uses gradient
        g2.setPaint(nightsky);
        g2.fill(new Rectangle2D.Double(0, 0, 800, 450)); // Rectangle for the background
    }
    
}
