package ActionItem1;

public class ForLoop {
    public static void main(String[] args) {
        //iterate through all zip codes defined by dynamic array using for loop
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

        for (int i=0; i < zipCode.length; i++){
            System.out.println("My zip code is " + zipCode[i] + " and my street number is " + streetNumber[i]);



        }//end of for loop





    }//end of main


}//end of java class
