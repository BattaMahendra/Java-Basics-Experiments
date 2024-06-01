package oops.abstraction.abstractclasses;

import oops.abstraction.interfaces.IProcessor;

public abstract class IntelProcessor implements IProcessor {

    @Override
    public void process() {
        System.out.println("Intel processor is processing");
    }

    /**
     *
     */
    @Override
    public void setCores(int cores) {
        System.out.println("Cores are "+cores);
    }
}
