package net.irhapsody.pia.temp;

import net.irhapsody.pia.temp.MyObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class MyObjectTest {

    @Spy
    private MyObject objectUnderTest;

    @Before
    public void setUp() {
//        objectUnderTest = new MyObject();
//        objectUnderTest = spy(new MyObject());
    }

    @Test
    public void testIsPropertySet() {
//        assertFalse(objectUnderTest.isPropertySet());

        doReturn( "some runtime property").when(objectUnderTest).getProperty();
        assertFalse( objectUnderTest.isPropertySet() );
    }

    public void testIsPropertySetWhenPropertyChanged(){
        doReturn("foo").when(objectUnderTest).getProperty();
        assertTrue( objectUnderTest.isPropertySet() );
    }
}
