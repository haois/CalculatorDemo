package experiment2.operate;

import java.util.LinkedHashMap;

/**
 * Created by haol on 2016/11/20.
 * 规约时对语义栈的操作 将数字转换我t？
 * 并肩t？对应的值存入Map中
 */
public class Calculate {

        public static int t ;
        public static LinkedHashMap<String, String> connect = new LinkedHashMap<String, String>();

        String result_;/*t?*/

        /**
         * 根据当前归约右部，算值和t？并存入connect
         * @param arg1
         * @param opt
         * @param arg2
         * @return
         */
        public String getResult(String opt,String arg1,String arg2) {

                if (arg1.substring(0,1).equals("t")){
                       arg1 = this.getResultFromHash(arg1);
                }
                if (arg2.substring(0,1).equals("t")){
                        arg2 = this.getResultFromHash(arg2);
                }

                boolean isInt = !arg1.contains(".") && !arg2.contains(".");

                if (opt.equals("+")) {
                        if (isInt) {
                                int result = Integer.parseInt(arg1) + Integer.parseInt(arg2);
                                result_ = this.calculateInt(result);
                        } else {
                                double result = Double.parseDouble(arg1) + Double.parseDouble(arg2);
                                result_ = this.calculateDouble(result);
                        }
                } else if (opt.equals("-")) {
                        if (isInt) {
                                int result = Integer.parseInt(arg1) - Integer.parseInt(arg2);
                                result_ = this.calculateInt(result);
                        } else {
                                double result = Double.parseDouble(arg1) - Double.parseDouble(arg2);
                                result_ = this.calculateDouble(result);
                        }
                } else if (opt.equals("*")) {
                        if (isInt) {
                                int result = Integer.parseInt(arg1) * Integer.parseInt(arg2);
                                result_ = this.calculateInt(result);
                        } else {
                                double result = Double.parseDouble(arg1) * Double.parseDouble(arg2);
                                result_ =  this.calculateDouble(result);
                        }
                } else {
                        double result = Double.parseDouble(arg1) / Double.parseDouble(arg2);
                        result_ =  this.calculateDouble(result);
                }
                return result_;
        }
        /**
         * 将int转换为t？
         * @param result
         * @return
         */
        public String calculateInt(int result) {

                result_ = "t" + t;
                connect.put(result_, String.valueOf(result));
                t++;
                return result_;
        }

        /**
         * 将double转换为t？
         * @param result
         * @return
         */
        public String calculateDouble(double result) {

                String result_;
                result_ = "t" + t;
                connect.put(result_, String.valueOf(result));
                t++;
                return result_;
        }

        /**
         * 将t？转化为算数值
         * @param result_
         * @return
         */
        public String getResultFromHash(String result_){
                return connect.get(result_);
        }

        /**
         * /*将算数值result转换为t？并将关系滚入connect
         * @param result
         * @return
         */
        public String getResult(String result){
                if (result.substring(0,1).equals("t")){
                        return result;
                }else {
                        result_ = "t" + t;
                        connect.put(result_, String.valueOf(result));
                        t++;
                        return result_;
                }

        }

        /**
         * 返回connect
         * @return
         */
        public LinkedHashMap<String,String> retruenConnect(){
                return connect;
        }
        public void initializeCalculate(){
                t =1;
              connect.clear();
        }
}
