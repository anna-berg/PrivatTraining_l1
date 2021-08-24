package JUnitTests;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Vector2DTest {
    @Test
    public void newVectorShouldHaveZeroLength(){
        Vector2D v1 = new Vector2D(); //action
        //assertion

        Assert.assertEquals(0, v1.lenght(), 1e-9); //1e-9 = 0.0000000001
    }
}