import java.util.Scanner;

public class validDate {

    static String testDate[]=new String[]{"-1111_2_3","1111_-1_3","1111_13_3","1111_2_30","1111_2_15"}; //测试数据

    public static void main(String[] args) {
        System.out.println("日期 格式 yyyy_mm_day");
        useTestDate();
    }
    public static void InputTest() //自己输入数据
    {
        Scanner sc = new Scanner(System.in); //系统输入
        String s = sc.next(); //输入日期
        valid(s);
    }
    public static void useTestDate() {
        for (int i=0;i<testDate.length;i++)
        {
            System.out.println("Test "+i);
            valid(testDate[i]);
        }
    }

    public static void  valid(String date)
    {
        int month[]= new int[]{31,28,31,30,31,30,31,31,30,31,30,31}; //每月最大天数表
        String[] split = date.split("_"); //将日期分为年，月，日的字符串数组
        int year = Integer.parseInt(split[0]); //获得年份
        int mm = Integer.parseInt(split[1]); //获得月份
        int day = Integer.parseInt(split[2]); //获得日
        if(year<=0) //校验年份
        {
            System.out.println("年份不符合规范");
            return;
        }
        if(mm<=0||mm>12) //校验月份
        {
            System.out.println("月份不符合规范");
            return;
        }
        if(day<=0) //校验日
        {
            System.out.println("日期不符合规范");
            return;
        }
        if(day>month[mm-1]) //判断日期是否符合规范
        {
            System.out.println("天数超过本月最大天数");
            return;
        }
        System.out.println("日期符合规范"); ////符合规范输出结果

    }
}
