package OS;

import java.util.Scanner;

/**
 * @author :hly
 * @date :2018/6/15
 */
public class GroupsLinking {
    //每组3块
    static int[] freeGroup = new int[4];
    //可用磁盘快
    static int[][] groups = {{3, 1, 2, 3}, {3, 4, 5, 6,}, {0, 0, 0, 0}, {0, 0, 0, 0}, {3, 0, 7,8}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
    //已分配的块
    static int allocations[] = new int[8];
    //已分配的块数
    static int allocationNum = 1;
    static Scanner scanner = new Scanner(System.in);

    public static void display() {
        //开始已分配的为0
        allocationNum = 1;
        //空闲盘块数
        int freeNum, temp, groupNum = 1;
        //空闲盘块号链没有结尾,后面还有很多组
        if (freeGroup[1] != 0) {
            freeNum = freeGroup[0];
            System.out.println("第一组盘块:");
            //输出第一组空闲盘块
            for (int j = 1; j <= freeNum; j++) {
                System.out.print(freeGroup[j] + " ");
                allocations[allocationNum++] = freeGroup[j];
            }
            System.out.println();
            //下一组盘块
            temp = freeGroup[1];
            //盘块组数
            groupNum++;
            //当空闲盘块号链没有结束
            while (groups[temp][1] != 0) {
                System.out.println("第" + groupNum + "组盘块:");
                freeNum = groups[temp][0];
                for (int j = 1; j <= freeNum; j++) {
                    System.out.print(groups[temp][j]+" ");
                    allocations[allocationNum++] = groups[temp][j];
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
            for (int j = 2; j < freeNum; j++) {
                System.out.print(groups[temp][j] + " ");
                allocations[allocationNum++] = groups[temp][j];
            }
            System.out.println();

        }
        //表示空闲盘块链只有一组,1为0
        else {
            freeNum = freeGroup[0];
            //1表示只有0
            if (freeNum == 1) {
                System.out.println("空闲盘块已经全部被分配:");
            } else {
                System.out.println("第一组盘块为:");
                for (int j = 2; j < freeNum; j++) {
                    System.out.print(freeGroup[j] + " ");
                    allocations[allocationNum++] = freeGroup[j];
                }
                System.out.println();
            }
        }

    }

    public static void displayFreeBlocks() {
        int nextAddress;
        //当前组没有分配完
        if (freeGroup[0] != 0) {
            display();
        }
        //当前组已经分配完了
        else {
            //下一组的地址为
            nextAddress = freeGroup[1];
            for (int j = 0; j <= 3; j++)
                //分配完后，把下一组放到空闲盘块号栈
                freeGroup[j] = groups[nextAddress][j];
            display();
        }
    }

    //分配空闲块
    public static void allocate() {
        //空闲块数,分配的盘块号
        int freeNum, allocativeNum;
        //当前组盘块大于1块
        if (freeGroup[0] > 1) {
            freeNum = freeGroup[0];
            allocativeNum = freeGroup[freeNum];
            freeGroup[0]--;
            System.out.println("分配的块号为：" + allocativeNum);
        }
        //只剩一个空闲块
        else if (freeGroup[0] == 1) {
            //不是链尾，还有其它空闲块组
            if (freeGroup[1] != 0) {
                allocativeNum = freeGroup[1];
                for (int j = 0; j <= 3; j++)
                    //当前组已经分配完，下一组拷贝到当前组
                    groups[0][j] = groups[allocativeNum][j];
                    freeGroup[0]--;
                    System.out.println("分配的块号为：" + allocativeNum);

            } else {
                System.out.println("已经没有空闲块了");
                return;
            }
        }
        //当前组已经分配完
        else {
            System.out.println("当前组已经分配完了");
            for (int j = 0; j <= 3; j++) {
                freeGroup[j] = groups[0][j];
            }
        }
        displayFreeBlocks();
    }

    //回收空闲块
    public static void recycling() {
        int freeNum;
        System.out.println("请输入你想回收的空闲盘块的盘块号:");
        int recyclingNum = scanner.nextInt();
        for (int i = 1; i <= allocationNum; i++) {
            if (allocations[i] == recyclingNum) {
                System.out.println("该空闲块已经存在");
                return;
            }
        }
        //当前组不满3块
        if (freeGroup[0] < 3) {
            freeNum = freeGroup[0];
            freeGroup[freeNum + 1] = recyclingNum;
            freeGroup[0]++;
        } else {
            for (int j = 0; j <= 3; j++) {
                groups[recyclingNum][j] = freeGroup[j];
                freeGroup[0] = 1;
                freeGroup[1] = recyclingNum;
            }
        }

        displayFreeBlocks();
    }
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
        for(int i =0 ;i<=3;i++)
            freeGroup[i] = groups[0][i];
        display();
        System.out.println("请输入操作：1:分配，2:回收,3:退出");
        menu();

    }

}
