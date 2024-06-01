package oops.abstraction.abstractclasses;

import oops.abstraction.interfaces.IGraphicCard;
import oops.abstraction.interfaces.IProcessor;

public   class Computer extends  IntelProcessor implements IGraphicCard , IProcessor {



    @Override
    public void provideGraphics() {
        System.out.println("Graphic card provides graphics");
    }

    public static void main(String[] args) {
        IGraphicCard computer1 = new Computer();
        computer1.process();
    }
}
