package practice.waterfactory.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class WaterFactoryService {
    public static final Logger LOGGER = LogManager.getLogger(WaterFactoryService.class.getName());
    static ScheduledExecutorService set1 = Executors.newScheduledThreadPool(10, new ThreadFactory() {
        int count = 0;
        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, "Set1-Thread-" + count++);
        }
    });
    static ScheduledExecutorService set2 = Executors.newScheduledThreadPool(10, new ThreadFactory() {
        int count = 0;
        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, "Set2-Thread-" + count++);
        }
    });
    static ScheduledExecutorService set3 = Executors.newScheduledThreadPool(10, new ThreadFactory() {
        int count = 0;
        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r,"Set3-Thread-" + count++);
        }
    });
    static ScheduledExecutorService set4 = Executors.newScheduledThreadPool(10, new ThreadFactory() {
        int count = 0;
        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r,"Set4-Thread-" + count++);
        }
    });
    static ScheduledExecutorService set5 = Executors.newScheduledThreadPool(10, new ThreadFactory() {
        int count = 0;
        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r,"Set5-Thread-" + count++);
        }
    });

    public WaterFactoryService(Runnable consumeHO){
        this.consumeHO = consumeHO;
    }

    private Runnable consumeHO;

    public void consumeHOandProduceWater(){
        LOGGER.info("Starting the production");
        for(int i=0;i<10;i++){
            set1.schedule(consumeHO, 0,  TimeUnit.SECONDS);
            set2.schedule(consumeHO, 1,  TimeUnit.SECONDS);
            set3.schedule(consumeHO, 2,  TimeUnit.SECONDS);
            set4.schedule(consumeHO, 3,  TimeUnit.SECONDS);
            set5.schedule(consumeHO, 4,  TimeUnit.SECONDS);
        }
    }
}
