/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOUNDBUFFER;

import java.util.List;

/**
 *
 * @author Merna
 */
public class Customer implements Runnable {
    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

 private  List<Integer> sharedQueue;
 public  Customer(List<Integer> sharedQueue) {
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
           Mainframe.jTextArea1.append(Thread.currentThread().getName()+", Queue is empty, customerThread is waiting for "
                           + "chefThread to produce, sharedQueue's size= 0\n");
             sharedQueue.wait();
         }

       Thread.sleep((long)(Math.random() * 2000));
         Mainframe.jTextArea1.append(Thread.currentThread().getName()+", CONSUMED : "+ sharedQueue.remove(0)+"\n");
         sharedQueue.notify();
     }
 }
    
}


