package oops.abstraction.abstractclasses;

import oops.abstraction.interfaces.IProcessor;

public abstract class AMDProcessor implements IProcessor {

    @Override
    public void process() {
        System.out.println("AMD processor is running");
    }

    @Override
    public void setCores(int cores) {
        System.out.println("Cores are "+cores);
    }
}
