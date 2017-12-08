package temp.temp;

/**
 * Created by aditya.dalal on 26/03/17.
 */
public class SubClass extends Base {

    private String privateString;

    String packagePrivateString = "sub";
    protected String protectedString;
    public String publicString;

    public static void printStatic() {
        System.out.println("static print from sub");
    }

    @Override
    public void print() {
        System.out.println("from sub");
    }

    public static void main(String[] args) {
        Base base = new Base();
        System.out.println(base.packagePrivateString);
        base.print();
        System.out.println();

        SubClass subClass = new SubClass();
        System.out.println(subClass.packagePrivateString);
        subClass.print();
        subClass.submethod();
        System.out.println();

        Base base1 = new SubClass();
        System.out.println(base1.packagePrivateString);
        base1.print();
    }

    public void submethod() {
        System.out.println("sub method");
    }

}
