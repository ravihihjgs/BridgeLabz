import java.util.*;

public class anagram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine(); 
        String str2 = sc.nextLine();
        if (areAnagrams(str1, str2)) {
            System.out.println("String are anagrams.");
        } else {
            System.out.println("String are not anagrams.");
        }
    }

    public static boolean areAnagrams(String str1, String str2) {    
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        if (str1.length() != str2.length()) {
            return false;
        }
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        return Arrays.equals(charArray1, charArray2);
    }
}


