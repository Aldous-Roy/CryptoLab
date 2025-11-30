import java.security.*;
import java.util.*;

class DSSDemo {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String msg = sc.nextLine();

        KeyPair kp = KeyPairGenerator.getInstance("DSA").generateKeyPair();
        Signature s = Signature.getInstance("SHA1withDSA");

        s.initSign(kp.getPrivate());
        s.update(msg.getBytes());
        byte[] sig = s.sign();

        System.out.println("Signature:");
        for (byte b : sig) System.out.printf("%02x", b);
        System.out.println();

        s.initVerify(kp.getPublic());
        s.update(msg.getBytes());
        System.out.println("Verified: " + s.verify(sig));
    }
}
