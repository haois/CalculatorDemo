package experiment2.define;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by haol on 2016/11/18.
 * 创建SLR分析表
 */
public class CreateSLRTable {

        public static final int ADD = 0;/*+*/
        public static final int MINUS = 1;/*-*/
        public static final int MULTIP = 2;/***/
        public static final int DIVIDED = 3;/*/*/
        public static final int L_BRACKET = 4;/*(*/
        public static final int R_BRACKET = 5;/*)*/
        public static final int SHARP = 7;/*#*/
        public static final int C = 6;

        public static final int S = 0;
        public static final int X= 1;
        public static final int Y = 2;
        public static final int D = 3;


        public String[][] createACTION(){

                String[][] action = new String[19][8];

                action[0][MINUS] = "S9";
                action[0][R_BRACKET] = "S6";
                action[0][C] = "S5";

                action[1][SHARP] = "acc";

                action[2][ADD] = "S7";
                action[2][MINUS] = "S11";
                action[2][R_BRACKET] = "R3";
                action[2][SHARP] = "R3";

                action[3][ADD] = "R6";
                action[3][MINUS] = "R6";
                action[3][MULTIP] = "S13";
                action[3][DIVIDED] = "S17";
                action[3][R_BRACKET] = "R6";
                action[3][SHARP] = "R6";

                action = this.setValueRow(action,"R7",4);

                action = this.setValueRow(action,"R9",5);

                action[6][MINUS] = "S13";
                action[6][L_BRACKET] = "S6";
                action[6][C] = "S5";
                action[6][MINUS] = "S9";

                action[7][MINUS] = "S9";
                action[7][L_BRACKET] = "S6";
                action[7][C] = "S5";

                action = this.setValueRow(action,"R1",8);

                action[9][MINUS] = "S9";
                action[9][L_BRACKET] = "S6";
                action[9][C] = "S5";

                action = this.setValueRow(action,"R8",10);


                action[11][L_BRACKET] = "S6";
                action[11][C] = "S5";
                action[11][MINUS] = "S9";

                action = this.setValueRow(action,"R2",12);

                action[13][MINUS] = "S9";
                action[13][L_BRACKET] = "S6";
                action[13][C] = "S5";


                action = this.setValueRow(action,"R4",14);

                action[15][R_BRACKET] = "S16";

                action = this.setValueRow(action,"R10",16);

                action[17][MINUS] = "S9";
                action[17][L_BRACKET] = "S6";
                action[17][C] = "S5";

                action = this.setValueRow(action,"R5",18);

                return action;
        }
        public String[][] createGOTO(){
                String[][] goTo = new String[19][5];

                goTo[0][S] = "1";
                goTo[0][X] = "2";
                goTo[0][Y] = "3";
                goTo[0][D] = "4";

                goTo[6][S] = "15";
                goTo[6][X] = "2";
                goTo[6][Y] = "3";
                goTo[6][D] = "4";

                goTo[7][S] = "8";
                goTo[7][X] = "2";
                goTo[7][Y] = "3";
                goTo[7][D] = "4";

                goTo[9][Y] = "10";
                goTo[9][D] = "4";

                goTo[11][S] = "12";
                goTo[11][X] = "2";
                goTo[11][Y] = "3";
                goTo[11][D] = "4";

                goTo[13][X] = "14";
                goTo[13][Y] = "3";
                goTo[13][D] = "4";

                goTo[17][X] = "18";
                goTo[17][Y] = "3";
                goTo[17][D] = "4";

                return goTo;
        }

        public String[][] setValueRow(String[][] action,String value,int row){
                for (int i = 0;i<8;i++){
                        action[row][i] = value;
                }
                return action;
        }


}
