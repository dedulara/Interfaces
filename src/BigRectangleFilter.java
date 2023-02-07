import java.awt.Rectangle;

public class BigRectangleFilter implements Filter
{
    @Override
    public boolean accept(Object x)
    {
        Rectangle rInput = (Rectangle) x;
        double perimeterDouble = (2 * rInput.height) + (2 * rInput.width);
        if(perimeterDouble > 10) {return true;}
        else {return false;}
    }
}
