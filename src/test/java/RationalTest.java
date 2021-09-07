import org.junit.Assert;
import org.junit.Test;

public class RationalTest {
    @Test
    public void testAdd() {
        Rational x = new Rational();
        x.numerator = 1;
        x.denominator = 2;
        Rational y = new Rational();
        y.numerator = 1;
        y.denominator = 4;
        x.add(y);
        Assert.assertEquals(3, x.numerator);
    }
    @Test
    public void testSubtract() {
        Rational x = new Rational();
        x.numerator = 2;
        x.denominator = 3;
        Rational y = new Rational();
        y.numerator = 2;
        y.denominator = 9;
        x.subtract(y);
        Assert.assertEquals(4, x.numerator);
    }
    @Test
    public void testMultiply() {
        Rational x = new Rational();
        x.numerator = 5;
        x.denominator = 9;
        Rational y = new Rational();
        y.numerator = 9;
        y.denominator = 5;
        x.multiply(y);
        Assert.assertEquals(1, x.numerator);
    }
    @Test
    public void testEquals() {
        Rational x = new Rational();
        x.numerator = 5;
        x.denominator = 10;
        Rational y = new Rational();
        y.numerator = 1;
        y.denominator = 2;
        Assert.assertTrue(x.equals(y));
    }
    @Test
    public void testComparedTo() {
        Rational x = new Rational();
        x.numerator = 1;
        x.denominator = 2;
        Rational y = new Rational();
        y.numerator = 69;
        y.denominator = 70;
        Assert.assertEquals(-1, x.compareTo(y));
    }
    @Test
    public void testToString() {
        Rational x = new Rational();
        x.numerator = 69;
        x.denominator = 420;
        Assert.assertEquals("69/420", x.toString());
    }
    @Test
    public void testConstructor() {
        Assert.assertThrows(Rational.Illegal.class, ()->{
            Rational x = new Rational(0,0);
        });
        Rational y = null;
        try {
            y = new Rational(1,1);
        } catch (Rational.Illegal illegal) {
            illegal.printStackTrace();
        }
        Assert.assertEquals(1, y.numerator);
        Assert.assertEquals(1, y.denominator);
    }
}
