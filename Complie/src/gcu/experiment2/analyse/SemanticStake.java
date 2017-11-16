package experiment2.analyse;

import experiment2.operate.Calculate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haol on 2016/11/22.
 * 规约时对语义栈的操作
 */
public class SemanticStake {

        public OperateFAC operateFAC = new OperateFAC();

        public List<String> analyseSemanticStack(String rightStr, List<String> semantic, String actionState,List<String> semanticStack) {
                Calculate calculate = new Calculate();
                String opt;
                String result;
                String result_;
                String arg1;
                String arg2;
                if (actionState.equals("R10")) {
                        result = semanticStack.get(semanticStack.size() - 2);
                        result_ = calculate.getResult(result);
                        semanticStack = this.operationSemanticStack(result_, 3,semanticStack);

                } else if (actionState.equals("R8")) {

                        arg1 = semanticStack.get(semanticStack.size() - 1);
                        result = "-" + arg1;

                        result_ = calculate.getResult(result);
                        semanticStack = this.operationSemanticStack(result_, 2,semanticStack);
                        operateFAC.addFAC("@",arg1, "null", result_);
                } else {
                        opt = rightStr.substring(1, 2);
                        arg1 = semantic.get(0);
                        arg2 = semantic.get(2);
                        result_ = calculate.getResult(opt,arg1, arg2);

                        semanticStack = this.operationSemanticStack(result_, 3,semanticStack);
                        operateFAC.addFAC( opt,arg1, arg2, result_);

                }
                return semanticStack;
        }
        public  List<String>  operationSemanticStack(String result, int s, List<String> semanticStack) {
                for (; s > 0; s--) {
                        semanticStack.remove(semanticStack.size() - 1);
                }
                semanticStack.add(result);
                return semanticStack;
        }
}
