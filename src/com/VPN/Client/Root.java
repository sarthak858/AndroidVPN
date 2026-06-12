import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class PasswordGenerator {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        
	// something's missing > kuch to byte hai 

        ByteBuffer buffer = ByteBuffer.allocate(bytes.length + Integer.BYTES);
        buffer.put(bytes);
        buffer.putInt(number);
        byte[] combined = buffer.array();

        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(combined);

        String base64 = Base64.getUrlEncoder().withoutPadding().encodeToString(hash);
        String password = base64.substring(0, 8);

        System.out.println(password);
    }
}
