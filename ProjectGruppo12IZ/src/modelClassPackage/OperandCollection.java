/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelClassPackage;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * This is defined as an extension of the java Stack class adapted for acalculator use
 * container complexNumber.
 *
 * @author Gruppo 12 IZ
 * 
 */
public class OperandCollection{
    private final List<ComplexNumber> l;
    private final List<ComplexNumber> l1;

    public OperandCollection() {
        this.l = new LinkedList();
        this.l1 = new LinkedList();
    }

    public List<ComplexNumber> getL() {
        return l;
    }
    
    /**
    * It inserts (if the param is not null) at the top of the collection a complexNumber object passed as 
    * <p> <!-- -->
    * a parameter within the collection.
    * @param a complex number to enter
    * @see ComplexNumber
    */
    public void insert(ComplexNumber a){
        if(a != null){
            l.add(0, a);
            if(l.size()>12)
                l1.add(0, l.remove(12));                
        }
        else
            System.out.println("I can't insert the complex number.");
    }
    /**
    * It removes and returns (if the collection is not empty) the complexNumber at the top of the collection.
    * <p> <!-- -->
    * @return the complexNumber removed or null
    * @see ComplexNumber
    */
    public ComplexNumber remove(){
        if(!l.isEmpty()){
            ComplexNumber tmp = l.remove(0);
            if(l.size() < 12 && l1.size() > 0)
                l.add(11, l1.remove(0));
            return tmp;
            
        }
        else
            System.out.println("The OperandCollection was just empty.");
        return null;
    }
    /**
    * It returns without remove (if the collection is not empty) the complexNumber at the top of the collection.
    * <p> <!-- -->
    * @return the top complexNumber or null
    * @see ComplexNumber
    */
    public ComplexNumber last(){
        if(!l.isEmpty())
            return l.get(0);
        else{
            System.out.println("There are no element inside the OperandCollection.");
        }
        return null;
    }
    /**
    * It returns the number of elements inside the collection.
    * <p> <!-- -->
    * @return the int length
    */
    public int collectionLength(){
        return l.size();
    }

    public void stamp(){
        //get an iterator for the stack 
        System.out.println("Stack elements:"); 
        //traverse the stack using iterator in a loop and print each element 
        Iterator iterator = l.iterator(); 
        while(iterator.hasNext()){ 
            System.out.println(iterator.next() + " "); 
        } 
    } 
    
    /*@Override
    public Iterator<OperandCollection> iterator() {
        Iterator<OperandCollection> it = new Iterator<OperandCollection>() {

            private int currentIndex = 0;
            @Override
            public boolean hasNext() {
                return currentIndex < collectionLength() && this[currentIndex] != null;
            }

            @Override
            public Type next() {
                return arrayList[currentIndex++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }*/
}
