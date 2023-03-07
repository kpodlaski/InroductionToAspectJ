package first_example.aspects;

import java.io.IOException;

public aspect ExceptionExampleAspect {

    pointcut ioException(IOException e) : handler(Exception+) && args(e);

    before(IOException e) : ioException(e){
        System.out.println("There is something wrong in Application "
                +thisJoinPoint.getSignature()
                +" "+ e.getMessage());
            }

    before(IOException e): handler(Exception) && args(e) {
        System.out.println("There is REALY something wrong in Application " + e.getMessage());
    }
}
