package experiment1;

import java.util.List;

/**
 * Created by haol on 2016/11/4.
 */
public class FormatOut {
    public void outAnalyse(List<Token> tokens) {
        System.out.println("字符分析结果如下:");
        for (Token token : tokens) {
            System.out.println("种别码:" + String.format("%-3s", token.getStrCodes()) +
                    ";原  貌:" + String.format("%-6s", token.getStrApp()) +
                    ";价  值:" + String.format("%-6s", token.getStrValue()) +
                    ";类  型:" + token.getStrType());
        }
    }

    public void outAnalyse_Tea(List<Token> tokens) {
        System.out.println("字符分析结果如下:");
        for (Token token : tokens) {
            System.out.println("(" + String.format("%-3s", token.getStrCodes()) +
                    "," + String.format("%-5s", token.getStrApp()) +
                    "," + String.format("%-6s", token.getStrValue()) +
                    "," + token.getStrType() + ");");
        }
    }

    public void outMyName() {
        System.out.println("----------------------");
        System.out.println("姓名：计算机工程学院");
        System.out.println("班级：软件工程");
        System.out.println("电话：1709");
        System.out.println("----------------------");
    }
}
