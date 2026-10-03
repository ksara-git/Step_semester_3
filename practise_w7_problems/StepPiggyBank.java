class StepScorecard {
    private boolean[] results;
    private final int totalQuestions;
    private int count;

    StepScorecard(int totalQuestions) {
        this.totalQuestions = totalQuestions;
        results = new boolean[totalQuestions];
        count = 0;
    }

    void recordAnswer(boolean answer) {
        if (count < totalQuestions) {
            results[count] = answer;
            count++;
        }
    }

    int getScore() {
        int score = 0;

        for (int i = 0; i < count; i++) {
            if (results[i]) {
                score++;
            }
        }

        return score;
    }

    public static void main(String[] args) {
        StepScorecard sc = new StepScorecard(4);

        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println(sc.getScore());
    }
}