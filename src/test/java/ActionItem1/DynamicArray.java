package ActionItem1;

public class DynamicArray {
    public static class ActionItem1Dynamic {
        public static void main(String[] args) {
            //create a String dynamic array for zipCode
            String[] zipCode = new String[4];
            //defining values for the variable indexing
            zipCode[0] = "11365";
            zipCode[1] = "11103";
            zipCode[2] = "11373";
            zipCode[3] = "11101";

            //Integer dynamic array
            int[] streetNumber = new int[4];
            streetNumber[0] = 222;
            streetNumber[1] = 333;
            streetNumber[2] = 444;
            streetNumber[3] = 555;

            System.out.println("My zip code is " + zipCode[0] + " and my street number is " + streetNumber[2]);

        }//end of main

    }//end of java class
}
