/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOUNDBUFFER;

import java.util.LinkedList;
import java.util.List;

/**
* Producer Class.
*/
 public class producer implements Runnable {

 private List<Integer> sharedQueue;
 private int maxSize=4; //maximum number of products which sharedQueue can hold at a time.
int producedItem=0; 
 int producerNo;
  int productionSize=5;
 
 public producer(List<Integer> sharedQueue, int producerNo) {
     this.sharedQueue = sharedQueue;
     this.producerNo = producerNo;
 }

 @Override
 public void run() {
     for (int i = 1; i <=productionSize; i++) { //produce products.
         try {
             produce(i);
         } catch (InterruptedException e) {  e.printStackTrace(); }
     }
}

 private void produce(int i) throws InterruptedException {
  
      synchronized(sharedQueue) {
       //if sharedQuey is full wait until consumer consumes.
       while (sharedQueue.size() == maxSize) {
//             System.out.printf(Thread.currentThread().getName()+", Queue is full, producerThread is waiting for "
//                    + "consuomerThread to consume, sharedQueue's size= "+maxSize+"\n");
             Mainframe.jTextArea1.append(Thread.currentThread().getName()+", Queue is full, produceThread is waiting for "
                 + "consumerThread to consume, sharedQueue's size= "+maxSize+"\n");
             sharedQueue.wait();
         }

  
             //Ex= producer0 will produce 1-5  and producer1 will produce 6-10 in random order
       //  int producedItem =(productionSize*producerNo)+ i; 
       int producedItem =producerNo + i;  
//        System.out.printf(Thread.currentThread().getName() +" Produced : " + producedItem+"\n");
      Mainframe.jTextArea1.append(Thread.currentThread().getName() +" Produced : " + producedItem+"\n");
       sharedQueue.add(producedItem);
         Thread.sleep((long)(Math.random() * 1000));
         sharedQueue.notify();
    }
    }
 }
 
   
