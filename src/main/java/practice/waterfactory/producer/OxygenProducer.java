package practice.waterfactory.producer;

import practice.waterfactory.model.Oxygen;

import java.util.concurrent.BlockingQueue;

public class OxygenProducer implements Runnable {
    private BlockingQueue<Oxygen> oxygens;
    public OxygenProducer(BlockingQueue<Oxygen> oxygens){
        this.oxygens = oxygens;
    }

    @Override
    public void run() {
        try{
            this.oxygens.put(new Oxygen());
        } catch (InterruptedException ex){

        }
    }
}
