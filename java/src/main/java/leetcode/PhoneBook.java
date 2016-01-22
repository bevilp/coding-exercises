package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * PhoneBook
 *
 * @since 2015-10-30
 */
public class PhoneBook {

    /*

    input:
        3
        uncle sam
        99912222
        tom
        11122222
        harry
        12299933
        uncle sam
        uncle tom
        harry

    output:
        uncle sam=99912222
        Not found
        harry=12299933

     */
        /*
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = Integer.valueOf(scanner.nextLine());

        Map<String, String> phoneBook = new HashMap<>(numCases);

        for (int i = 0; i < numCases; i++) {
            String name = scanner.nextLine();
            String number = scanner.nextLine();
            phoneBook.put(name, number);
        }

        while (scanner.hasNext()) {
            String name = scanner.nextLine();

            if (phoneBook.containsKey(name)) {
                System.out.println(name + "=" + phoneBook.get(name));
            } else {
                System.out.println("Not found");
            }
        }
    }      */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        Map<String, Integer> phoneBook = new HashMap<String, Integer>(n);
        for (int i = 0; i < n; i++) {
            String name = in.nextLine();
            int phone = in.nextInt();
            phoneBook.put(name, phone);
            in.nextLine();
        }
        while (in.hasNext()) {
            String name = in.nextLine();
            if (phoneBook.containsKey(name)) {
                System.out.println(name + "=" + phoneBook.get(name));
            } else {
                System.out.println("Not found");
            }
        }
    }

}
