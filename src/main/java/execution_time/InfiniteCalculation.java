package execution_time;

public class InfiniteCalculation extends StepWiseAlgorithm {

    @Override
    protected InternalState initAlgorithm(double... args) {
        return new InternalState(0.0, 1.0);
    }

    @Override
    protected void nextStep(double... args) {
        //Do nothing at all
    }
}
