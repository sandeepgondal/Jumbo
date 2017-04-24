/**
 * Created by gondals on 25/07/16.
 */
public class MainClass {

    protected MainClass() {
    }

    public static void main(String[] args) {
        System.out.println("Hello World");

        String s1 = "Sandeep";
        String s2 = "Sandeep";
        String s3 = new String("Sandeep");

        System.out.println(s1 == s2);
        System.out.println(s1 == s3.intern());
    }


}
