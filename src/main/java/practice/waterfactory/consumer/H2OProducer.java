package practice.waterfactory.consumer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import practice.waterfactory.model.Hydrogen;
import practice.waterfactory.model.Oxygen;

import java.util.concurrent.BlockingQueue;

public class H2OProducer implements Runnable {
    private static final Logger LOGGER = LogManager.getLogger(H2OProducer.class.getName());
    private BlockingQueue<Hydrogen> hydrogens;
    private BlockingQueue<Oxygen> oxygens;
    public H2OProducer(BlockingQueue<Hydrogen> hydrogens, BlockingQueue<Oxygen> oxygens){
        this.hydrogens = hydrogens;
        this.oxygens = oxygens;
    }
    @Override
    public void run(){
        while(true) {
            try {
                Hydrogen hydrogen1 = this.hydrogens.take();
                Hydrogen hydrogen2 = this.hydrogens.take();
                Oxygen oxygen = this.oxygens.take();
                Thread.sleep(5000);
                LOGGER.info("Produced a molecule of water from %s from {}, {} and {}",
                        Thread.currentThread().getName(),
                        hydrogen1.hashCode(),
                        hydrogen2.hashCode(),
                        oxygen.hashCode());
            } catch (InterruptedException ex) {
                System.out.println("Exception thrown while producing water");
            }
        }
    }
}
