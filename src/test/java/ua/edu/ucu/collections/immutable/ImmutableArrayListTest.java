package ua.edu.ucu.collections.immutable;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableArrayListTest {

    private static ImmutableArrayList withoutStartElements;
    private static ImmutableArrayList empty;
    private static ImmutableArrayList oneElement;
    private static ImmutableArrayList standart;

    @BeforeClass
    public static void setUp() {
        withoutStartElements = new ImmutableArrayList();
        empty = new ImmutableArrayList(new Object[0]);
        oneElement = new ImmutableArrayList(3);
        standart = new ImmutableArrayList(new Object[]{3, 2, 1, 6, 4});
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
        ImmutableArrayList actualResultWithoutEle = withoutStartElements.add(3);
        assertArrayEquals(expectedResultWithoutEle, actualResultWithoutEle.toArray());
        Object[] expectedResultEmpty = new Object[]{3};
        ImmutableArrayList actualResultEmpty = empty.add(3);
        assertArrayEquals(expectedResultEmpty, actualResultEmpty.toArray());
        Object[] expectedResultOneElement = new Object[]{3, 5};
        ImmutableArrayList actualResultOneElement = oneElement.add(5);
        assertArrayEquals(expectedResultOneElement, actualResultOneElement.toArray());
        Object[] expectedResultStandart = new Object[]{3, 2, 1, 6, 4, 5};
        ImmutableArrayList actualResultStandart = standart.add(5);
        assertArrayEquals(expectedResultStandart, actualResultStandart.toArray());
        Object[] expectedResultNoItemToAdd = new Object[]{3, 2, 1, 6, 4};
        ImmutableArrayList actualResultNoItemToAdd = standart.add(new Object[0]);
        assertArrayEquals(expectedResultNoItemToAdd, actualResultNoItemToAdd.toArray());
    }

    @Test
    public void testRemoving() {
        Object[] expectedResultStandart = new Object[]{3, 2, 6, 4};
        ImmutableArrayList actualResultStandart = standart.remove(2);
        assertArrayEquals(expectedResultStandart, actualResultStandart.toArray());
        Object[] expectedResultClearStandart = new Object[]{};
        ImmutableArrayList actualResultClearStandart = standart.clear();
        assertArrayEquals(expectedResultClearStandart, actualResultClearStandart.toArray());
        assertTrue(standart.clear().isEmpty());
        assertFalse(standart.isEmpty());
    }

    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void testRemovingError() {
        Object[] expectedResultOneElement = new Object[]{};
        ImmutableArrayList actualResultOneElement = oneElement.remove(0);
        assertArrayEquals(expectedResultOneElement, actualResultOneElement.toArray());
        Object[] expectedResultEmpty = new Object[0];
        ImmutableArrayList actualResultEmpty = empty.remove(0);
        assertArrayEquals(expectedResultEmpty, actualResultEmpty.toArray());
        Object[] expectedResultWithoutEle = new Object[0];
        ImmutableArrayList actualResultWithoutEle = withoutStartElements.remove(3);
        assertArrayEquals(expectedResultWithoutEle, actualResultWithoutEle.toArray());
    }

    @Test
    public void testSetting() {
        Object[] expectedResultOneElement = new Object[]{2};
        ImmutableArrayList actualResultOneElement = oneElement.set(0, 2);
        assertArrayEquals(expectedResultOneElement, actualResultOneElement.toArray());
        Object[] expectedResultStandart = new Object[]{3, 2, 7, 6, 4};
        ImmutableArrayList actualResultStandart = standart.set(2, 7);
        assertArrayEquals(expectedResultStandart, actualResultStandart.toArray());

    }

    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void testingSettingError() {
        Object[] expectedResultWithoutEle = new Object[0];
        ImmutableArrayList actualResultWithoutEle = withoutStartElements.set(0, 3);
        assertArrayEquals(expectedResultWithoutEle, actualResultWithoutEle.toArray());
        Object[] expectedResultEmpty = new Object[0];
        ImmutableArrayList actualResultEmpty = empty.set(0, 3);
        assertArrayEquals(expectedResultEmpty, actualResultEmpty.toArray());
        Object[] expectedResultStandart = new Object[]{3, 2, 7, 6, 4};
        ImmutableArrayList actualResultStandart = standart.set(9, 7);
        assertArrayEquals(expectedResultStandart, actualResultStandart.toArray());
    }


}
