public class EncryptDecryptTask implements Runnable {
    private final Encryptable encryptable;
    private final String data;
    private final boolean encrypt;

    public EncryptDecryptTask(Encryptable encryptable, String data, boolean encrypt) {
        this.encryptable = encryptable;
        this.data = data;
        this.encrypt = encrypt;
    }

    @Override
    public void run() {
        try {
            String result = encrypt ? encryptable.encrypt(data) : encryptable.decrypt(data);
            System.out.println((encrypt ? "Encrypted: " : "Decrypted: ") + result);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
