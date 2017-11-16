package experiment2.ready;

import experiment1.Token;

import java.util.List;

public class OperateToken {

        /**
         * 根据实验一获取全部的token 并将有错误的删除
         * @param tokens
         * @return
         */
        public List<Token> getRightToken(List<Token> tokens){

                int size = tokens.size();
                for (int i = 0; i <size ; i++) {
                        if (tokens.get(i).getStrCodes().equals("e")){
                                System.out.println(tokens.get(i).toString()+"包含错误,已删除");
                                tokens.remove(i);
                                size --;
                                i--;
                        }
                }
                return tokens;
        }
}
