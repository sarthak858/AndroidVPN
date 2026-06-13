import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.util.Base64;

public class KeyGenerator {

    public static void main(String[] args) {
        try {
            String mySecretString = "This is the hidden CTF clue!";
            String myPassword = "SuperSecretPassword123";
            
            String encryptedKey = encryptString(mySecretString, myPassword);
            
            System.out.println("Original String: " + mySecretString);
            System.out.println("Encrypted Key: " + encryptedKey);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String encryptString(String plainText, String password) throws Exception {
        byte[] salt = {
            (byte)0x12, (byte)0x34, (byte)0x56, (byte)0x78,
            (byte)0x90, (byte)0xAB, (byte)0xCD, (byte)0xEF
        };

        int iterationCount = 1000;

        PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray());
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
        SecretKey secretKey = keyFactory.generateSecret(keySpec);

        PBEParameterSpec parameterSpec = new PBEParameterSpec(salt, iterationCount);

        Cipher cipher = Cipher.getInstance("PBEWithMD5AndDES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, parameterSpec);

        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }
}
