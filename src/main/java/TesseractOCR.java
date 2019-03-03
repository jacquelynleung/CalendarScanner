import java.io.File;
import java.util.List;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class TesseractOCR {

    public static String getText() {
        Tesseract tesseract = new Tesseract();
        String fin = "";
        try {
            tesseract.setDatapath("/Users/jleung00/Desktop/CalendarScanner/tessdata");
            String text = tesseract.doOCR(new File("/Users/jleung00/Desktop/test3.png"));
            fin = text;

        } catch (TesseractException e) {
            e.printStackTrace();
        }
        return fin;
    }

    public static String[] getTitle(String text){
        String lines[] = text.split("\\r?\\n");
        return lines;
    }

    public static String getDate(String text){
        return "";
    }


    public static void main(String[] args) {
        String text = getText();
        System.out.println(text);
        System.out.println(getDate(text));
    }

}
