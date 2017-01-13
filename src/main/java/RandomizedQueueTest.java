import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class RandomizedQueueTest {
    RandomizedQueue<String> rq = null;

    @BeforeMethod
    public void beforeMethod() {
        rq = new RandomizedQueue<>();
    }

    @Test(description = "isEmpty and size of empty deque")
    public void test1() {
        Assert.assertEquals(rq.isEmpty(), true);
        Assert.assertEquals(rq.size(), 0);
    }

    @Test(description = "enqueue")
    public void test2() {
        Assert.assertEquals(rq.isEmpty(), true);
        Assert.assertEquals(rq.size(), 0);
        rq.enqueue("item1");
        Assert.assertEquals(rq.isEmpty(), false);
        Assert.assertEquals(rq.size(), 1);
    }

    @Test(description = "dequeue empty RandomizedQueue", expectedExceptions = NoSuchElementException.class)
    public void test3() {
        rq.dequeue();
    }

    @Test(enabled = false, description = "iterator hasNext and Next")
    public void test4() {
        rq.enqueue("item 1");
        rq.enqueue("item 2");
        Iterator di = rq.iterator();
        Assert.assertEquals(di.hasNext(), true);
        Assert.assertEquals(di.next(), "item 2");
        Assert.assertEquals(di.hasNext(), true);
        Assert.assertEquals(di.next(), "item 1");
        Assert.assertEquals(di.hasNext(), false);
    }
    
    @Test(description = "iterator remove", expectedExceptions = UnsupportedOperationException.class)
    public void test5() {
        Iterator rqi = rq.iterator();
        rqi.remove();        
    }
}
