class StepPasswordChecker {
    private final String password;

    StepPasswordChecker(String password) {
        this.password = password;
    }

    String getStrength() {
        if (password.length() < 6) {
            return "Weak";
        } else if (password.length() <= 9) {
            return "Medium";
        } else {
            return "Strong";
        }
    }

    public static void main(String[] args) {
        StepPasswordChecker pc = new StepPasswordChecker("abcd");
        System.out.println(pc.getStrength());

        StepPasswordChecker pc2 = new StepPasswordChecker("abcdefghij");
        System.out.println(pc2.getStrength());
    }
}