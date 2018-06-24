package OS;

import java.util.*;

/**
 * @author :hly
 * @date :2018/6/24
 */
public class SSTF {
    static Scanner scanner = new Scanner(System.in);
    //存放序列
    static List<Integer> list;
    //最短路径
    static List<Integer> listAfter;
    //经过的最短长度
    static int sumLength = 0;

    //最短优先SSTF
    public static void SSTF() {

        System.out.println("请输入请求序列的长度:");
        int length = scanner.nextInt();
        list = new ArrayList<Integer>(length);
        listAfter = new ArrayList<Integer>(length);
        System.out.println("请输入请求的序列:");
        for (int i = 0; i < length; i++)
            list.add(scanner.nextInt());
        System.out.println("请输入开始扫描的位置:");
        int start = scanner.nextInt();

        //排序
        Collections.sort(list);

        while(list.size()>0){
            int temp = start;
            int thisMin=Math.abs(list.get(temp)-1)<Math.abs(list.get(temp)+1)?list.get(temp-1):list.get(temp+1);
            list.remove(temp);
            listAfter.add(temp);
            temp = thisMin;
            sumLength+=thisMin;
        }
        System.out.println("最短的长度为:"+sumLength);
        //最短路径序列为
        for(Integer i:listAfter)
            System.out.print(i+" ");

    }

    public static void main(String[]args){
        SSTF();
    }


}
