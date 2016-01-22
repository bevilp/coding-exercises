package leetcode;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * HashSetPair
 *
 * @since 2015-10-30
 */
public class HashSetPair {

    /**
     *
     * Pair class isn't really necessary but what the hell.
     *
     */
    static class Pair {

        private String name1;

        private String name2;

        Pair(String name1, String name2) {
            if (null == name1 || null == name2) {
                throw new IllegalArgumentException();
            }

            if (name1.compareTo(name2) > 0) {
                this.name1 = name1;
                this.name2 = name2;
            } else {
                this.name1 = name2;
                this.name2 = name1;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Pair pair = (Pair) o;

            if (name1 != null ? !name1.equals(pair.name1) : pair.name1 != null) {
                return false;
            }
            return !(name2 != null ? !name2.equals(pair.name2) : pair.name2 != null);

        }

        @Override
        public int hashCode() {
            int result = name1 != null ? name1.hashCode() : 0;
            result = 31 * result + (name2 != null ? name2.hashCode() : 0);
            return result;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();
        Set<Pair> pairs = new HashSet<>(numCases);

        for (int i = 0; i < numCases; i++) {
            Pair pair = new Pair(scanner.next(), scanner.next());
            pairs.add(pair);
            System.out.println(pairs.size());
        }
    }
}
