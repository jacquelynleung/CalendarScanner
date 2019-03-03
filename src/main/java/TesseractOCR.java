import java.io.File;
import java.util.List;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class TesseractOCR {

    public static String getText() {
        Tesseract tesseract = new Tesseract();
        String fin = "";
        try {
            tesseract.setDatapath("/Users/jleung00/Desktop/tessdata");
            String text = tesseract.doOCR(new File("/Users/jleung00/Desktop/test4.png"));
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
        int l = text.length();
        for(int i = 0; i < l ;i++){
            if(text.charAt(i) == '-'){
                date = text.substring(i-4, i+6);
                title = text.substring(0, i - 5);
                break;
            }
        }
        array[0] = title;
        array[1] = date;
        return array;
    }


    public static void main(String[] args) {
        String text = getText();
        System.out.println(text);
        String lines[] = text.split("\\r?\\n");
        String title = "";
        String date = "";
        for(String s : lines){
            if(!s.equals("")){
                String[] array = getInfo(s);
                title = array[0];
                date = array[1] + "T09:00:00-07:00";
                System.out.println("Title: " + title + " Date: " + date);
            }

        }

    }

}
