package practice;

import practice.waterfactory.consumer.H2OProducer;
import practice.waterfactory.model.Hydrogen;
import practice.waterfactory.model.Oxygen;
import practice.waterfactory.service.WaterFactoryService;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class WaterFactory
{
    public static void main( String[] args )
    {
        final BlockingQueue<Hydrogen> hydrogens = new ArrayBlockingQueue<>(500);
        final BlockingQueue<Oxygen> oxygens = new ArrayBlockingQueue<>(500);

        System.out.println("Starting the production of H and O");
        Thread hydrogenProducer = new Thread(() -> {
            while (true) {
                try {
                    hydrogens.put(new Hydrogen());
                } catch (InterruptedException ex) {

                }
            }
        });


        Thread oxygenProducer = new Thread(() -> {
            while (true) {
                try {
                    oxygens.put(new Oxygen());
                } catch (InterruptedException ex) {

                }
            }
        });

        hydrogenProducer.start();
        oxygenProducer.start();

        Runnable h2oProducer = new H2OProducer(hydrogens, oxygens);
        WaterFactoryService consumerService = new WaterFactoryService(h2oProducer);

        System.out.println("Starting the consumption of H and O");
        consumerService.consumeHOandProduceWater();
    }
}
