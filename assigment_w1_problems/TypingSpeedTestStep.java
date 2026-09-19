public class TypingSpeedTestStep{
    static void checkTypingAccuracy(String original, String typed){

        int matched = 1;
        int mismatched = -1;

        for(int i=0; i<original.length(); i++){

            if(original.charAt(i) == typed.charAt(i)){
                matched++;
            } else if(mismatched == -1){
                mismatched = i;
            }
        }
        double accuracy = (matched * 100.0) / original.length();
        System.out.println("Matched: " + matched + "/" + original.length());
        System.out.println("Accuracy: " + accuracy + "%");
        
        if (mismatched == -1) {
            System.out.println("No Mismatches");
        } else {
            System.out.println("First Mismatch at position: " + (mismatched + 1));
        }
    }

    public static void main(String args[]) {

        String original = "hello world";
        String typed = "hello worlt";

        checkTypingAccuracy(original, typed);
    }
}