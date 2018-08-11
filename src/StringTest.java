import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

public class StringTest {
	@Test
	public void testSubString() {
		String str = new String("This is a unit test");
		assertEquals("unit", str.substring(10, 14));
	}
	@Test
	public void testEmptyString() {
		String str = new String("");
		assertEquals("", str);
	}
	
	@Test
	public void testNullString() {
		String str = null;
		assertEquals(null, str);
	}
}
