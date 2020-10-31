import java.awt.*;


class Stars extends Dingus {
    protected int Stars;
    
    
    public Stars(int maxX, int maxY, int StarAmount){
        super(maxX, maxY);
        Stars = StarAmount;
        
        }         
    
    @Override
    void draw(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        GradientPaint starColor;
        
        starColor = new GradientPaint(0, 20, Color.WHITE, 0, maxY, Color.RED); //Uses gradient
        
        
        g2.setPaint(starColor);
        for(int i = 0; i < Stars; i++){
            int size = random.nextInt(5); //Sets the maximum size for the stars
            g2.fillOval(20+random.nextInt(maxX-20), 20+random.nextInt(maxY-20), size, size);
        }
        
    }
}
