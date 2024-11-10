package com.fiap.fintech.middleware;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

public class PasswordValidator {

    private static final Pattern UPPERCASE_PATTERN = Pattern.compile("[A-Z]");
    private static final Pattern LOWERCASE_PATTERN = Pattern.compile("[a-z]");
    private static final Pattern DIGIT_PATTERN = Pattern.compile("\\d");
    private static final Pattern SPECIAL_CHAR_PATTERN = Pattern.compile("[^a-zA-Z0-9]");
    private static final int MIN_LENGTH = 8;

    public static String validatePassword(String password) {
        if (password == null || password.length() < MIN_LENGTH) {
            return "A senha deve ter pelo menos " + MIN_LENGTH + " caracteres.";
        }
        if (!UPPERCASE_PATTERN.matcher(password).find()) {
            return "A senha deve conter pelo menos uma letra maiúscula.";
        }
        if (!LOWERCASE_PATTERN.matcher(password).find()) {
            return "A senha deve conter pelo menos uma letra minúscula.";
        }
        if (!DIGIT_PATTERN.matcher(password).find()) {
            return "A senha deve conter pelo menos um dígito.";
        }
        if (!SPECIAL_CHAR_PATTERN.matcher(password).find()) {
            return "A senha deve conter pelo menos um caractere especial.";
        }
        return null;
    }

    public static String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder(2 * hash.length);
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Erro ao gerar o hash da senha: " + e.getMessage());
            throw new RuntimeException("Erro ao gerar o hash da senha", e);
        }
    }
}
