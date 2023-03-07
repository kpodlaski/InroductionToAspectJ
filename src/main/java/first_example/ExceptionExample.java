package first_example;

import java.io.IOException;

public class ExceptionExample {

    public void exceptionCase(int arg) throws IOException
    {
        if (arg>4) return;
        else throw new IOException("Application reading problem");

    }

    public void exceptionCase2() throws SecurityException
    {
        throw new SecurityException("Some security problem");
    }

    public static void main(String[] a) throws Exception {
        ExceptionExample ee = new ExceptionExample();
        try {
            //ee.exceptionCase2(); // No pointcut, different Exception type
            ee.exceptionCase(2);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
