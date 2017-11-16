package experiment2.ready;

import experiment1.AnalyseStr;
import experiment1.ReadText;
import experiment1.Token;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haol on 2016/11/17.
 * 调用实验1的类处理字符
 */
public class GetToken {

        ReadText readText = new ReadText();
        AnalyseStr analyseStr = new AnalyseStr();
        List<String> strings = new ArrayList<String>();
        OperateToken operateToken = new OperateToken();

        /**
         * 将包含错误的token移除，返回正确的
         * @param str
         * @return
         * @throws Exception
         */
        public List<Token> returnToken(String str) throws Exception {
                List<Token> tokens = analyseStr.analyStr(str);
                tokens = operateToken.getRightToken(tokens);
                return tokens;
        }

        /**
         * 根据位置读取文件返回文件中的strings
         * @param location
         * @return
         */
        public List<String> returnStrList(String location) {
                strings = readText.readText(location);
                return strings;
        }
}
