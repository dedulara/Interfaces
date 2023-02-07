import java.awt.*;
import java.util.ArrayList;

public class BigRectangleLister
{
    public static void main(String[] args)
    {
        BigRectangleFilter rFilter = new BigRectangleFilter();
        ArrayList<Object> rectangleAL = new ArrayList<>();

        rectangleAL.add(new Rectangle(1,2));
        rectangleAL.add(new Rectangle(2,4));
        rectangleAL.add(new Rectangle(2,2));
        rectangleAL.add(new Rectangle(3,1));
        rectangleAL.add(new Rectangle(3,2));
        rectangleAL.add(new Rectangle(15,5));
        rectangleAL.add(new Rectangle(9,8));
        rectangleAL.add(new Rectangle(9,20));
        rectangleAL.add(new Rectangle(8,81));
        rectangleAL.add(new Rectangle(10,20));

        ArrayList<Object> collectArray = new ArrayList<Object>();

        for(Object x : rectangleAL)
        {
            if (rFilter.accept(x))
            {
                CollectAll.collectStuff(collectArray, x);
            }
        }
        for(Object y : collectArray)
        {
            Rectangle rInput = (Rectangle) y;
            double rP = (2 * rInput.height) + (2 * rInput.width);
            System.out.println("Width=" + rInput.width + ", height=" + rInput.height + "; perimeter=" + rP);
        }
    }
}
