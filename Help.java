public class Help {
    
    // TODO: Add helpful help information
    public static String displayHelp(){
        StringBuilder buff = new StringBuilder();
        buff.append("<html>");
        buff.append("John the Child (c) 2021" + "<br><br>");
        buff.append("To encipher or hash text, type your text into the left panel" + "<br>");
        buff.append("Use the options in the middle to use specific keys or custom alphabets" + "<br>");
        buff.append("The tabs at the top will switch between the different menus" + "<br>");
        buff.append("New features to come!" + "<br>");
        buff.append("</html>");
        return buff.toString();
    }
    
    public static String displayInfo(){
        StringBuilder buff = new StringBuilder();
        buff.append("<html>");
        buff.append("<b>Last Updated: 5/3/21 </b>" + "<br>");
        buff.append("<b>Version 0.4 </b> <i>(is it normal to just be making these numbers up???)</i>" + "<br><br>");
        buff.append("This project was developed by Ryan Syed as part of an Object Oriented Programming class." + "<br>");
        buff.append("All source code is original work and should not be copied without notifying the creator." + "<br>");
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
