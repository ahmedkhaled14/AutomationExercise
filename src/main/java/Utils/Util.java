package Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
    public static String GenerateCurrentDateAndTime() {
        return new SimpleDateFormat("ddMMyyyyHHmmssSSS").format(new Date());
    }
}
