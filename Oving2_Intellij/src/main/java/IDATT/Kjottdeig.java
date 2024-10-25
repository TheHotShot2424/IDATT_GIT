package IDATT;

public class Kjottdeig {
  public static void main(String[] args){
    double kjottA_prGram = 450/35.90;
    double kjottB_prGram = 500/39.90;

    String result = (kjottA_prGram > kjottB_prGram) ? "Kjøttmerke A er billigere" : "Kjøttmerke B er billegere";
    System.out.println(result); //kan putte linje over inn i println. Men mindre oversiktelig.
  }
}
