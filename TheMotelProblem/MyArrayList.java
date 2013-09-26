
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<T> implements MyArrayListInterface<T>, Iterable<T>
{

    public static final int INITIAL_CAPACITY = 10;
    public static float RESIZE_FACTOR = 2.0f;
    private T[] theItems;
    private int theSize;

    public boolean isEmpty()
    {
        return size() == 0;
    }

    public void clear()
    {
        theSize = 0;
        ensureCapacity(INITIAL_CAPACITY);
    }

    public void ensureCapacity(int newCapacity)
    {
        if (newCapacity < theSize) {
            return;
        }
        T[] old = theItems;
        theItems = (T[]) new Object[newCapacity];
        for( int i = 0; i < size( ); i++ )
            theItems[ i ] = old[ i ];
    }

    public MyArrayList()
    {
        clear();
    }

    private void resize()
    {
        ensureCapacity(theSize + INITIAL_CAPACITY);
    }

    public void add(T element)
    {
        add(size(), element);
    }

    public void add(int index, T element)
    {
        if (theItems.length == size()) {
            ensureCapacity(size() * 2 + 1);
        }

        for (int i = theSize; i > index; i--) {
            theItems[i] = theItems[i - 1];
        }

        theItems[index] = element;
        theSize++;
    }

    public void set(int index, T element)
    {
        if (index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + "; size " + size());
        }
        T old = theItems[index];
        theItems[index] = element;
    }

    public T get(int index)
    {
        if (index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + "; size " + size());
        }
        return theItems[index];
    }

    public void remove(int index)
    {
        if (index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + "; size " + size());
        }
        for (int i = index; i < size() - 1; i++) {
            theItems[i] = theItems[i + 1];
        }
        theSize--;
    }

    public boolean contains(T element)
    {
        for (int i = 0; i < size(); i++) {
            if (theItems[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(T element)
    {
        for (int i = 0; i < size(); i++) {
            if (theItems[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public int size()
    {
        return theSize;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder("[ ");

        for (T x : this) {
            sb.append(x).append(" ");
        }
        sb.append("]");

        return new String(sb);
    }

    public Iterator<T> iterator()
    {
        return new MyArrayListIterator(this);
    }

    private class MyArrayListIterator implements Iterator<T>
    {

        private int current = 0;
        private boolean okToRemove = false;

        public MyArrayListIterator(MyArrayList A)
        {
        }

        public boolean hasNext()
        {
            if (current < size()) {
                return true;
            } else {
                return false;
            }
        }

        public T next()
        {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            okToRemove = true;
            return theItems[current++];
        }

        public void remove()
        {
            if (!okToRemove) {
                throw new IllegalStateException();
            }

            MyArrayList.this.remove(--current);
            okToRemove = false;
        }
    }
}
/// End-of-File

