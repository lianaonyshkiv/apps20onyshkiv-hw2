package ua.edu.ucu.collections;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

import static org.junit.Assert.*;

public class QueueTest {
    private static Queue empty;
    private static Queue withoutElements;
    private static Queue oneElement;
    private static Queue standart;

    @BeforeClass
    public static void setUp() {
        empty = new Queue();
        withoutElements = new Queue(new Object[0]);
        oneElement = new Queue(1);
        standart = new Queue(new Object[]{1, 2, 3, 4});
    }

    @Test
    public void testPeek() {
        Object expectedResultEmpty = null;
        Object actualResultEmpty = empty.peek();
        assertEquals(expectedResultEmpty, actualResultEmpty);
        Object expectedResultWithoutElements = null;
        Object actualResultWithoutElements = withoutElements.peek();
        assertEquals(expectedResultWithoutElements, actualResultWithoutElements);
        Object expectedResultOneElement = 1;
        Object actualResultOneElement = oneElement.peek();
        assertEquals(expectedResultOneElement, actualResultOneElement);
        Object expectedResultStandart = 1;
        Object actualResultStandart = standart.peek();
        assertEquals(expectedResultStandart, actualResultStandart);
    }

    @Test
    public void testDequeue() {
        Object expectedResultEmpty = null;
        Object actualResultEmpty = empty.dequeue();
        assertEquals(expectedResultEmpty, actualResultEmpty);
        Object expectedResultWithoutElements = null;
        Object actualResultWithoutElements = withoutElements.dequeue();
        assertEquals(expectedResultWithoutElements, actualResultWithoutElements);
        Object expectedResultOneElement = 1;
        Object actualResultOneElement = oneElement.dequeue();
        assertEquals(expectedResultOneElement, actualResultOneElement);
        Object expectedResultStandart = 1;
        Object actualResultStandart = standart.dequeue();
        assertEquals(expectedResultStandart, actualResultStandart);
    }

    @AfterClass
    public static void testEnqueue() {
        ImmutableLinkedList expectedResultEmpty = new ImmutableLinkedList(1);
        empty.enqueue(1);
        ImmutableLinkedList actualResultEmpty = empty.getElements();
        assertArrayEquals(expectedResultEmpty.toArray(), actualResultEmpty.toArray());
        ImmutableLinkedList expectedResultWithOutElements = new ImmutableLinkedList(1);
        withoutElements.enqueue(1);
        ImmutableLinkedList actualResultWithoutElements = withoutElements.getElements();
        assertArrayEquals(expectedResultWithOutElements.toArray(), actualResultWithoutElements.toArray());
        ImmutableLinkedList expectedResultOneElement = new ImmutableLinkedList(new Object[]{1, 3});
        oneElement.enqueue(3);
        ImmutableLinkedList actualResultOneElement = oneElement.getElements();
        assertArrayEquals(expectedResultOneElement.toArray(), actualResultOneElement.toArray());
        ImmutableLinkedList expectedResultStandart = new ImmutableLinkedList(new Object[]{1, 2, 3, 4, 5});
        standart.enqueue(5);
        ImmutableLinkedList actualResultStandart = standart.getElements();
        assertArrayEquals(expectedResultStandart.toArray(), actualResultStandart.toArray());

    }
}
