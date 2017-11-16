package experiment2.ready;

import java.util.List;

/**
 * Created by haol on 2016/11/22.
 * 输出格式
 */
public class Logger {

    public void out(List list) {
        for (Object lis : list) {
            System.out.println(lis.toString());
        }
    }

    public void outMyName() {
        System.out.println("----------------------");
        System.out.println("姓名：计算机工程学院");
        System.out.println("班级：软件工程");
        System.out.println("电话：1709");
        System.out.println("----------------------");
    }
}
