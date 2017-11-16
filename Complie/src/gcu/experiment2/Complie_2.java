package experiment2;

import experiment1.Token;
import experiment2.analyse.OperateFAC;
import experiment2.operate.Calculate;
import experiment2.analyse.GuideTranslate;
import experiment2.define.FourAddressCode;
import experiment2.ready.GetToken;
import experiment2.ready.Logger;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by haol on 2016/11/17.
 */
public class Complie_2 {

        public static void main(String[] args) {
                /*读取文件内容*/
                String location = "C:\\Users\\haol\\Desktop\\作业\\编译原理\\实验一/TestTwo.txt";

                List<String> strings = new ArrayList<String>();
                List<Token> tokens = new ArrayList<Token>();
                List<FourAddressCode> fourAddressCode = new ArrayList<FourAddressCode>();
                LinkedHashMap<String, String> connect = new LinkedHashMap<String, String>();
                GetToken getToken = new GetToken();
                GuideTranslate guideTranslate = new GuideTranslate();
                Calculate calculate = new Calculate();
                Logger log = new Logger();
                OperateFAC operateFAC = new OperateFAC();

                log.outMyName();
                /*从文件中读取算数表达式字符串*/
                strings = getToken.returnStrList(location);
                String str;
                try {
                        int order = 1;
                      /*  for (String str : strings) {

                        }*/
                        //对于优先级相同的计算
                        // 老师的结果是左向右计算，我写的是从右向左计算
                        str = strings.get(order);
                        //str = "1+(2/3)*4+5";

                        System.out.println("\r\n待分析的第" + (order+1) + "个token串为：" + str + "分析如下：");
                        /*将算是表达式经过实验1处理后返回tokens串，并移除包含错误的串*/
                        tokens = getToken.returnToken(str);
                        log.out(tokens);


                        guideTranslate.analyseSemantic(tokens);
                        fourAddressCode = operateFAC.getFourAddressCode();
                        if (guideTranslate.isCorrent()){

                                System.out.println("\r\n已分析的结果构成的四元式如下：");
                                log.out(fourAddressCode);

                                System.out.println("\r\n已分析的结果的四元式中对应的t？的值如下：");
                                connect = calculate.retruenConnect();
                                System.out.println("Connect"+connect.toString());
                        }

                } catch (Exception e) {
                        e.printStackTrace();
                }
        }
}
 /* Set<String> keys =  connect.keySet();
                        for (String key:keys){
                                System.out.println(key+"=" + connect.get(key));
                        }*/