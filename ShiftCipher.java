import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
/**
 * TODO: Implement the following ciphers:
 * Vigenere, Affine, ROT-47
 */
// TODO: Reevaluate the class hierarchy.
// Should there be Cipher -> ShiftCipher -> ..., or do we set up separate abstract classes?
abstract class ShiftCipher {

    protected Queue<Integer> encodingQ;
    protected Queue<Integer> decodingQ;

    protected ArrayList<String> alphabet;
    protected final String ALPHABET_EN = "abcdefghijklmnopqrstuvwxyz";

    protected String encoded, decoded;

    abstract public String encode(String message);
    abstract public String decode(String message);

    abstract protected void loadStructs();

    public ShiftCipher(){
        encodingQ = new LinkedList<Integer>();
        decodingQ = new LinkedList<Integer>();
        alphabet = new ArrayList<String>();
    }

}

