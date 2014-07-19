import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by DiegoGonzalez on 7/9/14.
 */
public class Other {
    int x=200;
    int y=600;
    int dx=1;
    int dy=0;
    BufferedImage guy = null;
    public Other(){
        try {
            guy = ImageIO.read(new File("other.png"));
            AffineTransform trans = new AffineTransform();
            trans.scale(.15,.15);
            AffineTransformOp apply = new AffineTransformOp(trans,AffineTransformOp.TYPE_BILINEAR);
            guy=apply.filter(guy,null);
        } catch (IOException e) {
            e.printStackTrace();

        }
        //dx=(int)(Math.random()*2)-1;
        //dx=(int)(Math.random()*2)+1;
    }
    public void update(){
        if(Math.random()<.01){
            dx*=-1;
        }
        x+=dx;
        y+=dy;
        if(x>GameEngine.DEFAULT_WINDOWSIZEX||x<0)
            dx*=-1;
    }
    public void draw(Graphics g, int a, int b){

        g.drawImage(guy,x-a,y-b,null);
        g.drawRect(x-a,y-b,guy.getWidth(),guy.getHeight());
    }
}
