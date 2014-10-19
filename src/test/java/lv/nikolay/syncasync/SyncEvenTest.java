package lv.nikolay.syncasync;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class SyncEvenTest {
    SyncEven se;

    @Before
    public void setUp() throws Exception {
        se = new SyncEven();
    }

    @Test
    public void testNext() throws Exception {
        for (int i = 0; i < 10; i++) {
            TestCase.assertEquals(2+ 2 * i, se.next());
        }
    }
}
