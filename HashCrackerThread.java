// TODO: Implement multithreaded hash cracking
// TODO: get wordlist from pc using file chooser thing

import java.util.ArrayList;

public class HashCrackerThread implements Runnable{
        private int start; // start index of search
        private int end;
        private int hashType;
        private String hash;
        private ArrayList<String> file;

        private String cracked = null;
        public String getCracked() {return cracked;}

        public HashCrackerThread(int startIn, int endIn, int hashTypeIn, String hashIn, ArrayList<String> fileIn){
            start = startIn;
            end = endIn;
            hash = hashIn;
            hashType = hashTypeIn;
            file = fileIn;
        }

        public void run() {
            switch(hashType){
                case 0:
                    for(int i = start; i < end; i++) {
                        if(MD5.getMD5(file.get(i)).equals(hash)){ cracked = file.get(i); }
                    }
                    break;
                case 1:
                    for(int i = start; i < end; i++) {
                        try {
                            if(SHA256.toHexString(SHA256.getSHA(file.get(i))).equals(hash)){ cracked = file.get(i); }
                        } catch (Exception e) {
                            throw new RuntimeException();
                        }
                    }
                    break;
                case 2:
                    for(int i = start; i < end; i++) {
                        if(SHA1.getSHA1(file.get(i)).equals(hash)){ cracked = file.get(i); }
                    }
                    break;
                default:
                    throw new RuntimeException();
            }
            
        }
}
