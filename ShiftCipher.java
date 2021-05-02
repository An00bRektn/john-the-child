import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

/**
 * TODO: Implement the following ciphers:
 * Affine, Ave Maria, Playfair, Railfence, Columnar Transposition, Polybius Square
 * Please use separate classes
 * 
 * TODO: Reevaulate the class hierarchy and redesign as needed
 * Should there be Cipher -> ShiftCipher -> ..., or do we set up separate abstract classes?
 * for each type of cipher?
 * 
 * TODO: Implement a multithreaded brute force decryption for ciphers as appropriate
 * Tip: See dcode.fr for their implementations
 */

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

