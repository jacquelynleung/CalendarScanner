import java.io.File;
import java.util.List;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class TesseractOCR {

    public static void main(String []args) {
        Tesseract tesseract = new Tesseract();
        try {
            tesseract.setDatapath("/Users/jleung00/Desktop/CalendarScanner/tessdata");
            String text = tesseract.doOCR(new File("/Users/jleung00/Desktop/test3.png"));
            System.out.print(text);

        } catch (TesseractException e) {
            e.printStackTrace();
        }
    }

}
