/**
 * Created by DiegoGonzalez on 7/31/14.
 */
public class human {
    String name="jim";
    int height =5;
    int weight =150;
    boolean walk = true;

   public human(String name){
       this.name=name;
   }

   public void speak(){
       System.out.println("Hello my name is "+name);
   }

}
