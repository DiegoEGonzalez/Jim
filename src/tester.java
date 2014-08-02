import java.util.ArrayList;

/**
 * Created by DiegoGonzalez on 7/31/14.
 */
public class tester {
    public static void main(String args[]){
        /**
        human Diego = new human("Diego");
        child Zach = new child("Zach");

        Diego.speak();
        System.out.println(Diego.height);
        Diego.height=10;
        System.out.println(Diego.height);
        System.out.println(new human("Jim").height);

        Zach.speak();
        System.out.println(Zach.height);

         **/

        car dealership[] = new car[]{new Tesla(), new Toyota(),new Tesla()};

        ArrayList<car> dealership2 = new ArrayList<car>();

        for(int x=0;x<100;x++)
        {
            if(Math.random()<.5)
            {
                if (Math.random() < .2)
                {
                    dealership2.add(new Tesla());
                }
                else
                {
                    dealership2.add(new Toyota());
                }
            }
        }


        for(int x=0;x<dealership2.size();x++)
        {
            dealership2.get(x).move();
        }

    }
}
