package io.github.bijeshos.javaexamples.gc;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

/*
 * This class prints details of GC
 */
public class GCDemoTwo {
    public static void main(String[] args) {
        GCDemoTwo demo = new GCDemoTwo();
        demo.startDemo();
    }


    public void startDemo() {
        gcOperations();
    }

    private static void gcOperations() {
        List<GarbageCollectorMXBean> list = ManagementFactory.getGarbageCollectorMXBeans();
        for (GarbageCollectorMXBean bean : list) {
            System.out.println("Name: " + bean.getName());
            System.out.println("Number of collections: " + bean.getCollectionCount());
            System.out.println("Collection time:" + bean.getCollectionTime() + " ms");
            System.out.println("Pool names:");
            for (String name : bean.getMemoryPoolNames()) {
                System.out.println("\t" + name);
            }
            System.out.println();
        }
    }
}
