package OS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author :hly
 * @date :2018/6/15
 */
public class GroupsLinking {

    //可用磁盘快
    static int[][] groups = {{3, 1, 2, 3}, {3, 4, 5, 6,}, {0, 0, 0, 0}, {0, 0, 0, 0}, {2, 0, 7}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
    //当前空闲块
    static List<Integer> freeList = new ArrayList<Integer>(){{for(int i =1;i<=7;i++){add(i);}}};
    //已分配的块数
    static int allocationNum = 1;
    static Scanner scanner = new Scanner(System.in);

    public static void display() {
        //开始已分配的为0
        allocationNum = 1;
        //空闲盘块数
        int freeNum, temp, groupNum = 1;
        //空闲盘块号链没有结尾,后面还有很多组
        if (groups[0][1] != 0) {
            freeNum = groups[0][0];
            System.out.println("第一组盘块:");
            //输出第一组空闲盘块
            for (int j = 1; j <= freeNum; j++) {
                System.out.print(groups[0][j] + " ");
            }
            System.out.println();
            //下一组盘块
            temp = groups[0][1];
            //盘块组数
            groupNum++;
            //当空闲盘块号链没有结束
            while (groups[temp][1] != 0) {
                System.out.println("第" + groupNum + "组盘块:");
                freeNum = groups[temp][0];
                for (int j = 1; j <= freeNum; j++) {
                    System.out.print(groups[temp][j]+" ");
                }
                System.out.println();
                groupNum++;
                //s.free判断是否为末尾
                temp = groups[temp][1];
            }
            //退出后表示S.free为0，为盘块号链的结束
            System.out.println("第" + groupNum + "组盘块，也是最后一组:");
            freeNum = groups[temp][0];
            //1号为0，所以这次从2开始
            for (int j = 2; j <= freeNum; j++) {
                System.out.print(groups[temp][j] + " ");
            }
            System.out.println();

        }
        //表示空闲盘块链只有一组,1为0
        else {
            freeNum = groups[0][0];
            //1表示只有0
            if (freeNum == 1) {
                System.out.println("空闲盘块已经全部被分配:");

            } else {
                System.out.println("第一组盘块为:");
                for (int j = 2; j <= freeNum; j++) {
                    System.out.print(groups[0][j] + " ");
                }
                System.out.println();
            }
        }
    }

    //分配空闲块
    public static void allocate() {
        //空闲块数,分配的盘块号
        int freeNum, allocativeNum;
        //当前组盘块大于1块
        if (groups[0][0] > 1) {
            freeNum = groups[0][0];
            allocativeNum = groups[0][freeNum];
            groups[0][0]--;
            freeList.remove((Integer)allocativeNum);
            System.out.println("分配的块号为：" + allocativeNum);

        }
        //只剩一个空闲块
        else if (groups[0][0] == 1) {
            //不是链尾，还有其它空闲块组
            if (groups[0][1] != 0) {
                allocativeNum = groups[0][1];
                for (int j = 0; j < groups[allocativeNum].length; j++)
                    //当前组已经分配完，下一组拷贝到当前组
                    groups[0][j] = groups[allocativeNum][j];
                //groups[0][0]--;
                freeList.remove((Integer)allocativeNum);
                System.out.println("分配的块号为：" + allocativeNum);

            } else {
                System.out.println("已经没有空闲块了");
                return;
            }
        }
        //当前组已经分配完
        else {
            System.out.println("当前组已经分配完了");

        }
        display();
    }

    //回收空闲块
    public static void recycling() {
        int freeNum;
        System.out.println("请输入你想回收的空闲盘块的盘块号:");
        int recyclingNum = scanner.nextInt();
        for (int i = 0; i <freeList.size(); i++) {
            if (freeList.get(i) == recyclingNum) {
                System.out.println("该空闲块已经存在");
                return;
            }
        }
        //当前组不满3块
        if (groups[0][0] < 3) {
            freeNum = groups[0][0];
            groups[0][freeNum + 1] = recyclingNum;
            freeList.add(recyclingNum);
            groups[0][0]++;
        } else {
            for (int j = 0; j <= 3; j++)
                groups[recyclingNum][j] = groups[0][j];
            groups[0][0] = 1;
            groups[0][1] = recyclingNum;
            freeList.add(recyclingNum);
        }
        display();
    }

    //选择菜单
    public static void menu() {
        int i = scanner.nextInt();
        if(i==1) {
            allocate();
            menu();
        }
        else if(i==2) {
            recycling();
            menu();
        }
        else if(i==3){
            System.out.println("已退出");
        }
    }

    public static void main(String[] args) {

        display();
        System.out.println("请输入操作：1:分配，2:回收,3:退出");
        menu();

    }

}
