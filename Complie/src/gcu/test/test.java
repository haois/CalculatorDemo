package test;

import experiment1.FormatOut;
import experiment1.Token;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by haol on 2016/11/4.
 */
public class test {

      public static void main(String args[]){

            List<Token> tokens = new ArrayList<Token>();
            Token token = new Token("EEEE","EEEE","EEEE","EEEE");
            tokens.add(token);
            token.setStrApp("BBBB");
            tokens.add(token);
            FormatOut formatOut = new FormatOut();
            //formatOut.outAnalyse(tokens);

            Token token1 = new Token("EEEE","EEEE","EEEE","EEEE");
            Token token2 = new Token("EEEE","EEEE","EEEE","EEEE");
            HashMap<String,Token> hashMap = new HashMap<>();
            hashMap.put("1",token1);
            token.setStrCodes("FFF");

            hashMap.put("2",token2);
            System.out.println(hashMap.get("1").equals(hashMap.get("2")));
            System.out.println(hashMap.toString());

            StringBuffer stringBuffer = new StringBuffer("123242");
           // int a=(int)stringBuffer.charAt(3) -'0';
           // System.out.println("==="+a);
           // stringBuffer.append("abcd");
            stringBuffer.deleteCharAt(2);
            System.out.printf("-----"+stringBuffer.toString());

            stringBuffer = new StringBuffer();
            System.out.println("chuanshihua" + stringBuffer+"---");
           // System.out.println("最后"+stringBuffer.substring(stringBuffer.length()-1,stringBuffer.length()));


            String b = "S2";
            /*System.out.println(b.substring(0,1));
            System.out.println(b.substring(1,2));*/
            String a = "2";
            List<Integer> list = new ArrayList<>();
            list.add(11);
            list.add(12);
            list.add(13);
            list.add(14);
            /*OperateList operationList = new OperateList();
            list = operationList.deleteState(list,2);
            list.add(Integer.valueOf(a));*/
            list.clear();
            //list = new ArrayList<Integer>();
            System.out.println("size:"+list);
            System.out.printf("222222"+"153".substring(1,2));


      }
}
