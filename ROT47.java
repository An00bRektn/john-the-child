// INFO: https://en.wikipedia.org/wiki/ROT13
class ROT47 extends ShiftCipher{
    private int key = 47;
    private Integer keyValue;

    ROT47(){
        super();
        loadStructs();
    }

    public String encode(String message) {
        encoded = "";
        for(int i=0; i<message.length();i++){
            keyValue = encodingQ.remove();
            if(isInAlphabet(String.valueOf(message.charAt(i)))){
                if(message.charAt(i) + keyValue > 126){
                    encoded += (char) (((message.charAt(i) + keyValue) - 94));
                }
                else{
                    encoded += (char) (message.charAt(i) + keyValue);
                }
            }
            else{
                encoded += message.charAt(i);
            }
            encodingQ.add(keyValue);
        }
        return encoded;
    }

    @Override
    public String decode(String message) {
        decoded = "";
        for(int i=0; i<message.length(); i++){
            keyValue = decodingQ.remove();
            if(isInAlphabet(String.valueOf(message.charAt(i)))){
                if(message.charAt(i) - keyValue < 33){
                    decoded += (char) ((message.charAt(i) - keyValue) + 94);
                }
                else{
                    decoded += (char) (message.charAt(i) - keyValue);
                }
            }
            else{
                decoded += message.charAt(i);
            }
            decodingQ.add(keyValue);
        }
        return decoded;
    }
    protected void loadStructs(){ 
        encodingQ.add(key);
        decodingQ.add(key);
        for(int i=33; i<127; i++){
            alphabet.add(String.valueOf((char) i));
        }
    }

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