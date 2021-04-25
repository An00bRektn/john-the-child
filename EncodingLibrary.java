import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

abstract class ShiftCipher {
    // TODO: Write setters and getters
    
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

class CaesarCipher extends ShiftCipher {
    private int key;
    private Integer keyValue;
    CaesarCipher(){
        super();
        key = 0;
        loadStructs();
    }
    CaesarCipher(int keyIn){
        super();
        key = keyIn;
        loadStructs();
    }
    CaesarCipher(int keyIn, String alphabetIn){
        super();
        key = keyIn;
        loadStructs(alphabetIn);
    }

    // TODO: get a wrapping alphabet
    @Override
    public String encode(String message) {
        int charIndex;
        encoded = "";
        message = message.toLowerCase();
        for(int i=0; i<message.length();i++){
            keyValue = encodingQ.remove();
            if(alphabet.equals(null)){
                encoded += (char) (message.charAt(i) + keyValue);
            }
            else{
                if(isInAlphabet(String.valueOf(message.charAt(i)))){
                    charIndex = alphabet.indexOf(String.valueOf(message.charAt(i)));
                    encoded += alphabet.get((charIndex + keyValue) % alphabet.size());
                }
                else{
                    encoded += message.charAt(i);
                }
            }
            encodingQ.add(keyValue);
        }
        return encoded;
    }

    @Override
    public String decode(String message) {
        int charIndex;
        decoded = "";
        message = message.toLowerCase();
        for(int i=0; i<message.length(); i++){
            keyValue = decodingQ.remove();
            if(alphabet.equals(null)){
                decoded += (char) (message.charAt(i) - keyValue);
            }
            else{
                if(isInAlphabet(String.valueOf(message.charAt(i)))){
                    charIndex = alphabet.indexOf(String.valueOf(message.charAt(i)));
                    decoded += alphabet.get(((charIndex - keyValue) + alphabet.size()) % alphabet.size());
                }
                else{
                    decoded += message.charAt(i);
                }
            }
            decodingQ.add(keyValue);
        }
        return decoded;
    }

    protected void loadStructs(){ 
        encodingQ.add(key);
        decodingQ.add(key);
        for(int i=0; i<ALPHABET_EN.length(); i++){
            alphabet.add(String.valueOf(ALPHABET_EN.charAt(i)));
        }
    }

    protected void loadStructs(String alphabetIn){
        encodingQ.add(key);
        decodingQ.add(key);
        if(alphabetIn.equals("") || alphabetIn.equals(" ")){
            for(int i=0; i<ALPHABET_EN.length(); i++){
                alphabet.add(String.valueOf(ALPHABET_EN.charAt(i)));
            }
        }
        else{
            for(int i=0; i<alphabetIn.length(); i++){
                alphabet.add(String.valueOf(alphabetIn.charAt(i)));
            }
        }      
    }

    // TODO: Implement a binary search instead???
    private Boolean isInAlphabet(String character){
        Boolean returnValue = false;
        for (String s : alphabet) {
            if(character.equals(s)){
                returnValue = true;
            }
        }
        return returnValue;
    }
    
}