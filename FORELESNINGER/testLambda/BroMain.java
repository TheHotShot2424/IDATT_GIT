public class BroMain {
    public static void main(String[] args) {
        String name = "Brodda";
        char symbol = '!';

        //lager instance av BroInterface
        // BroInterface broInterface = (n,s) -> {
        //     System.out.println("Hallo Ingve");
        //     System.out.println("Howdy "+n+s);
        // };

        BroInterface broInterface2 = (n,s) -> "How"+s;
        
        broInterface2.message(name,symbol);
    }
}
