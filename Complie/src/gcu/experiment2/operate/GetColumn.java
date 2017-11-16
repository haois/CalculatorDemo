package experiment2.operate;

import experiment2.define.CreateSLRTable;

/**
 * Created by haol on 2016/11/19.
 * 根据将进栈的字符获取SLR表的列号
 */
public class GetColumn {

        /**
         * 根据表达式计算器的单词编码的种别码获取所在二维表中的位置
         * @param strCode
         * @return
         */
        public int reActionCol(String strCode) {

                int row = 0;
                if (strCode.equals("1")) {
                        row = CreateSLRTable.ADD;
                } else if (strCode.equals("2")) {
                        row = CreateSLRTable.MINUS;
                } else if (strCode.equals("3")) {
                        row = CreateSLRTable.MULTIP;
                } else if (strCode.equals("4")) {
                        row = CreateSLRTable.DIVIDED;
                } else if (strCode.equals("5") || strCode.equals("8")) {
                        row = CreateSLRTable.C;
                } else if (strCode.equals("6")) {
                        row = CreateSLRTable.L_BRACKET;
                } else if (strCode.equals("7")) {
                        row = CreateSLRTable.R_BRACKET;
                } else if (strCode.equals("#")) {
                        return CreateSLRTable.SHARP;
                }
                return row;
        }

        public int reGotoCol(String strType) {

                int row = 0;
                if (strType.equals("S")) {
                        row = CreateSLRTable.S;
                } else if (strType.equals("X")) {
                        row = CreateSLRTable.X;
                } else if (strType.equals("Y")) {
                        row = CreateSLRTable.Y;
                } else if (strType.equals("D")) {
                        row = CreateSLRTable.D;
                }
                return row;
        }
}
