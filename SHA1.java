import java.security.*;
import java.util.*;

class SHA1Demo {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String msg = sc.nextLine();                 // input text

        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] digest = md.digest(msg.getBytes());

        StringBuilder hex = new StringBuilder();
        for (byte b : digest) hex.append(String.format("%02x", b));
        System.out.println("SHA-1: " + hex.toString());
    }
}
