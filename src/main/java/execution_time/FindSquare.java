package execution_time;

public class FindSquare extends StepWiseAlgorithm {


    @Override
    protected InternalState initAlgorithm(double ... args) {
        return new SQRTInternalState(0.0, args[0], args[0], args[0]/2);
    }

    @Override
    protected void nextStep(double ... args) {
        double err = args[0] - is.actual*is.actual;
        SQRTInternalState sis = (SQRTInternalState) is;
        if (err<0) sis.end = sis.actual;
        else sis.start=sis.actual;
        is.previous = sis.actual;
        is.actual = (sis.end+sis.start)/2;
        // Do something stupid to prolong time of computation
        int x=1;
        for (int y=0; y<10000; y++){x+=x*y;}
    }

    protected class SQRTInternalState extends InternalState{
        private double start, end;
        protected SQRTInternalState(double start, double end, double prev, double actual){
            super(prev,actual);
            this.start=start;
            this.end = end;
        }
    }
}
