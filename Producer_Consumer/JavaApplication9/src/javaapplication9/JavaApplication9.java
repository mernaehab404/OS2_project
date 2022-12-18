 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication9;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author nada
 */
public class JavaApplication9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Integer> sharedQueue = new LinkedList<Integer>();
        //Creating shared object

        Scanner myInput = new Scanner( System.in );
        
  System.out.println("Enter the number of Producer: ");
   int a = myInput.nextInt();
   System.out.println("Enter the number of Consumer: ");
   int b = myInput.nextInt();
 for(int producer = 0, consumer= 0;
                producer<a||consumer<b
                ;producer++,consumer++){
            
            if(producer <a)
                
            {chef r = new chef(sharedQueue,(producer+1));
                Thread pr = new Thread (r,(producer+1)+"");
               pr.start();
                }
            if( consumer < b)
            {
             Customer w = new Customer (sharedQueue);
                 Thread co=  new Thread (w,(consumer+1)+"");
                 co.start();
                 
            
            }
          
       
        }  
 }
        // TODO code application logic here
    }
    

