package experiment1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haol on 2016/11/3.
 */
public class AnalyseStr {

        public static int i = 0;
        //isNumStr 记录是否遍历在数字串中，是的话则数字包括Zero和。并记录数字串的开头 否则 无
        //一旦便利到数字 则一直便利内部i++不跳出while循环，直到遇到非数字和第一个'.'
        public static boolean isNumStr = false;

        public List<Token> analyStr(String str) throws Exception {
                i = 0;
                isNumStr = false;
                str = str.trim();
                List<Token> tokens = new ArrayList<Token>();

                int begin = 0;

                while (i < str.length()) {
                        String thisStr = str.substring(i, i + 1);
                        if (this.analyseIsNum(thisStr) ) {
                                if (!isNumStr) {
                                        begin = i;
                                }
                                isNumStr = true;

                                this.passNumStr(str);
                                //遍历到下一个非数字的位置
                                i++;
                                if (i + 1 < str.length() && str.substring(i, i + 1).equals(".")) {
                                        tokens = this.analyseIAfterDot(tokens, str, begin);
                                } else {
                                        Token token = new Token("5", str.substring(begin, i), str.substring(begin, i), "int");
                                        tokens.add(token);
                                        isNumStr = false;
                                }
                        } else if (thisStr.equals("0")) {
                                if (i+1<str.length()){
                                        if(this.analyseIsNum(str.substring(i+1,i+2)) || str.substring(i+1,i+2).equals("0")){
                                                Token token = new Token("e", str.substring(i, i+1), "ERROR", "0出现的位置不正确");
                                                tokens.add(token);
                                                i++;
                                                isNumStr = false;
                                        }else {
                                                tokens = this.analyseIsZero(tokens, str);
                                        }
                                }else{
                                        Token token = new Token("0", str.substring(i, i+1), str.substring(i, i+1), "int");
                                        tokens.add(token);
                                        i++;
                                        isNumStr = false;
                                }
                        } else {
                        /* 分析非数字并判断括号周围是否有误*/
                                tokens = this.analyseIsNotNum(tokens, str);
                        }
                }
                return tokens;
        }

        public boolean analyseIsNum(String numStr) {
                if (numStr.equals("1") || numStr.equals("2") || numStr.equals("3") || numStr.equals("4") ||
                        numStr.equals("5") || numStr.equals("6") || numStr.equals("7") || numStr.equals("8") || numStr.equals("9")) {
                        return true;
                } else {
                        return false;
                }
        }

        public List<Token> analyseNotNum(List<Token> tokens, String thisStr) {
                if (this.analyseIsOperator(thisStr)) {
                        if (thisStr.equals("+")) {
                                Token token = new Token("1", thisStr, "null", "null");
                                tokens.add(token);
                        } else if (thisStr.equals("-")) {
                                Token token = new Token("2", thisStr, "null", "null");
                                tokens.add(token);
                        } else if (thisStr.equals("*")) {
                                Token token = new Token("3", thisStr, "null", "null");
                                tokens.add(token);
                        } else if (thisStr.equals("/")) {
                                Token token = new Token("4", thisStr, "null", "null");
                                tokens.add(token);
                        }
                } else if (thisStr.equals("(")) {
                        Token token = new Token("6", thisStr, "null", "null");
                        tokens.add(token);
                } else if (thisStr.equals(")")) {
                        Token token = new Token("7", thisStr, "null", "null");
                        tokens.add(token);
                } else {
                        //System.out.println("ERROR:字符[   " + thisStr + "   ]输入有误!!");
                        tokens.add(new Token("e", thisStr, "ERROR", "不存在的字符"));
                }
                return tokens;
        }

        public boolean analyseIsOperator(String thisStr) {
                if (thisStr.equals("+") || thisStr.equals("-") || thisStr.equals("*") || thisStr.equals("/")) {
                        return true;
                }
                return false;
        }

        public List<Token> analyseIsZero(List<Token> tokens, String str) {
                if (!str.substring(i + 1, i + 2).equals(".")) {
                        Token token = new Token("5", str.substring(i, i + 1), str.substring(i, i + 1), "int");
                        tokens.add(token);
                        i++;
                } else {
                        i++;
                  /*分析小数点后面的字符
                  * i-1是begin从字符0开始*/
                        tokens = this.analyseIAfterDot(tokens, str, i - 1);
                }
                return tokens;
        }

        public List<Token> analyseIsNotNum(List<Token> tokens, String str) {
                isNumStr = false;
                String thisStr = str.substring(i, i + 1);
                //如果（前面是数字 则将（设置为ERROE AS    1(
                if (thisStr.equals("(") && i != 0 && this.analyseIsNum(str.substring(i - 1, i))) {
                        //System.out.println("ERROR:字符[   " + thisStr + "   ]输入有误!!");
                        Token token = new Token("e", thisStr, "REEOR", "数字后面不能直接跟'('");
                        tokens.add(token);
                } else {
                        this.analyseNotNum(tokens, thisStr);
                }
                i++;
                //将运算符后面的）设置为ERROR AS *)
                if (this.analyseIsOperator(thisStr) && str.substring(i, i + 1).equals(")")) {
                        //System.out.println("ERROR:字符[   " + str.substring(i, i + 1) + "   ]输入有误!!");
                        Token token = new Token("e", str.substring(i, i + 1), "REEOR", "运算符后面不能跟')'");
                        tokens.add(token);
                        i++;
                }
                return tokens;
        }

        public List<Token> analyseIAfterDot(List<Token> tokens, String str, int begin) {

                //此if假如出现小数点后面不是数字的情况，则将小数点前面数字存入，并判定小数点有误
                if (!this.analyseIsNum(str.substring(i + 1, i + 2)) && !str.substring(i + 1, i + 2).equals("0")) {
                        //将小数点前的数字设置为哦Int存入
                        Token token = new Token("5", str.substring(begin, i), str.substring(begin, i), "int");
                        tokens.add(token);

                        //将小数点也设为错误；
                        //System.out.println("ERROR:字符[   " + str.substring(i, i + 1) + "   ]输入有误!!");
                        tokens.add(new Token("e", str.substring(i, i + 1), "ERROR", "小数点后面字符有误"));
                        i++;

                        //将小数点后面的非数字设置为错误
                        //System.out.println("ERROR:字符[   " + str.substring(i, i + 1) + "   ]输入有误!!");
                        tokens.add(new Token("e", str.substring(i, i + 1), "ERROR", "小数点后面应该为数字"));
                        i++;
                        isNumStr = false;
                } else {
                        this.passNumStr(str);
                        i++;
                        Token token = new Token("8", str.substring(begin, i), str.substring(begin, i), "double");
                        tokens.add(token);
                        isNumStr = false;
                }
                return tokens;
        }

        public void passNumStr(String str) {
                while (i + 1 < str.length()) {
                        if (this.analyseIsNum(str.substring(i + 1, i + 2)) || str.substring(i + 1, i + 2).equals("0")) {
                                i++;
                        } else {
                                break;
                        }
                }
        }
}
