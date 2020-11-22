package ua.edu.ucu.collections.immutable;

public class ImmutableArrayList implements ImmutableList {
    private final Object[] elements;
    private final int length;

    public ImmutableArrayList() {
        elements = new Object[0];
        length = 0;
    }

    public ImmutableArrayList(Object e) {
        elements = new Object[]{e};
        length = 1;
    }

    public ImmutableArrayList(Object[] array) {
        elements = array.clone();
        length = array.length;
    }

    @Override
    public ImmutableArrayList add(Object e) {
        return add(elements.length, e);
    }

    @Override
    public ImmutableArrayList add(int index, Object e) {
        boolean x = e.getClass().isArray();
        if (x) {
            return addAll(index, (Object[]) e);
        }
        return addAll(index, new Object[]{e});
    }

    @Override
    public ImmutableArrayList addAll(Object[] c) {
        return addAll(elements.length, c);
    }

    @Override
    public ImmutableArrayList addAll(int index, Object[] c) {
        if (length == 0) {
            return new ImmutableArrayList(c);
        }
        Object[] result = new Object[length + c.length];
        System.arraycopy(elements, 0, result, 0, length);
        System.arraycopy(c, 0, result, length, c.length);
        return new ImmutableArrayList(result);
    }

    @Override
    public Object get(int index) {
        return elements[index];
    }

    @Override
    public ImmutableArrayList remove(int index) {
        if (index > length - 1) {
            throw new ArrayIndexOutOfBoundsException("False index");
        }
        if (length == 0) {
            throw new NegativeArraySizeException("Is empty");
        }
        Object[] result = new Object[length - 1];
        System.arraycopy(elements, 0, result, 0, index);
        System.arraycopy(elements, index + 1, result, index,
                length - index - 1);

        return new ImmutableArrayList(result);
    }

    @Override
    public ImmutableArrayList set(int index, Object e) {
        Object[] result = elements.clone();
        result[index] = e;
        return new ImmutableArrayList(result);
    }

    @Override
    public int indexOf(Object e) {
        int counter = 0;
        for (Object el : elements) {
            if (el == e) {
                return counter;
            }
            counter += 1;
        }
        return -1;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public ImmutableArrayList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public Object[] toArray() {
        return elements.clone();
    }
}
