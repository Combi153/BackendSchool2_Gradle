package stack;

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
        this.arr[top] = value;
        this.top++;

    }

    public Integer[] getArray() {
        return arr;
    }

    public int pop() {
        int value = this.arr[this.top - 1];
        this.top--;
        return value;
    }
}
