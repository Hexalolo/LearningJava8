package genericProgramming;

import java.util.ArrayList;

public class Stack <E> {
    private ArrayList<E> myList;

    public Stack() {
        myList = new ArrayList<>();
    }

    public void push(E newElement){
        if(myList.size() > 0){
            myList.add(0, newElement);
        }
        if(myList.isEmpty()) {
            myList.add(newElement);
        }
    }

    public void pop(){
        if(myList.isEmpty() == false)
            myList.remove(myList.get(myList.size() - 1));
    }

    public void pop(E element){
        if(myList.isEmpty() == false)
            myList.remove(element);
    }

    public boolean isEmpty(){
        if(myList.isEmpty()) return true;
        return false;
    }

    public E getItem(int i) {
        return myList.get(i);
    }

    public int getSize(){
        return myList.size();
    }
}
