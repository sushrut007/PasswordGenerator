import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to Password Generator!");
        System.out.println("Let's customize your password.");
        
        // Asking user preferences
        System.out.print("Do you want lower case letters in your password? (yes/no): ");
        boolean includeLowercase = scanner.nextLine().equalsIgnoreCase("yes");
        
        System.out.print("Do you want upper case letters in your password? (yes/no): ");
        boolean includeUppercase = scanner.nextLine().equalsIgnoreCase("yes");
        
        System.out.print("Do you want numbers in your password? (yes/no): ");
        boolean includeNumbers = scanner.nextLine().equalsIgnoreCase("yes");
        
        System.out.print("Do you want special symbols in your password? (yes/no): ");
        boolean includeSymbols = scanner.nextLine().equalsIgnoreCase("yes");
        
        System.out.print("Enter the length of the password: ");
        int length = scanner.nextInt();
        
        // Generate password based on preferences
        String password = generatePassword(includeLowercase, includeUppercase, includeNumbers, includeSymbols, length);
        
        System.out.println("Your generated password is: " + password);
    }
    
    private static String generatePassword(boolean includeLowercase, boolean includeUppercase, boolean includeNumbers, boolean includeSymbols, int length) {
        StringBuilder password = new StringBuilder();
        SecureRandom random = new SecureRandom();
        String lowercaseChars = "abcdefghijklmnopqrstuvwxyz";
        String uppercaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numberChars = "0123456789";
        String symbolChars = "@#_$%^&*";
        String allChars = "";
        
        if (includeLowercase) allChars += lowercaseChars;
        if (includeUppercase) allChars += uppercaseChars;
        if (includeNumbers) allChars += numberChars;
        if (includeSymbols) allChars += symbolChars;
        
        if (allChars.isEmpty()) {
            System.out.println("No character set selected. Please choose at least one.");
            return "";
        }
        
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(allChars.length());
            password.append(allChars.charAt(randomIndex));
        }
        
        return password.toString();
    }
}