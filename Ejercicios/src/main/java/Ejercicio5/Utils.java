package Ejercicio5;

public class Utils {
    public static boolean isValidAlias(String alias) {
        return alias.matches("^[a-zA-Z0-9_]{4,15}$");
    }

    public static boolean isValidEmail(String email) {
        return email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
    }

    public static boolean isValidMessage(String message) {
        return message.length() <= 140;
    }
}
