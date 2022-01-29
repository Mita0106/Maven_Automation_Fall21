package ActionItem2;

public class Question2 {
    public static void main(String[] args) {
        //Create a dynamic array for 4 states iterating through the values but only print when state is either NY or FL
        String[] state = new String[4];
        state[0] = "New York";
        state[1] = "Pennsylvania";
        state[2] = "Texas";
        state[3] = "Florida";

        int i = 0;
        while (i < state.length) {
            //two if conditions
        if (state[i] == "New York") {
            System.out.println("State is " + state[i]);
        } else if (state[i] == "Florida") {
            System.out.println("State is " + state[i]);

        }//end of conditions
        i++; //incrementing

        }//end of while loop

    }//end of main


}//end of java class
