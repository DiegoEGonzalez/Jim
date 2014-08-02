import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Character {
    int x;
    int y;
    int dx;
    int dy;
    BufferedImage img;
    boolean user=false;
    Color kind;


    public Character(){

        try{
            img= ImageIO.read(new File("jim.jpg"));
            AffineTransform trans = new AffineTransform();
            trans.scale(.15,.15);
            AffineTransformOp apply = new AffineTransformOp(trans,AffineTransformOp.TYPE_BILINEAR);
            img=apply.filter(img,null);
        } catch (IOException e){
            e.printStackTrace();
        }

        kind=new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
    }

    public void update(){
        if(Math.random()<.01&&!user){
            dx*=-1;
        }
        x+=dx;
        y+=dy;
        if(x>GameEngine.DEFAULT_WINDOWSIZEX||x<0&&!user)
            dx*=-1;

    }

    public void draw(Graphics g, int a, int b){
        g.drawImage(img,500+x-a,600+y-b,null);
        g.setColor(kind);
        g.drawRect(500+x-a,600+y-b,img.getWidth(),img.getHeight());
    }

    public void setDx(int a){
        dx=a;
    }

    public void setDy(int a){
        dy=a;
    }
}
