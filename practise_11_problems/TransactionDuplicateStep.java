
import java.util.HashSet;

public class TransactionDuplicateStep {

    public static boolean hasDuplicate(String[] ids) {
        HashSet<String> set = new HashSet<>();

        for (String id : ids) {
            if (set.contains(id))
                return true;

            set.add(id);
        }

        return false;
    }

    public static void main(String[] args) {
        String[] ids = {"TXN1001", "TXN1002", "TXN1003",
                        "TXN1002", "TXN1004"};

        System.out.println(hasDuplicate(ids));
    }
}
