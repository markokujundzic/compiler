package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;

public class SemanticAnalyzer extends VisitorAdaptor
{
    /* Utils */
    private Logger log = Logger.getLogger(getClass());

    private boolean errorDetected = false;
    private int varDeclCount = 0;

    private Struct currentType = null;

    /* Report error */
    public void report_error(String message, SyntaxNode info)
    {
        errorDetected = true;

        StringBuilder msg = new StringBuilder(message);
        int line = (info == null) ? 0: info.getLine();

        if (line != 0)
        {
            msg.append(" on line ").append(line);
        }

        log.error(msg.toString());
    }

    /* Report info */
    public void report_info(String message, SyntaxNode info)
    {
        StringBuilder msg = new StringBuilder(message);
        int line = (info == null) ? 0: info.getLine();

        if (line != 0)
        {
            msg.append(" on line ").append(line);
        }

        log.info(msg.toString());
    }

    /* Program */
    public void visit(ProgramName programName)
    {
        programName.obj = Tab.insert(Obj.Prog, programName.getProgramName(), Tab.noType);
        SymTab.openScope();
    }

    public void visit(Program program)
    {
        SymTab.chainLocalSymbols(program.getProgramName().obj);
        SymTab.closeScope();
    }

    /* Type */
    public void visit(Type type)
    {
        Obj typeNode = SymTab.find(type.getName());

        if (typeNode == SymTab.noObj)
        {
            report_error("Type " + type.getName() + " not found in Symbol Table, on line " + type.getLine(), null);
            type.struct = currentType = SymTab.noType;
        }
        else if (typeNode.getKind() == Obj.Type)
        {
            type.struct = currentType = typeNode.getType();
        }
        else
        {
            report_error("Error: Identifier " + type.getName() + " does not represent a type, on line " + type.getLine(), null);
            type.struct = currentType = SymTab.noType;
        }
    }

    /* Global variable */
    public void visit(DeclVariable declVariable)
    {
        varDeclCount++;
        Obj varNode = SymTab.find(declVariable.getVarDeclName().getName());

        if (varNode == SymTab.noObj)
        {
            if (declVariable.getVarDeclArrayOption() instanceof YesVarDeclArrayOption)
            {
                SymTab.insert(Obj.Var, declVariable.getVarDeclName().getName(), new Struct(Struct.Array, currentType));
                report_info("Global array " + declVariable.getVarDeclName().getName() + " declared, on line " + declVariable.getVarDeclName().getLine(), declVariable);
            }
            else if (declVariable.getVarDeclArrayOption() instanceof NoVarDeclArrayOption)
            {
                SymTab.insert(Obj.Var, declVariable.getVarDeclName().getName(), currentType);
                report_info("Global variable " + declVariable.getVarDeclName().getName() + " declared, on line " + declVariable.getVarDeclName().getLine(), declVariable);
            }
        }
        else
        {
            errorDetected = true;
            report_error("Error: Global variable " + declVariable.getVarDeclName().getName() + " has already been declared, on line " + declVariable.getVarDeclName().getLine(), null);
        }
    }
}