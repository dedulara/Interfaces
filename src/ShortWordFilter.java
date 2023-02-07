public class ShortWordFilter implements Filter
{
    @Override
    public boolean accept(Object x)
    {
        String sInput = (String) x;
        if(sInput.length() < 5) {return true;}
        else {return false;}
    }
}
