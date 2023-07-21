package com.example.teslocal;

import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
//            System.out.println(future(scanner.nextLine()));
            System.out.println(make(scanner.nextLine()));
        }
    }

    static String future(String input) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future
                = CompletableFuture.supplyAsync(() -> {
            try {
                return make(input);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        return future.get();
    }

    static String make(String input) throws InterruptedException {
        System.out.println(input + " waiting.....");
        Thread.sleep(10000);
        return input + " test";
    }
}
