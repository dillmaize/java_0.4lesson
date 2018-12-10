package ru.stqa.ak.tests.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

    @Test
    public void testDistDiagonal (){

        Point x = new Point (0.0, 0.0);
        Point y = new Point(3.0, 4.0);

        Assert.assertEquals(x.distance(y), 5.0);

    }

    @Test

    public void testDistHorizontal () {

        Point x = new Point(2.0, 5.0);
        Point y = new Point(6.0, 5.0);

        Assert.assertEquals(x.distance(y), 4.0);
    }

    @Test

    public void testDistVertical () {

        Point x = new Point(5.0, 6.0);
        Point y = new Point(5.0, 1.0);

        Assert.assertEquals(x.distance(y), 5.0);
    }
}
