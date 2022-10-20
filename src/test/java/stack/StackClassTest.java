package stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class StackClassTest {

    StackClass st = new StackClass(100);
    @BeforeEach
    void setUp() {
        System.out.println("before each");
    }

    @Test
    @DisplayName("push가 잘 되는지")
    void pushTest() {
        StackClass st = new StackClass(100);
        st.push(10);
        st.push(20);
        Integer[] arr = st.getArray();
        assertEquals(10, arr[0]);
        assertEquals(20, arr[1]);
    }

    @Test
    void pushAndPop() {

        StackClass st = new StackClass();
        st.push(10);
        st.push(20);

        assertEquals(20, st.pop());
        assertEquals(10, st.pop());

        //st.pop() 비어 있을 땐?
        // Exception 의 검증
        assertThrows(EmptyStackException.class, ()->{
            st.pop();
        });
    }

    @Test
    void isEmpty() {
        StackClass st = new StackClass();
        st.push(10);
        assertFalse(st.isEmpty());
        st.pop();
        assertTrue(st.isEmpty());
    }
}