import java.util.ArrayList;
import java.util.List;

/**
 * AllPermutations
 *
 * @since 2015-12-03
 */
public class AllPermutations {

    public static void main(String[] args) {
        String string = "abcd";
        List<String> permutations = new ArrayList<>();
        permutations.add("" + string.charAt(0));

        for (int i = 1; i < string.length(); i++) {
            permutations = getAllPermutations(string.charAt(i), permutations);
        }

        permutations.forEach(s -> System.out.println(s));
    }

    public static List<String> getAllPermutations(char c, List<String> permutations) {
        List<String> permutationResult = new ArrayList<>();
        for (String permutation : permutations) {
            for (int i = 0; i <= permutation.length(); i++) {
                permutationResult.add(insertAtIndex(c, i, permutation));
            }
        }
        return permutationResult;
    }

    private static String insertAtIndex(char c, int index, String string) {
        StringBuilder sb = new StringBuilder(string.length() + 1);
        sb.append(string.substring(0, index)).append(c).append(string.substring(index, string.length()));
        return sb.toString();
    }
}
