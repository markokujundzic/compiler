// generated with ast extension for cup
// version 0.8
// 1/0/2021 19:51:0


package rs.ac.bg.etf.pp1.ast;

public class AssignOpExprDesignatorAdditionYesError extends PossibleErrorDesignatorAddition {

    public AssignOpExprDesignatorAdditionYesError () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AssignOpExprDesignatorAdditionYesError(\n");

        buffer.append(tab);
        buffer.append(") [AssignOpExprDesignatorAdditionYesError]");
        return buffer.toString();
    }
}
