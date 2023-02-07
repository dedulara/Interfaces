import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class ShortLister
{
    public static void main(String[] args)
    {
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String inputString = "";
        ArrayList<Object> lines = new ArrayList<>();
        ArrayList<Object> collectA = new ArrayList<>();

        try
        {
            File workingDirectory = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDirectory);
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();
                InputStream in =
                        new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(in));
                int line = 0;
                while (reader.ready())
                {
                    inputString = reader.readLine();
                    lines.add(inputString);
                    line++;
                }
                reader.close();
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found!");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        ShortWordFilter sWF = new ShortWordFilter();
        ArrayList<Object> collectArray = new ArrayList<Object>();

        for(Object x : lines) {if(sWF.accept(x)) {CollectAll.collectStuff(collectArray, x);}}

        for(Object y : collectArray)
        {
            String sInput = (String) y;
            System.out.println(sInput);
        }
    }
}
