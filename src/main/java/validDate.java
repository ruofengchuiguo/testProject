import java.util.Scanner;

public class validDate {

    static String testDate[]=new String[]{"-1111_2_3","1111_-1_3","1111_13_3","1111_2_30","1111_2_15"}; //��������

    public static void main(String[] args) {
        System.out.println("���� ��ʽ yyyy_mm_day");
        useTestDate();
    }
    public static void InputTest() //�Լ���������
    {
        Scanner sc = new Scanner(System.in); //ϵͳ����
        String s = sc.next(); //��������
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
        int month[]= new int[]{31,28,31,30,31,30,31,31,30,31,30,31}; //ÿ�����������
        String[] split = date.split("_"); //�����ڷ�Ϊ�꣬�£��յ��ַ�������
        int year = Integer.parseInt(split[0]); //������
        int mm = Integer.parseInt(split[1]); //����·�
        int day = Integer.parseInt(split[2]); //�����
        if(year<=0) //У�����
        {
            System.out.println("��ݲ����Ϲ淶");
            return;
        }
        if(mm<=0||mm>12) //У���·�
        {
            System.out.println("�·ݲ����Ϲ淶");
            return;
        }
        if(day<=0) //У����
        {
            System.out.println("���ڲ����Ϲ淶");
            return;
        }
        if(day>month[mm-1]) //�ж������Ƿ���Ϲ淶
        {
            System.out.println("�������������������");
            return;
        }
        System.out.println("���ڷ��Ϲ淶"); ////���Ϲ淶������

    }
}
