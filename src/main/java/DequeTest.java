import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

public class DequeTest {
	Deque<String> d = null;

	@BeforeTest
	public void beforeTest() {
		d = new Deque<>();
	}

	@Test(enabled = false)
	public void Deque() {
		
	}

	@Test(enabled = false)
	public void addFirst() {
		throw new RuntimeException("Test not implemented");
	}

	@Test(enabled = false)
	public void addLast() {
		throw new RuntimeException("Test not implemented");
	}

	@Test
	public void isEmpty() {
		Assert.assertEquals(d.isEmpty(), true);
	}

	@Test(enabled = false)
	public void iterator() {
		throw new RuntimeException("Test not implemented");
	}

	@Test(enabled = false)
	public void removeFirst() {
		throw new RuntimeException("Test not implemented");
	}

	@Test(enabled = false)
	public void removeLast() {
		throw new RuntimeException("Test not implemented");
	}

	@Test(enabled = false)
	public void size() {
		throw new RuntimeException("Test not implemented");
	}
}
