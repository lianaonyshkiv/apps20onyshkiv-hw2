package ua.edu.ucu.collections;

import org.junit.BeforeClass;
import org.junit.Test;
import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

import static org.junit.Assert.*;

public class StackTest {

    private static Stack empty;
    private static Stack withoutElements;
    private static Stack oneElement;
    private static Stack standart;

    @BeforeClass
    public static void setUp() {
        empty = new Stack();
        withoutElements = new Stack(new Object[0]);
        oneElement = new Stack(1);
        standart = new Stack(new Object[]{1, 2, 3, 4});
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
    public void testPop() {
        Object expectedResultEmpty = null;
        Object actualResultEmpty = empty.pop();
        assertEquals(expectedResultEmpty, actualResultEmpty);
        Object expectedResultWithoutElements = null;
        Object actualResultWithoutElements = withoutElements.pop();
        assertEquals(expectedResultWithoutElements, actualResultWithoutElements);
        Object expectedResultOneElement = 1;
        Object actualResultOneElement = oneElement.pop();
        assertEquals(expectedResultOneElement, actualResultOneElement);
        Object expectedResultStandart = 1;
        Object actualResultStandart = standart.pop();
        assertEquals(expectedResultStandart, actualResultStandart);
    }

    @Test
    public void testPush() {
        ImmutableLinkedList expectedResultEmpty = new ImmutableLinkedList(1);
        empty.push(1);
        ImmutableLinkedList actualResultEmpty = empty.getElements();
        assertArrayEquals(expectedResultEmpty.toArray(), actualResultEmpty.toArray());
        ImmutableLinkedList expectedResultWithOutElements = new ImmutableLinkedList(1);
        withoutElements.push(1);
        ImmutableLinkedList actualResultWithoutElements = withoutElements.getElements();
        assertArrayEquals(expectedResultWithOutElements.toArray(), actualResultWithoutElements.toArray());
        ImmutableLinkedList expectedResultOneElement = new ImmutableLinkedList(new Object[]{3, 1});
        oneElement.push(3);
        ImmutableLinkedList actualResultOneElement = oneElement.getElements();
        assertArrayEquals(expectedResultOneElement.toArray(), actualResultOneElement.toArray());
        ImmutableLinkedList expectedResultStandart = new ImmutableLinkedList(new Object[]{5, 1, 2, 3, 4});
        standart.push(5);
        ImmutableLinkedList actualResultStandart = standart.getElements();
        assertArrayEquals(expectedResultStandart.toArray(), actualResultStandart.toArray());

    }

}
