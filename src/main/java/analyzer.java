import java.util.*;

public class analyzer {

    static char ch;

    static String strToken;

    static int index; //索引

    static String source;  //搜索字符串

    static int sourceLen;

    static List<String> character; //符号表

    static List<String> constNum; //常量表

    static Map<String,Integer> reserve; //保留字表

    static {
        character = new ArrayList<String>();
        constNum = new ArrayList<String >();
        reserve = new HashMap<String,Integer>();
    }

    public static String main(String[] args) {
        init(args[0]);
        GetChar();
        GetBC();
        if (isLetter()){
            while (isLetter() || isDigit())
            {
                Concat();
                GetChar();
            }
            Retract();
            int code = Reserve();
            if(code == 0)
            {
                int value = InsertId(strToken);
                return returnF(Character.$ID,value);
            }
            else{
                return returnF(code);
            }
        }
        else if(isDigit())
        {
            while (isDigit())
            {
                Concat();
                GetChar();
            }
            Retract();
            int value = InsertConst(strToken);
            return returnF(Character.$INT,value);
        }
        else if(ch=='=')
        {
            return returnF(Character.$ASSIGN);
        }
        else if(ch=='+')
        {
            return returnF(Character.$PLUS);
        }
        else if(ch=='*')
        {
            GetChar();
            if(ch=='*')
            {
                return returnF(Character.$POWER);
            }
            Retract();
            return returnF(Character.$STAR);
        }
        else if(ch==';')
        {
            return returnF(Character.$SEMICOLON);
        }
        else if(ch=='(')
        {
            return returnF(Character.$LPAR);
        }
        else if(ch==')')
        {
            return returnF(Character.$RPAR);
        }
        else if(ch=='{')
        {
            return returnF(Character.$LBRACE);
        }
        else if(ch=='}')
        {
            return returnF(Character.$RBRACE);
        }
        else if(ch!=' ') {
            return ProcError();
        }
        return "空字符串";

    }
    public static String ProcError()
    {
        return ("错误处理触发");
    }

    public static String returnF(Character c, int value)
    {
        return ("返回标识符和指针 "+c.getName()+","+value);
    }
    public static String returnF(int code)
    {
        return ("返回保留字编码"+code);
    }
    public static String returnF(Character c)
    {
        return ("返回符号字符"+c.getName());
    }
    public static void init(String s)
    {
        strToken = "";
        source = s;
        index=0;
        sourceLen=source.length();
    }

    public static void GetChar() {
        if(sourceLen==index)
        {
            ch = ' ';
            return;
        }
        ch = source.charAt(index);
        index++;
    }

    public static void GetBC() {
        while (ch == ' '&&index<sourceLen) {
            GetChar();
        }
    }

    public static void Concat() {
        strToken = new StringBuilder(strToken).append(ch).toString();
    }

    public static boolean isLetter() {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }

    public static boolean isDigit() {
        return ch >= '0' && ch <= '9';
    }

    public static int Reserve()
    {
        if(reserve.containsKey(strToken))
        {
            return reserve.get(strToken);
        }
        return 0;
    }

    public static void Retract()
    {
        index--;
        ch = ' ';
    }

    public static int InsertId(String s)
    {
        character.add(s);
        return character.size();
    }

    public static int InsertConst(String s)
    {
        constNum.add(s);
        return constNum.size();
    }
}

