package first_example.aspects;

import first_example.SimpleExample;

public aspect SimpleExampleAspect {
    pointcut writing() : execution (* SimpleExample.saySomething(..));

    pointcut sayAnyObject() : execution (* *.saySomething(..));

    pointcut constructorCall() : call (SimpleExample.new(..));

    pointcut lenghtMethod(String arg, SimpleExample trg) : call (int SimpleExample.textLength(java.lang.String)) && args(arg) && target(trg);

    before() : writing(){
        System.out.println("SimpleExample class is saying something");
    }

    before() : sayAnyObject(){
        System.out.println("A class is saying something");
    }

    after() : constructorCall(){
        System.out.println("Object is constructed");
    }

    int around(String arg, Object trg) : lenghtMethod(arg, trg){
        System.out.println("Execute the method now");
        int v = proceed(arg, trg);
        v *= -1;
        return v;

    }
}
