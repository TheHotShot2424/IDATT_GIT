package FORELESNINGER;

// draw.io er måte å skrive diagrammer digitalt!

import static javax.swing.JOptionPane.*;

public class forelesn2{

    public static void calculate(int number1, int number2, boolean option){
        // //boolean variable = false;
        // String answer = "Svar er: ";
        // if(option == true){
        //     int total = number1 + number2;
        //         //Integer til string skjer automatisk, men ikke andre vei. 
        //         // String += Int  -->  String og String
        //         // Int += String --> Går ikke. Må konvertere: 
        //         //int totalString = Integer.parseInt(total);
        //     answer += total; //answer = answer + total;
        //     System.out.println(answer);
        // }

        // if(option == false){

        // }


        int variable;
        String answer = "Svaret; ";
        String tall = "34";
        if(option == true){
            int total = number1 + number2;
            
            answer += total;
            
            total += Integer.parseInt(tall);
            
            System.out.println(answer);
            System.out.println(tall + " pluss numbs is: " + total);
        }

        // if(number1 < 0){
        //     if(number2 > 0 && number2 < 100){
        //         if(true){
        //             if(true){

        //                 //etc...
        //             }
        //         }
        //     }
        // }
        if(number1 > number2) if(number1 > 0) if(number1 < 100)
            System.out.println("Merkelig måte å skrive på men den er gyldig...");
        
        if(number1 >= number2 && number1 > 0 && number1 < 100)
            System.out.println("Mer vanlig måte å skrive på");
            String karakter = "";
            int points = 0; 
            if(true){
                karakter = "A";
            }


            switch (points) {
                case 40,80:
                    System.out.println("BRA!");
                    break;
                case 20,10:
                    System.out.println("NA..");
                    break;
                default:
                    break;
            }

            
            // String answera = (number1>number2) ? "TO BE PRINTED" : "Bababbab";
            // System.out.println(answera);
            
            
            int answera = 0;
            // samme som:
            // if(!(number1>number2)){
            //     answera = number1-number2;
            // } else if(number1 == 0){
            //     answera = number2-number1; 
            // }

            // if(number1 instanceof int && (number1 > 0 || number2 > 0)){

            // }

            String str1 = "abc";
            String str2 = "ABC";

            if(str1.equalsIgnoreCase(str2)){ //eller str1.equals(str2)
                System.out.println("Like ord, tross captions");
            }

            //----------------------------------------------------------

            double num1 = 10.00001;
            double num2 = 10.0000000001;

            double toleranse = 0.00001;

            if(Math.abs(num1-num2) < toleranse){
                System.out.println("Num1 er lik num2");
            }

    }

    public static void main(String[] args){
        // System.out.println("Hei");
        // String hei = showInputDialog("Babba");
        // System.out.println(hei);

        int number1 = 10;
        int number2 = 11;

        int total = number1 + number2;

        if(total > 20){
            int number3 = 20;
            total = 0;
            System.out.println("Blud");
        }
        else{
            total += 1;
            total++;
            total--;
            System.out.println("Too small");
        }
        calculate(number1, number2, true);
    }
}