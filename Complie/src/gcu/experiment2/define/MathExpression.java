package experiment2.define;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by haol on 2016/11/17.
 * 创建表达式和单词编码定义
 */
public class MathExpression {

        /*四、	表达式定义*/
        public List<HashMap> definitionMemanticsRule() {

                //遇到需要归约的时候根据R?根据key从option中获取value
                //此value是expression中的key,然后获取expression中的value 是将规约的内容
                HashMap<String, String> expression = new HashMap<String, String>();
                expression.put("S'", "S");
                expression.put("X+S", "S");
                expression.put("X-S", "X");
                expression.put("X", "S");
                expression.put("Y*X", "X");
                expression.put("Y/X", "X");
                expression.put("Y", "X");
                expression.put("D", "Y");
                expression.put("-Y", "Y");
                expression.put("c", "D");
                expression.put("(S)", "D");

                HashMap<String, String> option = new HashMap<String, String>();
                option.put("R0'", "S");
                option.put("R1", "X+S");
                option.put("R2", "X-S");
                option.put("R3", "X");
                option.put("R4", "Y*X");
                option.put("R5", "Y/X");
                option.put("R6", "Y");
                option.put("R7", "D");
                option.put("R8", "-Y");
                option.put("R9", "c");
                option.put("R10", "(S)");

                List<HashMap> list = new ArrayList<>();
                list.add(option);
                list.add(expression);
                return list;
        }

        /*五、	表达式计算器的单词编码*/
        public HashMap<String, String> wordEnding() {
                HashMap<String, String> wordEnding = new HashMap<>();
                wordEnding.put("1", "+");
                wordEnding.put("2", "-");
                wordEnding.put("3", "*");
                wordEnding.put("4", "/");
                wordEnding.put("5", "int");
                wordEnding.put("8", "double");
                wordEnding.put("6", "(");
                wordEnding.put("7", ")");
                return wordEnding;
        }
}
