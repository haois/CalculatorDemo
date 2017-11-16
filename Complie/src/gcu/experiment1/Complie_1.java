package experiment1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haol on 2016/11/3.
 */
public class Complie_1 {

      public static void main(String[] args) {
            int count = 0;
            ReadText readText = new ReadText();
            AnalyseStr analyseStr = new AnalyseStr();
            FormatOut formatOut = new FormatOut();
            List<String> strings = new ArrayList<String>();
            String location = "C:\\Users\\haol\\Desktop\\作业\\编译原理\\实验一/TestTwo.txt";
            strings= readText.readText(location);
           /* String str1 = "(0.(10*)[48.)0/(3(+-1.0)]+9";
            strings.add(str1);*/
            //String str = "10/((1.56-4)+0*-4+0.0000)";
            formatOut.outMyName();
            try {
                  for (String str:strings){
                        count++;
                        System.out.println("\r\n第"+count+"个待分析的字符为：" + str);
                        List<Token> tokens = analyseStr.analyStr(str);
                        formatOut.outAnalyse_Tea(tokens);
                  }
            }catch (Exception e){
                  System.out.println(e.getMessage());
                  e.printStackTrace();
            }
      }
}
