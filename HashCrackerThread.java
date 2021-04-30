// TODO: Implement multithreaded hash cracking
// TODO: get wordlist from pc using file chooser thing
public class HashCrackerThread implements Runnable{
    public int getThreadID(){return tid;}
    private int tid;
    
    HashCrackerThread(int tidIn){
        tid = tidIn;
    }
    
    public void run(){

    }
}
