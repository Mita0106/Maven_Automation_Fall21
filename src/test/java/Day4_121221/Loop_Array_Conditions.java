package Day4_121221;

public class Loop_Array_Conditions {

    public static void main(String[] args) {

        //create a dynamic array for 4 different cities, iterate through the values but only print when city is
        //either brooklyn or queens
        String[] cities = new String[4];
        cities[0] = "Queens";
        cities[1] = "Manhattan";
        cities[2] = "Bronx";
        cities[3] = "Brooklyn";

        int i = 0;
        while (i <cities.length){
            //two if conditions
            if (cities[i] == "Brooklyn") {
                System.out.println("city is " + cities[i]);
            }else if(cities[i] == "Queens") {
                System.out.println("city is " + cities[i]);


            }//end of conditions
            i++;//incrementing

        }//end of while loop

    }//end of main

}//end of java class
