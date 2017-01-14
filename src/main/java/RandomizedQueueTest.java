import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class RandomizedQueueTest {
    RandomizedQueue<String> rq = null;
    int capacity = 6;

    @BeforeMethod
    public void beforeMethod() {
        rq = new RandomizedQueue<>(capacity);
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

    @Test(description = "iterator hasNext and Next")
    public void test4() {
        int count = capacity + 1;
        for (int i = 0; i < count; i++) {
            rq.enqueue("item " + i);
        }
        Iterator<String> di = rq.iterator();

        for (int i = 0; i < count; i++) {
            Assert.assertEquals(di.hasNext(), true);
            di.next();
        }
        Assert.assertEquals(di.hasNext(), false);
    }

    @Test(description = "iterator remove", expectedExceptions = UnsupportedOperationException.class)
    public void test5() {
        Iterator<String> rqi = rq.iterator();
        rqi.remove();
    }

    @Test(description = "dequeue")
    public void test6() {
        rq.enqueue("item1");
        Assert.assertEquals(rq.isEmpty(), false);
        rq.dequeue();
        Assert.assertEquals(rq.isEmpty(), true);
        for (int i = 0; i < 8; i++) {
            rq.enqueue("item " + i);
        }
        for (int i = 0; i < 8; i++) {
            rq.dequeue();
        }
        Assert.assertEquals(rq.isEmpty(), true);
    }

    @Test(description = "unique iterators")
    public void test7() {
        for (int i = 0; i < 20; i++) {
            rq.enqueue("item " + i);
        }
        Iterator<String> di1 = rq.iterator();
        Iterator<String> di2 = rq.iterator();
        Assert.assertNotEquals(di1.next(), di2.next());
    }
}
