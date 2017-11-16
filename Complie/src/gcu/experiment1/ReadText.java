package experiment1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by haol on 2016/11/3.
 */
public class ReadText {

      public List<String> readText(String location){
            List<String> strings = new ArrayList<String>();
            try{
                  Scanner scanner = new Scanner(new File(location));
                  String str = "";
                  while (scanner.hasNextLine()){
                        str = scanner.nextLine();
                        strings.add(str);
                  }
                  return strings;
            }catch(Exception e){
                  e.printStackTrace();
                  return null;
            }
      }

}
