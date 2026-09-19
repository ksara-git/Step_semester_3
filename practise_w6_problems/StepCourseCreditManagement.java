class StepCourseCreditManagement {

    String code;
    String title;
    int credits;
    int labCredits;

    public StepCourseCreditManagement(String code, String title, int credits, int labCredits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.labCredits = labCredits;
    }

    public StepCourseCreditManagement(String code, String title, int credits) {
        this(code, title, credits, 0);
    }

    int totalCredits() {
        return credits + labCredits;
    }

    public static void main(String[] args) {

        StepCourseCreditManagement course1 =
            new StepCourseCreditManagement("21CSC201J", "Data Structures", 4);

        StepCourseCreditManagement course2 =
            new StepCourseCreditManagement("21CSC205L", "DSA Lab", 3, 1);

        System.out.println(course1.code + " total credits: " + course1.totalCredits());
        System.out.println(course2.code + " total credits: " + course2.totalCredits());
    }
}