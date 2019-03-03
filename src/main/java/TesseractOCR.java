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
            String text = tesseract.doOCR(new File("../resources/test3.png"));
            fin = text;

        } catch (TesseractException e) {
            e.printStackTrace();
        }
        return fin;
    }

    public static String[] getInfo(String text){
        String[] array = new String[2];
        String date = "";
        String title = "";
        for(int i = 0; text.charAt(i) != '\n' ;i++){
            if(text.charAt(i) == '-'){
                date = text.substring(i-1, i+6);
                title = text.substring(0, i - 2);
            }
        }
        array[0] = title;
        array[1] = date;
        return array;
    }


    public static void main(String[] args) {
        String text = getText();
        System.out.println(text);
        System.out.println(getInfo(text));
    }

}
