public class Help {
    
    public static String displayHelp(){
        StringBuilder buff = new StringBuilder();
        buff.append("<html>");
        buff.append("John the Child (c) 2021" + "<br><br>");
        buff.append("The tabs at the top will switch between the different menus" + "<br>");
        buff.append("To encipher or hash text, type your text into the left panel" + "<br>");
        buff.append("Use the options in the middle to use specific keys or custom alphabets" + "<br>");
        buff.append("Please keep all inputs into the custom alphabet field or key field as long strings" + "<br><br>");
        buff.append("Example:" + "<br>");
        buff.append("   \"ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789\" is good" + "<br>");
        buff.append("   \"A B C D E F 0 1 2 3 4 5 6 7 8 9\" is bad" + "<br>");
        buff.append("   \"A,B,C,D,E,F,0,1,2,3,4,5,6,7,8,9\" is bad" + "<br><br>");
        buff.append("FAQ" + "<br><br>");
        buff.append("Q: Why can't the hash cracker crack [EXAMPLE] hash?" + "<br>");
        buff.append("A: Support for custom wordlists and hash algorithms is coming soon."+ 
                    "<br> A hash can only be cracked if there is a wordlist with the original text in it" + "<br><br>");
        buff.append("Q: Why don't you have [EXAMPLE] implemented?" + "<br>");
        buff.append("A: There's a lot of encryption methods out there." + "<br><br>");
        buff.append("Q: What does this error mean?" + "<br>");
        buff.append("A: Currently using Java's error handling system that devs normally look at, a user-friendly version" +
                    "will be implemented eventually" + "<br><br>");
        buff.append("New features to come soon!" + "<br>");
        buff.append("</html>");
        return buff.toString();
    }
    
    public static String displayInfo(){
        StringBuilder buff = new StringBuilder();
        buff.append("<html>");
        buff.append("<b>Last Updated: 5/3/21 </b>" + "<br>");
        buff.append("<b>Version 1.0 </b> <i>(is it normal to just be making these numbers up???)</i>" + "<br><br>");
        buff.append("This project was developed by Ryan Syed as part of an Object Oriented Programming class." + "<br>");
        buff.append("All source code is original work, with the exception of the HashLibrary.java file, and dict.txt wordlist, " +
                    "and should not be copied without notifying the creator." + "<br>");
        buff.append("<i>I mean, why would you copy this? Go steal from CyberChef or dcode.fr or something</i>" + "<br><br>");
        buff.append("This project is licensed MIT, find out more here: https://opensource.org/licenses/MIT" + "<br>");
        buff.append("</html>");
        return buff.toString();
    }

    // TODO: Implement a CLI version of the app with all of the same functionality of the GUI
    // Tip:  Use a separate class for the CLI version, probably name it jtc.java
    public static String printHelp(){
        return "";
    }

    public static String printInfo(){
        return "";
    }
}
