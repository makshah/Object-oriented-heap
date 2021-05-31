// Odd heap decorator uses the OddFilter because we have already created it in order to reduce writing different codes
// that essentially do the same work.

package main;

import java.util.ArrayList;

public class OddHeapDecorator extends HeapDecorator {

    public OddHeapDecorator(Heap heap) {
        super(heap);
    }

    public String toString(){
        StringBuilder oddValues = new StringBuilder();
        OddFilter oddFilter = new OddFilter(localHeap.internalIterator());
        while(oddFilter.hasNext()){
            oddValues.append(oddFilter.next()).append(" ");
        }
        return oddValues.toString();
    }

    public Integer[] toArray() {

        OddFilter oddFilter = new OddFilter(localHeap.internalIterator());

        ArrayList<Integer> array = new ArrayList<>();

        while (oddFilter.hasNext()) {
            array.add(oddFilter.next());
        }
        Integer[] oddElementsArray = array.toArray(new Integer[array.size()]);
        return oddElementsArray;
    }
}
