package experiment2.analyse;

import experiment2.define.FourAddressCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haol on 2016/11/26.
 * 对四元式的增加
 */
public class OperateFAC {

        public static List<FourAddressCode> fourAddressCode = new ArrayList<FourAddressCode>();

        public void addFAC(String opt,String arg1,  String arg2, String result_) {
                fourAddressCode.add(new FourAddressCode(opt, arg1, arg2, result_));
        }
        public List<FourAddressCode> getFourAddressCode(){
                return fourAddressCode;
        }
}
