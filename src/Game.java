import java.awt.*;
import java.awt.event.ActionEvent;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

public class Game extends JPanel{

    BufferedImage back = null;

    ArrayList <Other> guys = new ArrayList<Other>();
    int id = 0;
    public Game(){

        //********** JPANEL SPECIFICS ***********
        setLayout(null);//designates that the JPanel has no layout and allows us to align elements within it using (x,y)
        setSize(GameEngine.DEFAULT_WINDOWSIZEX, GameEngine.DEFAULT_WINDOWSIZEY);//set's the size of our JPanel
        setBackground(Color.black);//sets the background color to...
       }//makes the Jpanel visible

    //********** KEY EVENTS ******************

    //--------------- A ---------------------
    Action left = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
                guys.get(id).dx=-6;
        }
    };
    {
        getInputMap().put(KeyStroke.getKeyStroke("A"),"left");
        getActionMap().put("left", left);

        Action leftReleased = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                guys.get(id).dx=0;
            }
        };
        getInputMap().put(KeyStroke.getKeyStroke("released A"),
                "leftReleased");
        getActionMap().put("leftReleased",
                leftReleased);

        // ---------------- D ---------------------
        Action right = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                guys.get(id).dx=6;
            }
        };

        getInputMap().put(KeyStroke.getKeyStroke("D"),
                "right");
        getActionMap().put("right",
                right);
        Action rightReleased = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                guys.get(id).dx=0;
            }
        };
        getInputMap().put(KeyStroke.getKeyStroke("released D"),
                "rightReleased");
        getActionMap().put("rightReleased",
                rightReleased);

        //--------------- W ---------------------
        Action up = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                guys.get(id).dy=-6;
            }
        };

            getInputMap().put(KeyStroke.getKeyStroke("W"), "up");
            getActionMap().put("up", up);

            Action upReleased = new AbstractAction() {
                public void actionPerformed(ActionEvent e) {
                    guys.get(id).dy = 0;
                }
            };
            getInputMap().put(KeyStroke.getKeyStroke("released W"),
                    "upReleased");
            getActionMap().put("upReleased",
                    upReleased);

            // ---------------- S ---------------------
            Action down = new AbstractAction() {
                public void actionPerformed(ActionEvent e) {
                    guys.get(id).dy = 6;
                }
            };

            getInputMap().put(KeyStroke.getKeyStroke("S"),
                    "down");
            getActionMap().put("down",
                    down);
            Action downReleased = new AbstractAction() {
                public void actionPerformed(ActionEvent e) {
                    guys.get(id).dy = 0;
                }
            };
            getInputMap().put(KeyStroke.getKeyStroke("released S"),
                    "downReleased");
            getActionMap().put("downtReleased",
                    downReleased);

            // ----------- ESCAPE ------------
            Action esc = new AbstractAction() {
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            };
            getInputMap().put(KeyStroke.getKeyStroke("ESCAPE"),
                    "ESC");
            getActionMap().put("ESC",
                    esc);

            // ---------- SPACE -------------

        Action space = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                guys.get(id).user=false;
                if(guys.size()>id+1)
                    id++;
                else if (guys.size()>1)
                    id--;
                guys.get(id).user=true;

            }
        };
        getInputMap().put(KeyStroke.getKeyStroke("SPACE"),
                "SPACE");
        getActionMap().put("SPACE",
                space);


            try {
                back = ImageIO.read(new File("back.jpg"));

            } catch (IOException e) {
                e.printStackTrace();
            }

            guys.add(new Other());
            guys.get(id).user=true;
            guys.add(new Other());

        }

    public void update(){
        for(int x=0;x<guys.size();x++){
            guys.get(x).update();
        }
        if(Math.random()<.001){
            guys.add(new Other());
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);//clears the display

        g.setColor(Color.WHITE);
        g.drawImage(back,-400-guys.get(id).x,-300-guys.get(id).y,null);

        g.drawString("hello, welcome jim",100,100);

        /**
        if(collision()) {
            g.fillRect(500, 600, jim.getWidth(), jim.getHeight());
            this.x+=guys.get(0).dx;
        }else {
            g.drawRect(500, 600, jim.getWidth(), jim.getHeight());
        }



        g.drawRect(0,600+jim.getHeight()-y,GameEngine.DEFAULT_WINDOWSIZEX,100);


        **/
        for(int x=0;x<guys.size();x++){
            guys.get(x).draw(g,guys.get(id).x,guys.get(id).y);
        }

    }
    /**
    public boolean collision(){
        for(int x=0;x<guys.size();x++){
            boolean up=((guys.get(x).y-this.y)<600+jim.getHeight());
            boolean down=(guys.get(x).y-this.y)+guys.get(x).img.getHeight()>(600);
            boolean left=((guys.get(x).x-this.x)<500+jim.getWidth());
            boolean right=(guys.get(x).x-this.x)+guys.get(x).img.getWidth()>(500);

            if(left&&right&&up&&down){
                return true;
            }
        }
        return false;
    }
    **/

}
