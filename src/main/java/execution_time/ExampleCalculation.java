package execution_time;

public class ExampleCalculation {
    public  static void main(String[] a){
        StepWiseAlgorithm sqr = new FindSquare();
        System.out.println("Calc sqrt:"+sqr.doCalculation(0.000001, 360000044));
        System.out.println("Real sqrt:" + Math.sqrt(360000044));

        /*
        Algorithm alg = new InfiniteCalculation();
        System.out.println(alg.doCalculation(0.0000001,-4));
        */

    }
}
