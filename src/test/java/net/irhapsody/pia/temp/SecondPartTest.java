package net.irhapsody.pia.temp;

import net.irhapsody.pia.temp.Something;
import net.irhapsody.pia.temp.Strategy;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith( MockitoJUnitRunner.class)
public class SecondPartTest {

    @Mock
    Strategy strategy;

    Something objectUnderTest;


    @Before
    public void setUp(){
//        MockitoAnnotations.initMocks(this);
        objectUnderTest = new Something( strategy );

    }

    @Test
    public void testSomething() {
        Strategy strategy = mock ( Strategy.class );
        Something objectUnderTest = new Something( strategy );

        objectUnderTest.doSomething();
        verify( strategy ).doSomethingConcrete();
    }
    
    @Test
    public void testDelegateSomething() {
        Strategy strategy = mock( Strategy.class );
        Something objectUnderTest = new Something( strategy );
        when( strategy.doValidate() ).thenReturn( true );

        boolean isValid = objectUnderTest.validate();
        assertTrue( isValid );
    }
}
