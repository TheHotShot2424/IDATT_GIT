class DoubleForLoop {
    public static void main(String[] args){
        for (int lineCounter = 0; lineCounter < 10; lineCounter++) {
            int sum = 0;
            for (int number = 1; number <= lineCounter; number++) {
                   sum += number;
                   System.out.print(number + " ");
             } // for number
             System.out.println("Summen blir: " + sum);
           } // for linecounter      
    }
}