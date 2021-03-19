import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.util.Assert;

@RunWith(JUnit4.class)
public class Tests {

    @Test
    public void test1(){
        boolean now = true;
        Assert.isTrue(now, "it is false");
    }
}
