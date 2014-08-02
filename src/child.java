/**
 * Created by DiegoGonzalez on 7/31/14.
 */
public class child extends human {


    child(String name){
        super(name);
        height = 2;
        weight = 50;
    }

    public void speak(){
        System.out.println("goo goo ga ga");
    }
    
}
