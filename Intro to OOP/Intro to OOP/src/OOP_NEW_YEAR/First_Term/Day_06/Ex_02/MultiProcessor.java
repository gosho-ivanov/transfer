package OOP_NEW_YEAR.First_Term.Day_06.Ex_02;

public class MultiProcessor {
    private int processorsAmount;
    private int[] processorsCoreCount;
    private double multicpuClock;
    private double[] clockPerCPU;


    public MultiProcessor(int cpus, int[] cpuCores, double cpuClockSpeeds){
        this.processorsAmount = cpus;
        this.processorsCoreCount = cpuCores;
        this.multicpuClock = cpuClockSpeeds;
    }


    public int getProcessorsAmount() {
        return processorsAmount;
    }

    public void setProcessorsAmount(int processorsAmount) {
        this.processorsAmount = processorsAmount;
    }

    public int[] getProcessorsCoreCount() {
        return processorsCoreCount;
    }

    public void setProcessorsCoreCount(int[] processorsCoreCount) {
        this.processorsCoreCount = processorsCoreCount;
    }

    public double getMulticpuClockClock() {
        return multicpuClock;
    }

    public void setMulticpuClock(double processorsClockSpeeds) {
        this.multicpuClock = processorsClockSpeeds;
    }

    public double[] clockPerCPU(){
        double[] clockPerCPU = new double[this.processorsAmount];
        for (int i = 0; i < processorsAmount; i++) {
            clockPerCPU[i] = ((0.7 * this.processorsCoreCount[i]) * 0.8 * processorsAmount) * multicpuClock;
        }
        this.clockPerCPU = clockPerCPU;
        return clockPerCPU;
    }

    public double getProccessTime(int coreUsed, int time){
        return time * clockPerCPU[coreUsed-1] / multicpuClock;
    }

}
