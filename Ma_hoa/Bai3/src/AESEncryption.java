import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESEncryption implements Encryptable {
    private static final String ALGORITHM = "AES";
    private final SecretKeySpec key;

    public AESEncryption() {
        byte[] keyBytes = "1234567890123456".getBytes(); // 16-byte key
        key = new SecretKeySpec(keyBytes, ALGORITHM);
    }

    @Override
    public String encrypt(String data) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes()));
    }

    @Override
    public String decrypt(String data) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        return new String(cipher.doFinal(Base64.getDecoder().decode(data)));
    }
}
