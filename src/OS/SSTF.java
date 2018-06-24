package OS;

import java.util.*;

/**
 * @author :hly
 * @date :2018/6/24
 */
public class SSTF {
    static Scanner scanner = new Scanner(System.in);
    //请求序列长度
    static int length;
    //存放序列
    static int[] arrays;
    //最短路径
    static int[] arraysAfter;
    //经过的最短长度
    static int sumLength = 0;
    //开始位置
    static int start;

    static int MIM_NUM = Integer.MAX_VALUE;

    //输入
    public static void input(){
        System.out.println("请输入请求序列的长度:");
        length = scanner.nextInt();
        arrays = new int[length];
        arraysAfter = new int[length];
        System.out.println("请输入请求的序列:");
        for (int i = 0; i < length; i++)
            arrays[i] = scanner.nextInt();
        System.out.println("请输入开始扫描的位置:");
        start = scanner.nextInt();
    }

    //最短优先SSTF
    public static void SSTF() {
        int num = length;
        int thisMinPoint = start;
        int thisIndex = 0;
        int after = 0;

        while (num > 0) {
            for (int j = 0; j < length; j++) {
                if (Math.abs(thisMinPoint - arrays[j]) < MIM_NUM && arrays[j] != -1) {
                    MIM_NUM = Math.abs(thisMinPoint - arrays[j]);
                    thisIndex = j;
                }
            }
            num--;
            thisMinPoint = arrays[thisIndex];
            arraysAfter[after++] = arrays[thisIndex];
            arrays[thisIndex] = -1;
            sumLength += MIM_NUM;
            MIM_NUM = Integer.MAX_VALUE;

        }
    }

    //输出结果
    public static void output(){
        System.out.println("总路线长度为:" + sumLength);
        System.out.println("平均查找长度为:" + sumLength / length);
        System.out.println("查找路径为:");
        for (int i : arraysAfter)
            System.out.print(i + " ");
    }

    public static void main(String[] args) {
        //98，183，37，122，14，124，65，67
        input();
        SSTF();
        output();

    }


}
