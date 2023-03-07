package execution_time.aspect;
import execution_time.StepWiseAlgorithm;

public aspect ComputingWatcher {

    int steps = 0;

    pointcut computation(double prec, double ... data)
            : execution(* StepWiseAlgorithm.doCalculation(..) ) && args( prec, data);


    double around(double prec, double[] data) : computation(prec, data){
        steps = 0;
        TimeCounting timeCount = new TimeCounting(100.0);
        timeCount.startControl();
        long start = System.currentTimeMillis();
        double result = proceed(prec, data);
        long end = System.currentTimeMillis();
        long time = end - start;
        timeCount.stopControl();
        System.out.println("Computingting took " + time + " ms "
                + thisJoinPoint.getSignature()
                + " Args: "+data[0] + ", "+prec);
        return result;
    }


    public class TimeCounting implements Runnable
    {
        volatile boolean doCounting = true;
        double timeLimit = 1;

        public TimeCounting(double timeLimit){
            this.timeLimit = timeLimit;
        }
        @Override
        public void run() {
            long start = System.currentTimeMillis();
            while (doCounting)
            {
                long end = System.currentTimeMillis();
                long time = end - start;
                if (time > timeLimit) {
                    System.out.println("Computations took too long time");
                    System.out.println("Breaking after "+steps+" steps");
                    System.exit(1);
                }
            }
        }

        public void startControl(){
            Thread t = new Thread(this);
            t.start();
        }

        public void stopControl(){
            doCounting = false;
        }
    }

}
