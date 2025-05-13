package assignments;

public class Assignment18_palindrome {

    public static void main(String[] args) {
        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car";
        
        System.out.println(isPalindrome(s1)); // true
        System.out.println(isPalindrome(s2)); // false
    }

    public static boolean isPalindrome(String s) {
        // Convert to lowercase and remove non-alphanumeric characters
        String cleaned = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        // Reverse the string
        String reversed = "";
        for (int i = cleaned.length() - 1; i >= 0; i--) {
			reversed += cleaned.charAt(i);
		}

        // Compare original cleaned with reversed
        return cleaned.equals(reversed);
    }
}
