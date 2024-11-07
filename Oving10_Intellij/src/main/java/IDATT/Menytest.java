package IDATT;


import java.util.ArrayList;

public class Menytest {
  public static void main(String[] args){
    MenyRegister menyRegister = new MenyRegister();

    Meny MandagMeny = new Meny();
    MandagMeny.registerRett("Kylling konkarne", "Forrett", 100);
    MandagMeny.registerRett("Grøt","Hovedrett",100);
    MandagMeny.registerRett("Mandarin","Dessert",100);
    menyRegister.registrerMeny(MandagMeny.getMeny());

    Meny dagensMeny = new Meny();
    dagensMeny.registerRett("Kjøttkake","Hovedrett",100);
    dagensMeny.registerRett("Riskrem","Dessert",100);
    menyRegister.registrerMeny(dagensMeny.getMeny());

    Meny IngvesRett = new Meny();
    IngvesRett.registerRett("Hummer","Forrett",100);
    IngvesRett.registerRett("Kaviar","Hovedrett",100);
    IngvesRett.registerRett("Vin","Dessert",100);
    IngvesRett.registerRett("Biff tartar", "Vin", 100);
    menyRegister.registrerMeny(IngvesRett.getMeny());


    System.out.println(menyRegister);

    System.out.println("\n3 tests total:");
    if(menyRegister.finneRettGittNavn("Hummer").getFirst().getNavn().equals("Hummer")){
      System.out.println("Test 1 passed");
    }

    for(int i = 0; i < menyRegister.finneAlleRettGittType("Hovedrett").size(); i++){
      if(menyRegister.finneAlleRettGittType("Hovedrett").get(i).getType().equals("Hovedrett")){
        System.out.println("Test 2."+ (i+1) +" passed");
      };
    }

    if(menyRegister.sumAlleRetter() == 900){
      System.out.println("Test 3 passed");
    }

  }

}
