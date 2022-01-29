package ActionItem1;

public class WhileLoop {
    public static void main(String[] args) {
        //iterate through all boroughs defined by dynamic array using while loop
        String[] zipCode = new String[4];
        zipCode[0] = "11365";
        zipCode[1] = "11103";
        zipCode[2] = "11373";
        zipCode[3] = "11101";

        //integer for loop
        int[] streetNumber = new int[4];
        streetNumber[0] = 222;
        streetNumber[1] = 333;
        streetNumber[2] = 444;
        streetNumber[3] = 555;

        //declare and define the initial starting point
        int i=0;
        //define while loop with your end point (condition)
        while (i< zipCode.length){
            System.out.println("My zip code is " + zipCode[i] + " and my street number is " + streetNumber[i]);
            i= i+1;

        }//end of while loop

    }//end of main

}//end of java class
