/** This class outputs all palindromes in the words file in the current directory. */
public class PalindromeFinder {
    public static void main(String[] args) {
        int minLength = 4;
        In in = new In("../library-sp18/data/words.txt");
        Palindrome palindrome = new Palindrome();

        while (!in.isEmpty()) {
            String word = in.readString();
            /* the first fun of printing one meaning of palindrome. */
            if (word.length() >= minLength && palindrome.isPalindrome(word)) {
                System.out.println(word);
            }
            /* the second fun of printing another meaning of palindrome.
            CharacterComparator cc = new OffByOne();
            if (word.length() >= minLength && palindrome.isPalindrome(word, cc)) {
                System.out.println(word);
            }
            */
            /* choose N, and as an example I choose 4.
            CharacterComparator cc = new OffByN(4);
            if (word.length() >= minLength && palindrome.isPalindrome(word, cc)) {
                System.out.println(word);
            }
            */
        }
    }
}
