
public interface Pray { //alle interface er static og final. Derfor må ting instansieres også. 
                        //Bruk interface om du har mange urelaterte klasser hvor de til felles gjør en viss ting.
                        //Forskjell mellom abstrakt klasse og interface-klasse er at du kan implementere 
                        //interface på så mange klasser du vil (rabbit,hawk,fish etc.), men bare én abstract klasse

    void flee(); //abstrakt metode. Mer som en retningslinje for andre klasser. Du deklarer den her, 
                 //men den gis ingen funksjon. Funksjonalitet må gjøres i klassene som implementerer interface'et. Abstrakt
                 //metode er bare der for å enforce og organisere at klasser har disse metodene innplassert. 
}
