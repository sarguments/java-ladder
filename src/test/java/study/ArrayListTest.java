package study;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;

public class ArrayListTest {
    @Test
    public void study() {
        ArrayList<String> list = new ArrayList<>();
        list.add("first");
        list.add("second");

        assertEquals(2, (list.size())); // list의 크기를 구하라.
        assertEquals("first", (list.get(0))); // 첫 번째 값을 찾아라.
        assertEquals(true, (list.contains("first"))); // "first" 값이 포함되어 있는지를 확인해라.
        assertEquals("first", (list.remove(0))); // 첫 번째 값을 삭제해라.
        assertEquals(false, (list.contains("first"))); // "first" 값이 포함되어 있는지를 확인해라.
    }
}