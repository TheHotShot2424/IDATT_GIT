class DifferentLoops {
    public static void main(String[] args){
        int numberOfLines = 5;  // endre til 0 å se hva som skjer da.
        System.out.println("while:\n---------------");
        int whileCount=0;
        while (whileCount < numberOfLines){
            System.out.println("En linje");
            whileCount++;
        }

        System.out.println("\nfor:\n---------------");
        for(int forCount=0; forCount<numberOfLines;forCount++){
            System.out.println("En linje");
        }

        System.out.println("\ndo-while:\n---------------");
        int doCount = 0;
        do{
            System.out.println("En linje");
            doCount++;
        } while(doCount<numberOfLines);
    }
    
}