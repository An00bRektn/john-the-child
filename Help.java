public class Help {
    
    public static String displayHelp(){
        StringBuilder buff = new StringBuilder();
        buff.append("<html>");
        buff.append("John the Child (c) 2021" + "<br><br>");
        buff.append("To encipher or hash text, type your text into the left panel" + "<br>");
        buff.append("Use the options in the middle to use specific keys or custom alphabets" + "<br>");
        buff.append("Please keep all inputs into the custom alphabet field or key field as long strings" + "<br><br>");
        buff.append("Example:" + "<br>");
        buff.append("   \"ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789\" is good" + "<br>");
        buff.append("   \"A B C D E F 0 1 2 3 4 5 6 7 8 9\" is bad" + "<br>");
        buff.append("   \"A,B,C,D,E,F,0,1,2,3,4,5,6,7,8,9\" is bad" + "<br><br>");
        buff.append("The tabs at the top will switch between the different menus" + "<br>");
        buff.append("New features to come!" + "<br>");
        buff.append("</html>");
        return buff.toString();
    }
    
    public static String displayInfo(){
        StringBuilder buff = new StringBuilder();
        buff.append("<html>");
        buff.append("<b>Last Updated: 5/3/21 </b>" + "<br>");
        buff.append("<b>Version 0.5 </b> <i>(is it normal to just be making these numbers up???)</i>" + "<br><br>");
        buff.append("This project was developed by Ryan Syed as part of an Object Oriented Programming class." + "<br>");
        buff.append("All source code is original work, with the exception of the HashLibrary.java file, " +
                    "and should not be copied without notifying the creator." + "<br>");
        buff.append("<i>I mean, why would you copy this? Go steal from CyberChef or dcode.fr or something</i>" + "<br><br>");
        buff.append("This project is licensed MIT, find out more here: https://opensource.org/licenses/MIT" + "<br>");
        buff.append("</html>");
        return buff.toString();
    }

    public static String printHelp(){
        return "";
    }

    public static String printInfo(){
        return "";
    }
}
