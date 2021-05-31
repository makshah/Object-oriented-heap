package test;
import static org.junit.Assert.*;

import java.util.Iterator;

import main.*;
import main.MinHeap;
import org.junit.Test;

public class HeapTest {
    @Test

    public void testMinHeapaddValue() {
        Heap minHeap = new Heap(new MinHeap());
        assertEquals(minHeap.addValue(20), true);
    }


    @Test
    /*inorder traversal of minheap returns an inordered traversed String*/
    public void testMinHeapToString() {
        Heap minHeap = new Heap(new MinHeap());
        minHeap.addValue(10);
        minHeap.addValue(0);
        minHeap.addValue(20);
        minHeap.addValue(-1);
        minHeap.addValue(9);
        assertEquals(minHeap.toString(), "10 0 -1 20 9 ");
    }

    @Test
    /*inorder traversal of minheap returns inorder Array of elements*/
    public void testMinHeapToArray() {
        Heap minHeap = new Heap(new MinHeap());
        minHeap.addValue(10);
        minHeap.addValue(0);
        minHeap.addValue(20);
        minHeap.addValue(-1);
        minHeap.addValue(9);

        Integer[] expectedMinArray = {10, 0, -1, 20, 9};

        assertArrayEquals(expectedMinArray, minHeap.toArray());
    }

    @Test

    /*inorder heap iterator for minheap*/

    public void testMinHeapIterator() {
        Heap minHeap = new Heap(new MinHeap());
        minHeap.addValue(10);
        minHeap.addValue(0);
        minHeap.addValue(20);
        minHeap.addValue(-1);
        minHeap.addValue(9);

        Iterator<Integer> itr = minHeap.internalIterator();

        assertTrue(itr.hasNext());

        assertEquals(itr.next(), Integer.valueOf(10));

        assertTrue(itr.hasNext());

        assertEquals(itr.next(), Integer.valueOf(0));

        assertTrue(itr.hasNext());

        assertEquals(itr.next(), Integer.valueOf(-1));

        assertTrue(itr.hasNext());

        assertEquals(itr.next(), Integer.valueOf(20));

        assertTrue(itr.hasNext());

        assertEquals(itr.next(), Integer.valueOf(9));

        assertFalse(itr.hasNext());
    }

    @Test
    public void testMaxHeapaddValue() {
        Heap maxHeap = new Heap(new MaxHeap());
        assertEquals(maxHeap.addValue(20), true);
    }

    @Test

    /*inorder traversal of maxheap which returns String*/
    public void testMaxHeapToString() {

        Heap maxHeap = new Heap(new MaxHeap());
        maxHeap.addValue(10);
        maxHeap.addValue(0);
        maxHeap.addValue(20);
        maxHeap.addValue(-1);
        maxHeap.addValue(9);
        assertEquals(maxHeap.toString(), "-1 0 20 9 10 ");

    }

    @Test

    /*inorder traversal of maxheap which returns inorder Array of elements*/

    public void testMaxHeapToArray() {
        Heap maxHeap = new Heap(new MaxHeap());
        maxHeap.addValue(10);
        maxHeap.addValue(0);
        maxHeap.addValue(20);
        maxHeap.addValue(-1);
        maxHeap.addValue(9);
        Integer[] expectedMaxArray = {-1, 0, 20, 9, 10};
        assertArrayEquals(expectedMaxArray, maxHeap.toArray());
    }

    @Test

    /*inorder heap iterator for maxheap*/

    public void testMaxHeapIterator() {

        Heap maxHeap = new Heap(new MaxHeap());
        maxHeap.addValue(10);
        maxHeap.addValue(0);
        maxHeap.addValue(20);
        maxHeap.addValue(-1);
        maxHeap.addValue(9);

        Iterator<Integer> itr = maxHeap.internalIterator();

        assertTrue(itr.hasNext());
        assertEquals(itr.next(), Integer.valueOf(-1));
        assertTrue(itr.hasNext());
        assertEquals(itr.next(), Integer.valueOf(0));
        assertTrue(itr.hasNext());
        assertEquals(itr.next(), Integer.valueOf(20));
        assertTrue(itr.hasNext());
        assertEquals(itr.next(), Integer.valueOf(9));
        assertTrue(itr.hasNext());
        assertEquals(itr.next(), Integer.valueOf(10));
        assertFalse(itr.hasNext());
    }

    @Test

    public void testIngOddFilter() {

        Heap maxHeap = new Heap(new MaxHeap());
        maxHeap.addValue(10);
        maxHeap.addValue(0);
        maxHeap.addValue(20);
        maxHeap.addValue(-1);
        maxHeap.addValue(9);

        OddFilter oddFilter = new OddFilter(maxHeap.internalIterator());

        assertTrue(oddFilter.hasNext());
        assertEquals(oddFilter.next(), Integer.valueOf(-1));
        assertTrue(oddFilter.hasNext());
        assertEquals(oddFilter.next(), Integer.valueOf(9));
    }

    @Test

    public void testOddValuesDecoratorToString() {

        Heap maxHeap = new Heap(new MaxHeap());
        maxHeap.addValue(10);
        maxHeap.addValue(0);
        maxHeap.addValue(20);
        maxHeap.addValue(-1);
        maxHeap.addValue(9);
        OddHeapDecorator oddHeapDecorator = new OddHeapDecorator(maxHeap);

        assertEquals(oddHeapDecorator.toString(), "-1 9 ");
    }

    @Test

    public void testOddValuesDecoratorToArray() {
        Heap maxHeap = new Heap(new MaxHeap());
        maxHeap.addValue(10);
        maxHeap.addValue(0);
        maxHeap.addValue(20);
        maxHeap.addValue(-1);
        maxHeap.addValue(9);
        OddHeapDecorator oddHeapDecorator = new OddHeapDecorator(maxHeap);
        Integer[] expectedMinArray = {-1, 9};

        assertArrayEquals(oddHeapDecorator.toArray(), expectedMinArray);
    }

    @Test

    public void testExternalIterator(){
        Heap maxHeap = new Heap(new MaxHeap());
        maxHeap.addValue(10);
        maxHeap.addValue(0);
        maxHeap.addValue(20);
        maxHeap.addValue(-1);
        maxHeap.addValue(9);
        HeapIterator heapIterator = new HeapIterator(maxHeap.getRoot());
        assertTrue(heapIterator.hasNext());
        assertEquals(heapIterator.next(), Integer.valueOf(-1));
    }
}
