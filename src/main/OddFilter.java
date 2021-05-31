package main;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class OddFilter implements Iterator<Integer>{

    private Iterator<Integer> iterator;
    Integer nextValue;

    public OddFilter(Iterator<Integer> iterator){
        this.iterator = iterator;
        this.nextValue = null;
    }

    @Override
    public boolean hasNext(){
        while(nextValue == null && iterator.hasNext()) {
            Integer currentValue = (Integer) iterator.next();
            // Will check if the next value is odd or not before the it reaches to the last element.
            if(currentValue%2 != 0){
                nextValue = currentValue;
                break;
            }
        }
        return nextValue != null;
    }

    @Override
    public Integer next() {
        hasNext();
        if(nextValue == null) throw new NoSuchElementException();
        Integer temporaryValue = nextValue;
        nextValue = null;
        return temporaryValue;
    }
}
