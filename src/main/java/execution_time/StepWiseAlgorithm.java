package execution_time;

import org.aspectj.weaver.internal.tools.MatchingContextBasedTest;

public abstract class StepWiseAlgorithm {

    protected InternalState is;
    public double doCalculation(double precision, double ... args){
        if (args.length<1) return 0;
        is = initAlgorithm(args);
        do{
            nextStep(args);
        }while(Math.abs((is.previous - is.actual)/is.actual)>precision);
        return is.actual;
    }

    protected abstract InternalState initAlgorithm(double ... args);

    protected abstract void nextStep(double ... args);

    class InternalState{
        double previous = -1.0;
        double actual = 1.0;
        InternalState (double p, double a){
            previous = p;
            actual = a;
        }

    }
}
