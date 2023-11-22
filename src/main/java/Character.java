public enum Character {

    $ID("标识符"),
    $INT("整数"),
    $ASSIGN("= (赋值)"),
    $PLUS("+ (加号)"),
    $SEMICOLON("; (分号)"),
    $LPAR("（ (左括号)"),
    $RPAR(") (右括号)"),
    $LBRACE("{ (左中括号)"),
    $RBRACE("} (右中括号)"),
    $STAR("STAR"),
    $POWER("POWER");
    private String name;

     Character(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

}
