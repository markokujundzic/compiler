// generated with ast extension for cup
// version 0.8
// 11/0/2021 14:17:49


package rs.ac.bg.etf.pp1.ast;

public class ReturnStatement implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private ReturnExpr ReturnExpr;

    public ReturnStatement (ReturnExpr ReturnExpr) {
        this.ReturnExpr=ReturnExpr;
        if(ReturnExpr!=null) ReturnExpr.setParent(this);
    }

    public ReturnExpr getReturnExpr() {
        return ReturnExpr;
    }

    public void setReturnExpr(ReturnExpr ReturnExpr) {
        this.ReturnExpr=ReturnExpr;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ReturnExpr!=null) ReturnExpr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ReturnExpr!=null) ReturnExpr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ReturnExpr!=null) ReturnExpr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ReturnStatement(\n");

        if(ReturnExpr!=null)
            buffer.append(ReturnExpr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ReturnStatement]");
        return buffer.toString();
    }
}
