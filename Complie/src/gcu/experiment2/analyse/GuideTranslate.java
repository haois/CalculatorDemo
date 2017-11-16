package experiment2.analyse;

import experiment1.Token;
import experiment2.operate.QuerySLR;
import experiment2.define.CreateSLRTable;
import experiment2.define.MathExpression;
import experiment2.define.FourAddressCode;
import experiment2.operate.Calculate;
import experiment2.operate.GetColumn;
import experiment2.operate.OperateList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by haol on 2016/11/18.
 * 主要方法
 */
public class GuideTranslate {

        public static HashMap<String, String> expression = new HashMap<String, String>();
        public static HashMap<String, String> option = new HashMap<String, String>();

        public static HashMap<String, String> wordEnding = new HashMap<>();


        public static int i;
        boolean end = false;

        public static List<Integer> stateStack = new ArrayList<Integer>();/*状态栈*/
        public static List<String> semanticStack = new ArrayList<String>();//语义栈
        public static List<String> signStack = new ArrayList<String>();//符号栈

        public static List<FourAddressCode> fourAddressCode = new ArrayList<FourAddressCode>();

        QuerySLR querySLR = new QuerySLR();
        OperateFAC operateFAC = new OperateFAC();
        SemanticStake anySemanticStack = new SemanticStake();

        public List<Token> initializeSemantic(List<Token> tokens) {

                Calculate calculate = new Calculate();
                calculate.initializeCalculate();
                MathExpression definition = new MathExpression();
                List<HashMap> list = definition.definitionMemanticsRule();

                option = list.get(0);//<key,value> = <R?,表达式右部>
                expression = list.get(1);//<key,value> = <表达式右部,表达式左部>
                wordEnding = definition.wordEnding();/*表达式定义*/

                tokens.add(new Token("#", "#", "#", "#"));/*将token串回追加#结束符*/

                /*初始化开始*/
                i = 0;
                fourAddressCode.clear();

                /*初始化所有栈为空*/
                stateStack.clear();
                signStack.clear();
                semanticStack.clear();


                /*设置所有栈的初始值*/
                stateStack.add(0);
                semanticStack.add("-");
                signStack.add("#");

                return tokens;

        }

        public List<FourAddressCode> analyseSemantic(List<Token> tokens) {
                GetColumn getCol = new GetColumn();

                tokens = this.initializeSemantic(tokens);

                String actionState;/*SRL表中action状态*/

                int row;/*行下标*/
                int column;/*列下表*/


                while (!end) {
                        /*获取现在状态盏最后一个字符*//*获取现在等待符号盏的字符*/
                        row = stateStack.get(stateStack.size() - 1);
                        column = getCol.reActionCol(tokens.get(i).getStrCodes());
                        actionState = querySLR.actionState(row, column);

                        if (actionState != null) {
                                if (actionState.substring(0, 1).equals("S")) {
                                        this.shiftIn(tokens, row, column, actionState);
                                } else if (actionState.substring(0, 1).equals("R")) {
                                        this.redex(actionState);

                                } else if (actionState.equals("acc")) {
                                        end = true;

                                        System.out.println("该表达式不存在语义错误。");
                                }
                        } else {
                                System.out.println("ERROR:第" + (signStack.size() + 1) + "个字符" + tokens.get(i).getStrApp() + "存在语义错误！");
                                break;
                        }
                }
                return fourAddressCode;
        }

        public void shiftIn(List<Token> tokens, int row, int column, String actionState) {

                stateStack.add(Integer.valueOf(actionState.substring(1)));/*将S？状态的？放入状态盏*/

                if (column == CreateSLRTable.C) {/*如果为C则为常数将值放入语意盏*/
                        semanticStack.add(tokens.get(i).getStrValue());
                } else {/*将-放入*/
                        semanticStack.add("-");
                }
                signStack.add(tokens.get(i).getStrApp());/*在符号盏存入待进盏的字符*/
                i++;
        }

        public void redex(String actionState) {

                GetColumn getRow = new GetColumn();
                OperateList operateList = new OperateList();

                String gotoState;/*SRL表中goto状态*/
                int rightNum;/*归约时右部长度*/
                String rightStr;/*规约时表达式右部*/
                String leftStr;/*归约时表达式左部*/

                rightStr = option.get(actionState);
                leftStr = expression.get(rightStr);
                rightNum = rightStr.length();

                /*将符号栈需要归约的弹出*//*将归约后的入栈*/
                signStack = operateList.deleteState(signStack, rightNum);
                signStack.add(leftStr);

                /*将状态盏对应的弹出*//*获取现在状态盏最后一个字符*/
                /*获取符号盏的刚刚归约的字符，也就是最后面的*/
                stateStack = operateList.deleteState(stateStack, rightNum);
                int row = stateStack.get(stateStack.size() - 1);
                int column = getRow.reGotoCol(signStack.get(signStack.size() - 1));
                gotoState = querySLR.gotoState(row, column);
                stateStack.add(Integer.valueOf(gotoState));

                if (rightNum > 1) {
                        List<String> semantic = operateList.getSemantic(semanticStack, stateStack.size() - 1, rightNum);
                        //this.analyseSemanticStack(rightStr, semantic, actionState);
                        semanticStack = anySemanticStack.analyseSemanticStack(rightStr, semantic, actionState, semanticStack);
                }
        }
        public boolean isCorrent() {
                return end;
        }
        /*public void analyseSemanticStack(String rightStr, List<String> semantic, String actionState) {
                Calculate calculate = new Calculate();
                String opt;
                String result;
                String result_;
                String arg1;
                String arg2;
                if (actionState.equals("R10")) {
                        result = semanticStack.get(semanticStack.size() - 2);
                        result_ = calculate.getResult(result);
                        this.operationSemanticStack(result_, 3);

                } else if (actionState.equals("R8")) {

                        arg1 = semanticStack.get(semanticStack.size() - 1);
                        result = "-" + arg1;

                        result_ = calculate.getResult(result);
                        this.operationSemanticStack(result_, 2);
                        this.operateFAC("@", arg1, "null", result_);
                } else {
                        opt = rightStr.substring(1, 2);
                        arg1 = semantic.get(0);
                        arg2 = semantic.get(2);
                        result_ = calculate.getResult(opt, arg1, arg2);

                        this.operationSemanticStack(result_, 3);
                        this.operateFAC(opt, arg1, arg2, result_);
                }
        }

        public void operationSemanticStack(String result, int rightNum) {
                for (; rightNum > 0; rightNum--) {
                        semanticStack.remove(semanticStack.size() - 1);
                }
                semanticStack.add(result);
        }

        public void operateFAC(String opt, String arg1, String arg2, String result_) {
                operateFAC.addFAC(opt, arg1, arg2, result_);

        }*/
}
