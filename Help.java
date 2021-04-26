public class Help {
    
    public static String displayHelp(){
        StringBuilder buff = new StringBuilder();
        buff.append("<html>");
        buff.append("This is the help screen!" + "<br>");
        buff.append("</html>");
        return buff.toString();
    }
    
    public static String displayInfo(){
        StringBuilder buff = new StringBuilder();
        buff.append("<html>");
        buff.append("This is the info screen!" + "<br>");
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
