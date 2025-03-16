package Day_basic_String;

public class Program1 {
    public static void main(String[] args) {
        String str = "Here come the garden";
        // output -> HereComeTheGarden
        StringBuilder sb = new StringBuilder(str);
        int n = sb.length();
        for(int i=0;i<n;i++){
            int ch = str.charAt(i);
            sb.append(ch);
//            if(sb.charAt(""))
        }
    }
}
