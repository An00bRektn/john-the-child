import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;

/**
 * Credit to GeeksforGeeks for implementation of hashing algorithms
 * Modified to include multithreaded brute forcing
 * https://www.geeksforgeeks.org/md5-hash-in-java/
 * https://www.geeksforgeeks.org/sha-256-hash-in-java/
 */
class MD5 {
    public static String getMD5(String input){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            // input --> byte array used in hash algorithm
            byte[] messageDigest = md.digest(input.getBytes());
  
            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);
  
            // Convert md into hex value
            String hashed = no.toString(16);
            while (hashed.length() < 32) {
                hashed = "0" + hashed;
            }
            return hashed;
        } 
        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            System.out.println(e);
            return null;
        }
    }

    public static String crackMD5(String hash){
        return "";
    }
}

class SHA256{
    public static byte[] getSHA(String input) throws NoSuchAlgorithmException
    { 
        // Configure to use SHA-256
        MessageDigest md = MessageDigest.getInstance("SHA-256"); 

        return md.digest(input.getBytes(StandardCharsets.UTF_8)); 
    }
    
    public static String toHexString(byte[] hash)
    {
        // Convert byte array into signum representation 
        BigInteger number = new BigInteger(1, hash); 
  
        // Convert message digest into hex value 
        StringBuilder hexString = new StringBuilder(number.toString(16)); 
  
        // Pad with leading zeros
        while (hexString.length() < 32) 
        { 
            hexString.insert(0, '0'); 
        } 
  
        return hexString.toString(); 
    }

    public static String crackSHA(String hash){
        return "";
    }
}
