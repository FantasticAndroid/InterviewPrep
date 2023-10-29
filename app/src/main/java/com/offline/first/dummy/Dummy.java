package com.offline.first.dummy;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import kotlin.jvm.JvmStatic;

public class Dummy  {

    synchronized void method() {

    }

    void syncDemo(){
        // Static or Class level lock to make static data Thread-Safe
        synchronized(Dummy.class) {
            this.fun();
        }
        // Onject level lock to make non-static data Thread-Safe
        synchronized(this) {
            this.fun();
        }


        //Thread t  = new Thread(new FutureTask<>(new c()));


    }

    class c implements Callable<String>{

        @Override
        public String call() throws Exception {
            return "null";
        }
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }

    void fun(){

    }

    @JvmStatic
    public static double sum(List<? extends Number> list){
        double sum = 0;
        for(Number n : list){
            sum += n.doubleValue();
        }
        return sum;
    }

    public static void addIntegers(List<? super Number> list){
        list.add(50);
    }

    Dummy() {
        int[] array = {1, 2, 34, 5};
        for (int i = 0, j = array.length; i < array.length && j >= 0; i++, j--) {

        }


    }
}
