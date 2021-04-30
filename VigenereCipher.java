class VigenereCipher extends ShiftCipher {
    private String key;
    private Integer keyValue;
    VigenereCipher(){
        super();
        key = "";
        loadStructs();
    }
    VigenereCipher(String keyIn){
        super();
        key = keyIn;
        loadStructs();
    }
    VigenereCipher(String keyIn, String alphabetIn){
        super();
        key = keyIn;
        loadStructs(alphabetIn);
    }

    // TODO: Debug this immediately
    public String encode(String message) {
        encoded = "";
        int charIndex;
        for(int i=0; i<message.length();i++){
            if(isInAlphabet(String.valueOf(message.charAt(i)).toLowerCase())){
                keyValue = encodingQ.remove();
                charIndex = indexOf(String.valueOf(message.charAt(i)));
                encoded += alphabet.get(((charIndex + keyValue) % alphabet.size()));
                encodingQ.add(keyValue);
            }
            else{
                encoded += message.charAt(i);
            }
        }
        return encoded;
    }

    @Override
    public String decode(String message) {
        decoded = "";
        int charIndex;
        for(int i=0; i<message.length(); i++){
            if(isInAlphabet(String.valueOf(message.charAt(i)))){
                keyValue = decodingQ.remove();
                charIndex = indexOf(String.valueOf(message.charAt(i)));
                decoded += alphabet.get(((charIndex - keyValue + alphabet.size()) % alphabet.size()));
                decodingQ.add(keyValue);
            }
            else{
                decoded += message.charAt(i);
            }
        }
        return decoded;
    }

    protected void loadStructs(){ 
        String tmp;
        for(int i=0; i<ALPHABET_EN.length(); i++){
            alphabet.add(String.valueOf(ALPHABET_EN.charAt(i)));
        }
        for(int i=0; i<key.length(); i++){
            tmp = String.valueOf(key.charAt(i));
            encodingQ.add(indexOf(tmp));
            decodingQ.add(indexOf(tmp));
        }
    }

    protected void loadStructs(String alphabetIn){
        String tmp;
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
        for(int i=0; i<key.length(); i++){
            tmp = String.valueOf(key.charAt(i));
            encodingQ.add(indexOf(tmp));
            decodingQ.add(indexOf(tmp));
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

    private int indexOf(String character){
        int i = 0;
        int returnValue = 0;
        for (String s : alphabet) {
            if(character.toLowerCase().equals(s)){
                returnValue = i;
            }
            i++;
        }
        return returnValue;
    }
    
}