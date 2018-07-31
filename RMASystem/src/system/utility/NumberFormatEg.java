
package system.utility;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatEg {
   public static void main(String[] args) {
      NumberFormat myFormat = NumberFormat.getInstance();
      myFormat.setGroupingUsed(true);

      double[] numbers = { 11220.00, 232323232.24, 121211.55, 102.121212 };

      for (double d : numbers) {
         System.out.println(myFormat.format(d));
      }
      System.out.println();

      DecimalFormat decimalFormat = new DecimalFormat("#.00");
      decimalFormat.setGroupingUsed(true);
      decimalFormat.setGroupingSize(3);

      for (double d : numbers) {
         System.out.println(decimalFormat.format(d));
      }

      
}
}