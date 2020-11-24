package ua.edu.ucu.collections.immutable;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    private static ImmutableLinkedList withoutStartElements;
    private static ImmutableLinkedList empty;
    private static ImmutableLinkedList oneElement;
    private static ImmutableLinkedList standart;

    @BeforeClass
    public static void setUp() {
        withoutStartElements = new ImmutableLinkedList();
        empty = new ImmutableLinkedList(new Object[0]);
        oneElement = new ImmutableLinkedList(3);
        standart = new ImmutableLinkedList(new Object[]{3, 2, 1, 6, 4});
    }

    @Test
    public void testToArray() {
        Object[] expectedResult = new Object[]{3, 2, 1, 6, 4};
        Object[] actualResult = standart.toArray();
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testAdding() {
        Object[] expectedResultWithoutEle = new Object[]{3};
        ImmutableLinkedList actualResultWithoutEle = withoutStartElements.add(3);
        assertArrayEquals(expectedResultWithoutEle, actualResultWithoutEle.toArray());
        Object[] expectedResultEmpty = new Object[]{3};
        ImmutableLinkedList actualResultEmpty = empty.add(3);
        assertArrayEquals(expectedResultEmpty, actualResultEmpty.toArray());
        Object[] expectedResultOneElement = new Object[]{3, 5};
        ImmutableLinkedList actualResultOneElement = oneElement.add(5);
        assertArrayEquals(expectedResultOneElement, actualResultOneElement.toArray());
        Object[] expectedResultStandart = new Object[]{3, 2, 1, 6, 4, 5};
        ImmutableLinkedList actualResultStandart = standart.add(5);
        assertArrayEquals(expectedResultStandart, actualResultStandart.toArray());
        Object[] expectedResultNoItemToAdd = new Object[]{3, 2, 1, 6, 4};
        ImmutableLinkedList actualResultNoItemToAdd = standart.add(new Object[0]);
        assertArrayEquals(expectedResultNoItemToAdd, actualResultNoItemToAdd.toArray());
        Object[] expectedResultAddLast = new Object[]{3, 2, 1, 6, 4, 7};
        ImmutableLinkedList actualResultAddLast = standart.addLast(7);
        assertArrayEquals(expectedResultAddLast, actualResultAddLast.toArray());
        Object[] expectedResultWithoutEleAll = new Object[]{3};
        ImmutableLinkedList actualResultWithoutEleAll = withoutStartElements.addAll(new Object[]{3});
        assertArrayEquals(expectedResultWithoutEleAll, actualResultWithoutEleAll.toArray());
        Object[] expectedResultEmptyAll = new Object[]{3};
        ImmutableLinkedList actualResultEmptyAll = empty.addAll(0, new Object[]{3});
        assertArrayEquals(expectedResultEmptyAll, actualResultEmptyAll.toArray());
        Object[] expectedResultOneElementAll = new Object[]{3, 5};
        ImmutableLinkedList actualResultOneElementAll = oneElement.addAll(new Object[]{5});
        assertArrayEquals(expectedResultOneElementAll, actualResultOneElementAll.toArray());
        Object[] expectedResultStandartAll = new Object[]{3, 2, 1, 6, 4, 5, 6};
        ImmutableLinkedList actualResultStandartAll = standart.addAll(5, new Object[]{5, 6});
        assertArrayEquals(expectedResultStandartAll, actualResultStandartAll.toArray());
    }

    @Test
    public void testRemovingErrorEl() throws ArrayIndexOutOfBoundsException {
        Object[] expectedResultWithoutEle = new Object[0];
        ImmutableLinkedList actualResultWithoutEle = withoutStartElements.remove(3);
        assertArrayEquals(expectedResultWithoutEle, actualResultWithoutEle.toArray());
        Object[] expectedResultEmpty = new Object[0];
        ImmutableLinkedList actualResultEmpty = empty.remove(0);
        assertArrayEquals(expectedResultEmpty, actualResultEmpty.toArray());
        Object[] expectedResultOneElement = new Object[]{};
        ImmutableLinkedList actualResultOneElement = oneElement.remove(0);
        assertArrayEquals(expectedResultOneElement, actualResultOneElement.toArray());
    }

    @Test
    public void testRemoving() {
        Object[] expectedResultStandart = new Object[]{3, 2, 6, 4};
        ImmutableLinkedList actualResultStandart = standart.remove(2);
        assertArrayEquals(expectedResultStandart, actualResultStandart.toArray());
        Object[] expectedResultClearStandart = new Object[]{};
        ImmutableLinkedList actualResultClearStandart = standart.clear();
        assertArrayEquals(expectedResultClearStandart, actualResultClearStandart.toArray());
        Object[] expectedResultRemoveLast = new Object[]{3, 2, 1, 6};
        ImmutableLinkedList actualResultRemoveLast = standart.removeLast();
        assertArrayEquals(expectedResultRemoveLast, actualResultRemoveLast.toArray());
        assertTrue(standart.clear().isEmpty());
        assertFalse(standart.isEmpty());
    }

    @Test
    public void testSetting() {
        Object[] expectedResultOneElement = new Object[]{2};
        ImmutableLinkedList actualResultOneElement = oneElement.set(0, 2);
        assertArrayEquals(expectedResultOneElement, actualResultOneElement.toArray());
        Object[] expectedResultStandart = new Object[]{3, 2, 7, 6, 4};
        ImmutableLinkedList actualResultStandart = standart.set(2, 7);
        assertArrayEquals(expectedResultStandart, actualResultStandart.toArray());

    }

    @Test
    public void testGetting() {
        assertEquals(standart.getFirst(), 3);
        assertEquals(standart.getLast(), 4);
        assertEquals(standart.getLength(), 5);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testingSettingError() {
        Object[] expectedResultWithoutEle = new Object[0];
        ImmutableLinkedList actualResultWithoutEle = withoutStartElements.set(0, 3);
        assertArrayEquals(expectedResultWithoutEle, actualResultWithoutEle.toArray());
        Object[] expectedResultEmpty = new Object[0];
        ImmutableLinkedList actualResultEmpty = empty.set(0, 3);
        assertArrayEquals(expectedResultEmpty, actualResultEmpty.toArray());
        Object[] expectedResultStandart = new Object[]{3, 2, 7, 6, 4};
        ImmutableLinkedList actualResultStandart = standart.set(9, 7);
        assertArrayEquals(expectedResultStandart, actualResultStandart.toArray());

    }

    @Test
    public void testingIndexOf() {
        int expectedResultStandart = 1;
        System.out.println(Arrays.toString(standart.toArray()));
        int actualResultStandart = standart.indexOf(2);
        assertEquals(expectedResultStandart, actualResultStandart);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testingIndexOfError() {
        int expectedResultWithoutEle = 0;
        int actualResultWithoutEle = withoutStartElements.indexOf(3);
        assertEquals(expectedResultWithoutEle, actualResultWithoutEle);
        int expectedResultEmpty = 0;
        int actualResultEmpty = empty.indexOf(3);
        assertEquals(expectedResultEmpty, actualResultEmpty);
    }

}
