import java.awt.Graphics;
import java.awt.Color;


public class Building extends Dingus {
    protected int amountOfBuildings; //Amount that the building will take in the whole screen   
    protected int height; 
    protected int buildingWidth;
    
    
    public Building(int maxX, int maxY, int amountOfBuildings){
        super(maxX, maxY);               
        height = random.nextInt(maxY);
        buildingWidth = random.nextInt(maxX / amountOfBuildings);
        for(int i = 0; i < 10; i++){
        if((buildingWidth < 0.5 * maxX / amountOfBuildings) || (height < 2 * buildingWidth)){
            buildingWidth = random.nextInt(maxX / amountOfBuildings);
        }
        } //Ensures the building won't be too small
               
    }
    
    @Override
    void draw(Graphics g){
        g.setColor(Color.DARK_GRAY);   
        g.fillRect(x, (maxY-height), buildingWidth, height);
        
    }
}

 