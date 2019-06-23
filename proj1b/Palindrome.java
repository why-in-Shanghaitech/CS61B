public class Palindrome {
    /**
     * Return a Deque where the characters appear in the same order as in the String.
     * @param word
     * @return Deque
     */
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> result = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            result.addLast(word.charAt(i));
        }
        return result;
    }

    /**
     * The isPalindrome method should return true if the given word is a palindrome,
     * and false otherwise. A palindrome is defined as a word that is the same whether
     * it is read forwards or backwards. For example “a”, “racecar”, and “noon” are
     * all palindromes. “horse”, “rancor”, and “aaaaab” are not palindromes.
     * Any word of length 1 or 0 is a palindrome.
     * @param word
     * @return
     */
    public boolean isPalindrome(String word) {
        if (word.length() <= 1) {
            return true;
        }

        Deque<Character> wordList = wordToDeque(word);
        while (wordList.size() > 1) {
            if (wordList.removeFirst() != wordList.removeLast()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Overload isPalindrome.
     * @param word
     * @param cc
     * @return
     */
    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word.length() <= 1) {
            return true;
        }

        Deque<Character> wordList = wordToDeque(word);
        while (wordList.size() > 1) {
            char a = wordList.removeFirst();
            char b = wordList.removeLast();

            if (!cc.equalChars(a, b)) {
                return false;
            }
        }
        return true;
    }
}
