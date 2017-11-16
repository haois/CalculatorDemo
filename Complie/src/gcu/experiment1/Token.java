package experiment1;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class Token {
    
//单  词	种别码		单  词	     种别码		单  词	种别码
//+	1		/	        4		(	                        6
//-	2		无符号整数	5		)	                 7
//*	3		无符号浮点数	8			

    //字符船的种别码
    private String strCodes ;
    //字符串原貌
    private String strApp;
    //字符串value 如 null或者1 2
    private String strValue;
    //字符串type 如 int double
    private String strType;

    /**
     * @return the strCodes
     */
    public String getStrCodes() {
        return strCodes;
    }



    /**
     * @param strCodes the strCodes to set
     */
    public void setStrCodes(String strCodes) {
        this.strCodes = strCodes;
    }

    /**
     * @return the strApp
     */
    public String getStrApp() {
        return strApp;
    }

    /**
     * @param strApp the strApp to set
     */
    public void setStrApp(String strApp) {
        this.strApp = strApp;
    }

    /**
     * @return the strValue
     */
    public String getStrValue() {
        return strValue;
    }

    /**
     * @param strValue the strValue to set
     */
    public void setStrValue(String strValue) {
        this.strValue = strValue;
    }

    /**
     * @return the strType
     */
    public String getStrType() {
        return strType;
    }

    /**
     * @param strType the strType to set
     */
    public void setStrType(String strType) {
        this.strType = strType;
    }

    public Token(String strCodes, String strApp, String strValue, String strType) {
        this.strApp = strApp;
        this.strValue = strValue;
        this.strType = strType;
        this.strCodes = strCodes;
    }

    @Override
    public String toString() {
        return "Token{("
                    + strCodes +
                "," + strApp  +
                "," + strValue  +
                "," + strType  +
                ")}";
    }
}
