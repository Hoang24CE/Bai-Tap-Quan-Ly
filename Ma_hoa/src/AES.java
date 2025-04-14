import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AES {

    // Mã hóa chuỗi văn bản bằng AES
    public static String encrypt(String plainText, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    // Giải mã chuỗi đã mã hóa bằng AES
    public static String decrypt(String encryptedText, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        byte[] decodedBytes = Base64.getDecoder().decode(encryptedText);
        byte[] decryptedBytes = cipher.doFinal(decodedBytes);
        return new String(decryptedBytes);
    }

    // Tạo key AES (hoặc có thể dùng khóa cố định nếu muốn)
    public static SecretKey generateKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128); // Có thể là 128, 192 hoặc 256 bit
        return keyGen.generateKey();
    }

    public static void main(String[] args) throws Exception {
        String originalText = "Hello AES!";

        // Tạo khóa
        SecretKey secretKey = generateKey();

        // Mã hóa
        String encrypted = encrypt(originalText, secretKey);
        System.out.println("Encrypted: " + encrypted);

        // Giải mã
        String decrypted = decrypt(encrypted, secretKey);
        System.out.println("Decrypted: " + decrypted);
    }
}
