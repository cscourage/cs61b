public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> result = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            result.addLast(word.charAt(i));
        }
        return result;
    }

    public boolean isPalindrome(String word) {
        /*
        if (word == null || word.length() <= 1) {
            return true;
        }
        String result = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            result += word.charAt(i);
        }
        return word.equals(result);
        */
        Deque<Character> tmp = wordToDeque(word);
        return isPalindromeHelper(tmp, 0, word);
    }

    /* According to the guidance of the pro1b, it says that we would better use
     * method wordToDeque and better to use recursion, so I do it.
     * And notice I use short-circuiting operators so the input should be
     * removed last item first and then use recursion.
     */
    private boolean isPalindromeHelper(Deque<Character> input, int index, String word) {
        if (input.size() == 0) {
            return true;
        }
        return input.removeLast() == word.charAt(index) && isPalindromeHelper(input, index + 1, word);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        int len = word.length();
        int middle = len / 2;
        for (int i = 0; i < middle; i++) {
            if (!cc.equalChars(word.charAt(i), word.charAt(len - 1 - i))) {
                return false;
            }
        }
        return true;
    }
}
