package experiment2.operate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haol on 2016/11/19.
 * 对list的出栈操作和返回正在处理的list信息
 */
public class OperateList {

        /**
         * 根据rightNum获取需要弹出栈的状态个数
         * @param state
         * @param rightNum
         * @return
         */
        public List deleteState(List state, int rightNum) {
                for (; rightNum > 0; rightNum--) {
                        state.remove(state.size() - 1);
                }
                return state;
        }

        /**
         * 根据归约表达式右部长度 获取现在需要处理的语意栈
         * @param semanticStack
         * @param begin
         * @param count
         * @return
         */
        public List getSemantic(List<String>semanticStack, int begin,int count){
                List<String> semantic = new ArrayList<String>();
                for (;count>0;begin++,count--){
                        semantic.add(semanticStack.get(begin));
                }
                return semantic;
        }
}
