// generated with ast extension for cup
// version 0.8
// 11/0/2021 14:17:49


package rs.ac.bg.etf.pp1.ast;

public class YesOptionalTermList extends OptionalTermList {

    private OptionalTermList OptionalTermList;
    private Addop Addop;
    private FiniteTerm FiniteTerm;

    public YesOptionalTermList (OptionalTermList OptionalTermList, Addop Addop, FiniteTerm FiniteTerm) {
        this.OptionalTermList=OptionalTermList;
        if(OptionalTermList!=null) OptionalTermList.setParent(this);
        this.Addop=Addop;
        if(Addop!=null) Addop.setParent(this);
        this.FiniteTerm=FiniteTerm;
        if(FiniteTerm!=null) FiniteTerm.setParent(this);
    }

    public OptionalTermList getOptionalTermList() {
        return OptionalTermList;
    }

    public void setOptionalTermList(OptionalTermList OptionalTermList) {
        this.OptionalTermList=OptionalTermList;
    }

    public Addop getAddop() {
        return Addop;
    }

    public void setAddop(Addop Addop) {
        this.Addop=Addop;
    }

    public FiniteTerm getFiniteTerm() {
        return FiniteTerm;
    }

    public void setFiniteTerm(FiniteTerm FiniteTerm) {
        this.FiniteTerm=FiniteTerm;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(OptionalTermList!=null) OptionalTermList.accept(visitor);
        if(Addop!=null) Addop.accept(visitor);
        if(FiniteTerm!=null) FiniteTerm.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(OptionalTermList!=null) OptionalTermList.traverseTopDown(visitor);
        if(Addop!=null) Addop.traverseTopDown(visitor);
        if(FiniteTerm!=null) FiniteTerm.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(OptionalTermList!=null) OptionalTermList.traverseBottomUp(visitor);
        if(Addop!=null) Addop.traverseBottomUp(visitor);
        if(FiniteTerm!=null) FiniteTerm.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("YesOptionalTermList(\n");

        if(OptionalTermList!=null)
            buffer.append(OptionalTermList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Addop!=null)
            buffer.append(Addop.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FiniteTerm!=null)
            buffer.append(FiniteTerm.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [YesOptionalTermList]");
        return buffer.toString();
    }
}
