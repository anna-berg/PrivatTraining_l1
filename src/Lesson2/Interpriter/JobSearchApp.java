package Lesson2.Interpriter;

public class JobSearchApp {
    public static void main(String[] args) {
        ExpressionJob isJava = getJavaExpression();
        ExpressionJob isJavaEEDev = getEEJavaExpression();

        System.out.println("Does developer knows Java Core: " + isJava.interpr("Java Core"));
        System.out.println("Does developer knows Java EE: " + isJavaEEDev.interpr("Java Spring"));

    }

    public static ExpressionJob getJavaExpression(){
        ExpressionJob java = new TerminalExpression("Java");
        ExpressionJob javaCore = new TerminalExpression("Java Core");

        return new OrExpression(java, javaCore);
    }
    public static ExpressionJob getEEJavaExpression(){
        ExpressionJob java = new TerminalExpression("Java");
        ExpressionJob spring = new TerminalExpression("Spring");

        return new AndExpression(java, spring);
    }
}
interface ExpressionJob{
    boolean interpr (String context);
}

class AndExpression implements ExpressionJob{
    private ExpressionJob expression1;
    private ExpressionJob expression2;

    public AndExpression(ExpressionJob expression1, ExpressionJob expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public boolean interpr(String context) {
        return expression1.interpr(context) && expression2.interpr(context);
    }
}

class OrExpression implements ExpressionJob{
    private ExpressionJob expression1;
    private ExpressionJob expression2;

    public OrExpression(ExpressionJob expression1, ExpressionJob expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public boolean interpr(String context) {
        return expression1.interpr(context) || expression2.interpr(context);
    }
}

class TerminalExpression implements ExpressionJob{
    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpr(String context) {
        if (context.contains(data)){
            return true;
        } else return false;
    }
}