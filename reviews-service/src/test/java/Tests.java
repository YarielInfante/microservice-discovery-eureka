import org.springframework.util.Assert;

public class Tests {

    public void test1(){
        boolean test = true;
        Assert.isTrue(test, "it is false");
    }
}
