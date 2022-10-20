package stack;

import java.util.EmptyStackException;

public class StackClass {

    private Integer[] arr;
    private int top = 0;

    public StackClass() {
        this.arr = new Integer[10000];
    }

    public StackClass(int size) {
        this.arr = new Integer[size];
    }

    public void push(int value) {
        this.arr[top++] = value;
        }

    public Integer[] getArray() {
        return arr;
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return this.arr[--this.top];
    }

    public boolean isEmpty() {
        return this.top == 0;
    }
}
