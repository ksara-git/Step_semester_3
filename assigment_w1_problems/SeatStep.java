public class SeatStep {
    public static void main(String args[]){
        int[] seats = {101, 102, 103, 102, 105};
        int duplicate = 0;

    for(int i=0; i<seats.length; i++){
        for(int j=i+1; j<seats.length; j++){
            if(seats[i] == seats[j]){
                duplicate = seats[i];
            }

        }
    }
    System.out.println("Duplicate Seat Number Found: " + duplicate);
    }
}
    
