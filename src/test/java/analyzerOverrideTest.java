import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;


public class analyzerOverrideTest  {

    @Before
    public void before()
    {
       analyzer.init("");
    }
    @After
    public void after()
    {
        analyzer.reserve.clear();
        analyzer.constNum.clear();
        analyzer.character.clear();
    }
    @Test
    public void reserveCode()
    {
        analyzer.reserve.put("hello",1);
        Assert.assertEquals(analyzer.main(new String[]{"hello"}),"返回保留字编码1");
    }
    @Test
    public void Identifier()
    {
        Assert.assertEquals(analyzer.main(new String[]{"hello"}),"返回标识符和指针 标识符,1");
    }
    @Test
    public void Digit()
    {
        Assert.assertEquals(analyzer.main(new String[]{"123456"}),"返回标识符和指针 整数,1");
    }
    @Test
    public void equal()
    {
        Assert.assertEquals(analyzer.main(new String[]{"="}), "返回符号字符"+Character.$ASSIGN.getName());
    }
    @Test
    public void plus()
    {
        Assert.assertEquals(analyzer.main(new String[]{"+"}),"返回符号字符"+Character.$PLUS.getName());
    }
    @Test
    public void power()
    {
        Assert.assertEquals(analyzer.main(new String[]{"**"}),"返回符号字符"+Character.$POWER.getName());
    }
    @Test
    public void star()
    {
        Assert.assertEquals(analyzer.main(new String[]{"*a"}),"返回符号字符"+Character.$STAR.getName());
    }

    @Test
    public void SEMICOLON ()
    {
        Assert.assertEquals(analyzer.main(new String[]{";"}),"返回符号字符"+Character.$SEMICOLON.getName());
    }

    @Test
    public void LPAR()
    {
        Assert.assertEquals(analyzer.main(new String[]{"("}),"返回符号字符"+Character.$LPAR.getName());
    }
    @Test
    public void RPAR()
    {
        Assert.assertEquals(analyzer.main(new String[]{")"}),"返回符号字符"+Character.$RPAR.getName());
    }
    @Test
    public void LBRACE()
    {
        Assert.assertEquals(analyzer.main(new String[]{"{"}),"返回符号字符"+Character.$LBRACE.getName());
    }
    @Test
    public void RBRACE()
    {
        Assert.assertEquals(analyzer.main(new String[]{"}"}),"返回符号字符"+Character.$RBRACE.getName());
    }
    @Test
    public void errorTest()
    {
        Assert.assertEquals(analyzer.main(new String[]{"你好"}),"错误处理触发");
    }

    @Test
    public void emptyTest()
    {
        Assert.assertEquals(analyzer.main(new String[]{""}),"空字符串");
    }
    @Test
    public void emptyTest1()
    {
        Assert.assertEquals(analyzer.main(new String[]{" "}),"空字符串");
    }

}
