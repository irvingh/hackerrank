import java.nio.charset.StandardCharsets;

public class Security {
    Security() { md5(); }
    public static void md5() {
        String pas = "HellowWorld";
        String t = "Javarmi123";
        try {
            java.security.MessageDigest sha = java.security.MessageDigest.getInstance("SHA-256");
            byte[] hash = sha.digest(t.getBytes(StandardCharsets.UTF_8));
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            System.out.println(hexString.toString());
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA-256");
            byte[] array = md.digest(pas.getBytes(StandardCharsets.UTF_8));
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
            System.out.println(sb.toString());
        } catch (java.security.NoSuchAlgorithmException e) {
        }
    }
}