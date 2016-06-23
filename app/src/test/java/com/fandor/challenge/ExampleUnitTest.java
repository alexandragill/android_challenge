package com.fandor.challenge;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {

    @Test
    public void testBasicUse() {
        Carousel c = new Carousel();
        c.addText("Testing basic use");
        assertEquals(c.getText(), "Testing basic use");
        assertEquals(c.getSize(), 1);
    }

    @Test
    public void testLarger() {
        Carousel c = new Carousel();
        c.addText("");
        assertEquals(c.getText(), "");
        c.addText("1");
        assertNotEquals(c.getText(), "1"); //stays at original added
        c.showNext();
        c.addText("2");
        c.addText("3");
        assertEquals(c.getText(), "1"); //show next works even when others added to end
        c.addText("1");
        assertEquals(c.getText(), "1");
        c.addText("4");
        c.addText("5");
        c.addText("");
    }

    @Test
    public void testNext() {
        Carousel c = new Carousel();
        c.addText("1");
        assertEquals(c.showNext(), "1"); //does not rotate beyond single value
        c.addText("2");
        assertEquals(c.showNext(), "2");
        assertEquals(c.getText(), "2");
        assertEquals(c.getSize(), 2);
        c.addText("3");
        c.showNext();
        c.showNext();
        assertEquals(c.getText(), "1");
        c.addText("4");
        assertEquals(c.showNext(), "2");
        assertEquals(c.showNext(), "3");
        assertEquals(c.showNext(), "4");
        c.addText("5");
        assertEquals(c.showNext(), "5"); //test that next recognizes new addition
        assertEquals(c.showNext(), "1");
        c.addText("6");
        assertEquals(c.getSize(), 6);
    }

    @Test
    public void testPrevious() {
        Carousel c = new Carousel();
        c.addText("1");
        assertEquals(c.showPrevious(), "1"); //does not rotate beyond single value
        c.addText("2");
        c.addText("3");
        assertEquals(c.showPrevious(), "3");
        assertEquals(c.getText(), "3");
        assertEquals(c.showPrevious(), "2");
        assertEquals(c.showPrevious(), "1");
        c.addText("4");
        c.addText("5");
        c.addText("6");
        assertEquals(c.showPrevious(), "6");
        assertEquals(c.showPrevious(), "5");
    }

    @Test
    public void testNextAndPrevious() {
        Carousel c = new Carousel();
        c.addText("1");
        c.addText("2");
        c.addText("3");
        c.addText("4");
        assertEquals(c.showNext(), "2");
        assertEquals(c.showNext(), "3");
        assertEquals(c.showNext(), "4");
        c.addText("5");
        assertEquals(c.showNext(), "5");
        assertEquals(c.showNext(), "1");
        c.addText("6");
        assertEquals(c.showPrevious(), "6");
        for(int i=0; i < 5; i++) {
            c.showPrevious();
        }
        assertEquals(c.showPrevious(), "6");
    }

}