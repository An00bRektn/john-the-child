import java.util.Queue;
import java.util.LinkedList;

abstract class ShiftCipher {
    // TODO: Write setters and getters
    
    protected Queue<Integer> encodingQ;
    protected Queue<Integer> decodingQ;

    protected String[] alphabet;
    protected String encoded, decoded;

    abstract public String encode(String message);
    abstract public String decode(String text);

    abstract protected void loadQueue();

    public ShiftCipher(){
        encodingQ = new LinkedList<Integer>();
        decodingQ = new LinkedList<Integer>();
    }
}

class CaesarCipher extends ShiftCipher {
    private int key;
    private Integer keyValue;
    CaesarCipher(){
        super();
        key = 0;
    }
    CaesarCipher(int keyIn){
        super();
        key = keyIn;
    }

    @Override
    public String encode(String message) {
        encoded = "";
        for(int i=0; i<message.length();i++){
            keyValue = encodingQ.remove();
            encoded += (char) (message.charAt(i) + keyValue);
            encodingQ.add(keyValue);
        }
        return encoded;
    }

    @Override
    public String decode(String text) {
        decoded = "";
        for(int i=0; i<text.length(); i++){
            keyValue = decodingQ.remove();
            decoded += (char) (text.charAt(i) - keyValue);
            decodingQ.add(keyValue);
        }
        return decoded;
    }

    protected void loadQueue(){ 
        encodingQ.add(key);
        decodingQ.add(key);
    }
    
}