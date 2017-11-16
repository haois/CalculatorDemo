package experiment2.operate;

import experiment2.define.CreateSLRTable;

/**
 * Created by haol on 2016/11/22.
 * 根基行和列号返回状态
 */
public class QuerySLR {

        public static String[][] action = new String[19][8];
        public static String[][] goTo = new String[19][5];
        static{
                initialize();
        }

        public static void initialize(){
                CreateSLRTable createSLRTable = new CreateSLRTable();
                action = createSLRTable.createACTION();
                goTo = createSLRTable.createGOTO();
        }
        public String actionState(int row,int column){

                return action[row][column];
        }
        public String gotoState(int row,int column){
                return goTo[row][column];
        }
}
