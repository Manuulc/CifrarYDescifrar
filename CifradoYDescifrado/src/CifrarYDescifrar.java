import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class CifrarYDescifrar {
    //Variables de clase
    private static final int LONGITUD = 16;
    private static final String ALGORITMO = "AES/ECB/PKCS5Padding";


    public static Key obtenerKey(String usuarioKey) {
        return new SecretKeySpec(usuarioKey.getBytes(), 0, LONGITUD, "AES");
    }

    public static String cifrar(String textoACifrar, Key key) {

        byte[] cifrado = new byte[0];
        try {

            Cipher c = Cipher.getInstance(ALGORITMO);
            c.init(Cipher.ENCRYPT_MODE, key);
            cifrado = c.doFinal(textoACifrar.getBytes());

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return Base64.getEncoder().encodeToString(cifrado);
    }

    public static String descifrar(String textoCifrado, Key key) {

        byte[] descifrar = new byte[0];
        try {

            Cipher c = Cipher.getInstance(ALGORITMO);
            c.init(Cipher.DECRYPT_MODE, key);
            descifrar = c.doFinal(Base64.getDecoder().decode(textoCifrado));

        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }

        return new String(descifrar);
    }
}