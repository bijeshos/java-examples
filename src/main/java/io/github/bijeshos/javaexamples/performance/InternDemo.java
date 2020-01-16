package io.github.bijeshos.javaexamples.performance;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

/**
 * Testing String.intern.
 * <p>
 * Run this class at least with -verbose:gc JVM parameter.
 */
public class InternDemo {
    private static final WeakHashMap<String, WeakReference<String>> MANUAL_CACHE =
            new WeakHashMap<>(100000);

    public static void main(String[] args) {
        testStringPoolGarbageCollection();
        testLongLoop();
    }

    /**
     * Use this method to see where interned strings are stored
     * and how many of them can you fit for the given heap size.
     */
    private static void testLongLoop() {
        test(1000 * 1000 * 1000);
        //uncomment the following line to see the hand-written cache performance
        //testManual( 1000 * 1000 * 1000 );
    }

    /**
     * Use this method to check that not used interned strings are garbage collected.
     */
    private static void testStringPoolGarbageCollection() {
        //first method call - use it as a reference
        test(1000 * 1000);
        //we are going to clean the cache here.
        System.gc();
        //check the memory consumption and how long does it take to intern strings
        //in the second method call.
        test(1000 * 1000);
    }

    private static void test(final int cnt) {
        final List<String> lst = new ArrayList<>(100);
        long start = System.currentTimeMillis();
        for (int i = 0; i < cnt; ++i) {
            final String str = "Very long test string, which tells you about something " +
                    "very-very important, definitely deserving to be interned #" + i;
            //uncomment the following line to test dependency from string length
            //            final String str = Integer.toString( i );
            lst.add(str.intern());
            if (i % 10000 == 0) {
                System.out.println(i + "; time = " + (System.currentTimeMillis() - start) / 1000.0 + " sec");
                start = System.currentTimeMillis();
            }
        }
        System.out.println("Total length = " + lst.size());
    }

    private static String manualIntern(final String str) {
        final WeakReference<String> cached = MANUAL_CACHE.get(str);
        if (cached != null) {
            final String value = cached.get();
            if (value != null) {
                return value;
            }
        }
        MANUAL_CACHE.put(str, new WeakReference<>(str));
        return str;
    }

    private static void testManual(final int cnt) {
        final List<String> lst = new ArrayList<>(100);
        long start = System.currentTimeMillis();
        for (int i = 0; i < cnt; ++i) {
            final String str = "Very long test string, which tells you about something " +
                    "very-very important, definitely deserving to be interned #" + i;
            lst.add(manualIntern(str));
            if (i % 10000 == 0) {
                System.out.println(i + "; manual time = " + (System.currentTimeMillis() - start) / 1000.0 + " sec");
                start = System.currentTimeMillis();
            }
        }
        System.out.println("Total length = " + lst.size());
    }
}