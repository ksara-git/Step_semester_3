class StepNameTag {
    private final String firstName;
    private final String lastName;

    StepNameTag(String fullName) {
        String[] name = fullName.split(" ");
        firstName = name[0];
        lastName = name[1];
    }

    String getNickname() {
        return firstName + " " + lastName.charAt(0) + ".";
    }

    public static void main(String[] args) {
        StepNameTag tag = new StepNameTag("Maria Gomez");

        System.out.println(tag.getNickname());
    }
}