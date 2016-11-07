package com.dtxmaker.luckydraw;

import org.junit.Test;

import static org.junit.Assert.*;

public class LuckyBoxTest {

    @Test
    public void testEmptyRandomNumber() throws Exception {
        LuckyBox box = new LuckyBox(1, 2);
        box.removeNumber(1);
        box.removeNumber(2);
        assertNull(box.randomNumber());
    }

    @Test
    public void testRandomNumber() throws Exception {
        LuckyBox box = new LuckyBox(1, 2);
        box.removeNumber(1);
        assertNotNull(box.randomNumber());
    }

    @Test
    public void testIsEmpty() throws Exception {
        LuckyBox box = new LuckyBox(1, 2);
        box.removeNumber(1);
        box.removeNumber(2);
        assertTrue(box.isEmpty());
    }

    @Test
    public void testGetSize() throws Exception {
        LuckyBox box = new LuckyBox(1, 2);
        box.removeNumber(2);
        assertEquals(1, box.getSize());
    }
}
