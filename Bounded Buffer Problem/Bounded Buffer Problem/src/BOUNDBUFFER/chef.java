/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOUNDBUFFER;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Merna
 */
public class chef  implements Runnable{
    private List<Integer> sharedQueue;
 private int maxSize=4; //maximum number of products which sharedQueue can hold at a time.
// int productionSize=4;//Total no of items to be produced by each producer
int producedItem=0; 
 int producerNo;

 
 public chef(List<Integer> sharedQueue, int producerNo) {
     this.sharedQueue = sharedQueue;
     this.producerNo = producerNo;
 }

 @Override
 public void run() {
     for (int i = 1; i <= maxSize; i++) { //produce products.
         try {
             produce(i);
         } catch (InterruptedException e) {  e.printStackTrace(); }
     }
}

 private void produce(int i) throws InterruptedException {
  
      synchronized(sharedQueue) {
       //if sharedQuey is full wait until consumer consumes.
       while (sharedQueue.size() == maxSize) {
             Mainframe.jTextArea1.append(Thread.currentThread().getName()+", Queue is full, chefThread is waiting for "
                    + "customerThread to consume, sharedQueue's size= "+maxSize+"\n");
             sharedQueue.wait();
         }

       //Bcz each producer must produce unique product
             //Ex= producer0 will produce 1-5  and producer1 will produce 6-10 in random order
            
       int producedItem =+ i;  
       
       Mainframe.jTextArea1.append(Thread.currentThread().getName() +" Produced : " + producedItem+"\n");
       sharedQueue.add(producedItem);
         Thread.sleep((long)(Math.random() * 1000));
         sharedQueue.notify();
    }
    }
}
