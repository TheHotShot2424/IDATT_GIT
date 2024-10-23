package Oving7;


public class NyString {
    //Declarating instance variable/attributes
    private final String minStreng;

    //constructor
    public NyString(String objekt){
        this.minStreng = objekt;
    }

    //method
    public String forkortning(){
        String[] a = minStreng.split(" ");
        String store = "";
        for(int i = 0; i < a.length; i++){
            char firstLetter = a[i].charAt(0);
            store = store + firstLetter;
        }
        return store;
    }

    public String fjernOrd(String bokstav){
        String a = minStreng;
        a = a.replace(bokstav, ""); // .replace endrer ikke original "a", så den må lagres til en 
                                                // ny "a". Dessuten må .replace ha samme datatype på begge 
                                                // side av komma
        return a; 
    }

    @Override
    public String toString(){
        return minStreng;
    }
}
