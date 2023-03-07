package first_example.aspects;
import first_example.SimpleExample;

public aspect LoggingAspect {

    pointcut  length(String s) : execution(*  SimpleExample.textLength(..)) && args(s) ;

    int around(String s, SimpleExample se) : length(s) && target(se)
            {
                String logLine = "Calling "+se +" ---";
                logLine+=thisJoinPoint.getSignature();
                logLine+="Argument "+s;
                int i =  proceed(s,se);

                System.out.println("[LOG] "+logLine);
                return i;

            }
}
