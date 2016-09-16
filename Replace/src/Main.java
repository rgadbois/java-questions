public class Main {

    public String replace(String str, char oldValue, char newValue) {

        if (str == null) {
            return null;
        }

        char[] strChars = str.toCharArray();
        for (int i=0; i< str.length(); i++) {
            if (strChars[i] == oldValue ) {
                strChars[i] = newValue;
            }
        }
        return new String(strChars);
    }

    public static void main(String[] args) {
        Main main = new Main();
        String test = "This is a test";
        System.out.println(test);
        test = main.replace(test, 's', '3');
        System.out.println(test);
    }
}
