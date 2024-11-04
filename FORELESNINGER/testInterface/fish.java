public class fish implements Pray,Predator {

    @Override
    public void hunt() {
        System.out.println("Fisken jakter mindre fisk...");
    }

    @Override
    public void flee() {
        System.out.println("Fisken flykter fra en større fisk");
    }
    
   
}
