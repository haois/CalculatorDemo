package experiment2.define;

/**
 * Created by haol on 2016/11/19.
 * 四元式实际上是一种“三地址语句”的等价表示。它的一般形式为：
 (op,arg1,arg2,result)
 */
public class FourAddressCode {

        private String op;
        private String arg1;
        private String arg2;
        private String result;


        public FourAddressCode(String op, String arg1, String arg2, String result) {
                this.op = op;
                this.arg1 = arg1;
                this.arg2 = arg2;
                this.result = result;
        }

        @Override
        public String toString() {
                return "("+result.substring(1)+")"+
                        "FAC{" + op + "," + arg1  + "," + arg2  + "," + result  + "}";
        }
}
