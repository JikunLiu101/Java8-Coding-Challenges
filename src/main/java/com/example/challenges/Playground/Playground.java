package com.example.challenges.Playground;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;
import javafx.scene.Node;

import java.util.*;

public class Playground {
    public void backtrace(){
        /**
         * if (end condition) {
         *     save the result
         *     return;
         * }
         *
         * for (every element in this layer){
         *     handle the element
         *     backtrace()
         *     revert the handling for the element
         * }
         */
        int[] paths = new int[0];
        Queue<Integer> q = new LinkedList<>();
        q.remove();

    }

    public static void main(String[] args){
        MyThread myThread = new MyThread();
        myThread.start();
    }
}


class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println("Hello " + "world");
    }
}

class PrintString{
    private final String text = "Hello world";
    private int index = 0;
    private final Object lock = new Object();

    public static void main(String[] args){
        PrintString ps = new PrintString();
        Thread t1 = new Thread(()-> ps.printChars("T1"));
        Thread t2 = new Thread(()-> ps.printChars("T2"));

        t1.start();
        t2.start();
    }

    public void printChars(String name){
        while (true){
            synchronized (lock){
                if (index >= text.length()){
                    lock.notifyAll(); // wake up others before exiting
                    break;
                }
                char c = text.charAt(index++);
                System.out.print(name+" prints: "+c +"\n");
                // wake up another thread to continue
                lock.notifyAll();

                try {
                    if (index < text.length()){
                        lock.wait();
                    }
                } catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
