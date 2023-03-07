package first_example;

public class SimpleExample {

    public static void main(String[] a){
        SimpleExample se = new SimpleExample();
        se.saySomething("Hello");
        se.printObject(se);
        System.out.println("How long is 'Mamma Mia' text:"+se.textLength("Mamma Mia")+" characters");

    }

    private int textLength(String text) {
        return text.length();
    }

    private void printObject(Object o) {
        System.out.println(o.getClass() +" " + o.hashCode());
    }

    private void saySomething(String text) {
        System.out.println(text);
    }
}
