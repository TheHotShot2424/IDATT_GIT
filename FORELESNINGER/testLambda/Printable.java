@FunctionalInterface //må ikke være her, men kompilator vil enforce vi har én functional interface om den er med
public interface Printable { //interface med bare én abstrakt metode kalles functional interface
    
    String print(String suffix); //abstrakt metode som krever andre klasser som implementerer interfacet også har denne metoden. 
}
