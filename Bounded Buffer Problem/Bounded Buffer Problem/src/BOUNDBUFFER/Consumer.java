/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOUNDBUFFER;

import java.util.List;

/**
 *
 * @author nada
 */
public class Consumer implements Runnable{
 private  List<Integer> sharedQueue;
 public  Consumer(List<Integer> sharedQueue) {
     this.sharedQueue = sharedQueue;
 }
 
    @Override
 public void run() {
     while (true) {
         try {
             consume();
             Thread.sleep(100);
         } catch (InterruptedException e) {  e.printStackTrace(); }
     }
 }

 private void consume() throws InterruptedException {
   
    synchronized(sharedQueue) {
       //if sharedQuey is empty wait until producer produces.
       while (sharedQueue.size() == 0) {
//             System.out.printf(Thread.currentThread().getName()+", Queue is empty, consumerThread is waiting for "
//                           + "producerThread to produce, sharedQueue's size= 0\n");
           Mainframe.jTextArea1.append(Thread.currentThread().getName()+", Queue is empty, customerThread is waiting for "
                           + "chefThread to produce, sharedQueue's size= 0\n");
             sharedQueue.wait();
         }

       Thread.sleep((long)(Math.random() * 2000));
//        System.out.printf(Thread.currentThread().getName()+", CONSUMED : "+ sharedQueue.remove(0)+"\n");
         Mainframe.jTextArea1.append(Thread.currentThread().getName()+", CONSUMED : "+ sharedQueue.remove(0)+"\n");
         sharedQueue.notify();
     }
 }
    
}

