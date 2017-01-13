import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class DequeTest {
    Deque<String> d = null;

    @BeforeMethod
    public void beforeMethod() {
        d = new Deque<>();
    }

    @Test(description = "isEmpty and size of empty deque")
    public void test1() {
        Assert.assertEquals(d.isEmpty(), true);
        Assert.assertEquals(d.size(), 0);
    }

    @Test(description = "addFirst")
    public void test2() {
        Assert.assertEquals(d.isEmpty(), true);
        Assert.assertEquals(d.size(), 0);
        d.addFirst("item1");
        Assert.assertEquals(d.isEmpty(), false);
        Assert.assertEquals(d.size(), 1);
    }

    @Test(description = "addLast")
    public void test3() {
        Assert.assertEquals(d.isEmpty(), true);
        Assert.assertEquals(d.size(), 0);
        d.addLast("item1");
        Assert.assertEquals(d.isEmpty(), false);
        Assert.assertEquals(d.size(), 1);
    }

    @Test(description = "removeFirst empty deque", expectedExceptions = NoSuchElementException.class)
    public void test4() {
        d.removeFirst();
    }

    @Test(description = "removeLast empty deque", expectedExceptions = NoSuchElementException.class)
    public void test5() {
        d.removeLast();
    }

    @Test(description = "removeFirst empty deque 2", expectedExceptions = NoSuchElementException.class)
    public void test6() {
        d.addFirst("item 1");
        Assert.assertEquals(d.isEmpty(), false);
        d.removeFirst();
        Assert.assertEquals(d.isEmpty(), true);
        d.removeFirst();
    }

    @Test(description = "removeLast empty deque 2", expectedExceptions = NoSuchElementException.class)
    public void test7() {
        d.addLast("item 1");
        Assert.assertEquals(d.isEmpty(), false);
        d.removeLast();
        Assert.assertEquals(d.isEmpty(), true);
        d.removeLast();
    }

    @Test(description = "removeFirst and Last empty deque 2", expectedExceptions = NoSuchElementException.class)
    public void test8() {
        d.addFirst("item 1");
        d.addLast("item 2");
        Assert.assertEquals(d.isEmpty(), false);
        Assert.assertEquals(d.size(), 2);
        d.removeLast();
        Assert.assertEquals(d.size(), 1);
        Assert.assertEquals(d.isEmpty(), false);
        d.removeLast();
        Assert.assertEquals(d.size(), 0);
        Assert.assertEquals(d.isEmpty(), true);
        d.removeLast();
    }

    @Test(description = "iterator hasNext and Next")
    public void test9() {
        d.addFirst("item 1");
        d.addFirst("item 2");
        Iterator di = d.iterator();
        Assert.assertEquals(di.hasNext(), true);
        Assert.assertEquals(di.next(), "item 2");
        Assert.assertEquals(di.hasNext(), true);
        Assert.assertEquals(di.next(), "item 1");
        Assert.assertEquals(di.hasNext(), false);
    }
    
    @Test(description = "iterator remove", expectedExceptions = UnsupportedOperationException.class)
    public void test10() {
        Iterator di = d.iterator();
        di.remove();        
    }
}
