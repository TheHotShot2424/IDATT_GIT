public class Lambdas{

    //Lambda er en shortcut måte å få funksjoner til. Vanligvis må en lage en ny klasse som implementerer disse 
    //interface'ene og lager implementeringen i form av metode, og dermed lage objekt av dette i main. 
    //Men vi kaster vekk hele mellsomsteget og bruker lambda. Via dem utføres de funksjonelle oppgavene.
    public static void main(String[] args) {
        //Cat minCat = new Cat();
        //minCat.print(); kan heller bruke metoden under istedenfor å bruke objektet selv til å kalle på metoden.
        // Printable lambdaPrintable = (suff) -> System.out.println(pref+"Meow"+suff);//med dette trengs ikke Cat-klassen som mellomann til interface
        // printThing(lambdaPrintable);
        //printThing(() -> System.out.println("Meow"));

        Printable lamPrintable = (s) -> "Meow" + s; //samme som return
        
        printThing(lamPrintable);
    }



    static void printThing(Printable thing) { //parameter er noe som implementerer Printable interface'et og dermed har tilgang til dens metoder
        thing.print("!!!"); //men det er lang vei å gå fra printable, til Cat-klass, til minCat i main, til endelig å printe her. Dette kan forenkles!
    
    }

}