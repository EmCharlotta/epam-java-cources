package com.epam.university.java.core.task037;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class   Task037Impl implements Task037 {
    @Override
    public Collection<String> switcher(Callable<String> ticker, Callable<String> tacker) {
        try {
            ExecutorService executor = Executors.newFixedThreadPool(2);
            List<Future<String>> listFuture = new ArrayList<>();
            Future<String> tickerFuture = executor.submit(ticker);
            Future<String> tackerFuture = executor.submit(tacker);
            for (int i = 0; i < 5; i++) {
                listFuture.add(tickerFuture);
                listFuture.add(tackerFuture);
            }

            ArrayList<String> stringRes = new ArrayList<>();
            for (Future future : listFuture) {
                try {
                    stringRes.add((String) future.get());
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }

            }
            executor.shutdown();

            return stringRes;
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
    }
}
