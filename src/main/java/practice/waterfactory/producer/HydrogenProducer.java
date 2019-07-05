package practice.waterfactory.producer;

import practice.waterfactory.model.Hydrogen;

import java.util.concurrent.BlockingQueue;

public class HydrogenProducer implements Runnable {
    private BlockingQueue<Hydrogen> hydrogens;
    public HydrogenProducer(BlockingQueue<Hydrogen> hydrogens){
        this.hydrogens = hydrogens;
    }

    @Override
    public void run() {
        try {
            hydrogens.put(new Hydrogen());
        } catch(InterruptedException ex){

        }
    }
}
