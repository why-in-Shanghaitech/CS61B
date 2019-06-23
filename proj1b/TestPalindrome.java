import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    } /* Uncomment this class once you've created your Palindrome class. */

    @Test
    public void testisPalindromeA1() {
        // normal true or false. Nothing tricky.
        assertFalse(palindrome.isPalindrome("cat"));
        assertFalse(palindrome.isPalindrome("horse"));

        assertTrue(palindrome.isPalindrome("pop"));
        assertTrue(palindrome.isPalindrome("level"));

    }

    @Test
    public void testisPalindromeA2() {
        // corner cases.
        assertFalse(palindrome.isPalindrome("Anna"));

        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome(""));

    }

    @Test
    public void testisPalindromeB1() {
        // normal true or false. Nothing tricky.
        CharacterComparator cc = new OffByOne();

        assertFalse(palindrome.isPalindrome("cat", cc));
        assertFalse(palindrome.isPalindrome("what", cc));

        assertTrue(palindrome.isPalindrome("flake", cc));
        assertTrue(palindrome.isPalindrome("srt", cc));

    }

    @Test
    public void testisPalindromeB2() {
        // corner cases.
        CharacterComparator cc = new OffByOne();

        assertFalse(palindrome.isPalindrome("Flake", cc));

        assertTrue(palindrome.isPalindrome("a", cc));
        assertTrue(palindrome.isPalindrome("", cc));

    }

    @Test
    public void testisPalindromeC1() {
        // normal true or false. Nothing tricky.
        CharacterComparator cc = new OffByN(5);

        assertFalse(palindrome.isPalindrome("cat", cc));
        assertFalse(palindrome.isPalindrome("what", cc));

        assertTrue(palindrome.isPalindrome("afaaf", cc));
        assertTrue(palindrome.isPalindrome("frk", cc));

    }

    @Test
    public void testisPalindromeC2() {
        // corner cases.
        CharacterComparator cc = new OffByN(5);

        assertFalse(palindrome.isPalindrome("Frh", cc));

        assertTrue(palindrome.isPalindrome("a", cc));
        assertTrue(palindrome.isPalindrome("", cc));

    }
}
