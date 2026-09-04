import java.util.*;

class WordFrequency {

    static void printFilteredWordFrequency(String feedback) {

        String[] stopWords = {"the", "was", "and", "a", "is"};

        feedback = feedback.toLowerCase();

        feedback = feedback.replace(".", "");
        feedback = feedback.replace(",", "");

        String[] words = feedback.split("\\s+");

        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {

            boolean isStopWord = false;

            for (String stop : stopWords) {
                if (word.equals(stop)) {
                    isStopWord = true;
                    break;
                }
            }

            if (!isStopWord) {
                if (map.containsKey(word)) {
                    map.put(word, map.get(word) + 1);
                } else {
                    map.put(word, 1);
                }
            }
        }

        ArrayList<String> wordsList = new ArrayList<>(map.keySet());

        Collections.sort(wordsList, (a, b) -> {
            return map.get(b) - map.get(a);
        });

        for (String word : wordsList) {
            System.out.println(word + ": " + map.get(word));
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String feedback = sc.nextLine();

        printFilteredWordFrequency(feedback);
    }
}