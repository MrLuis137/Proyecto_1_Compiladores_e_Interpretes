/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

/**
 *
 * @author lalem
 */
public class ProcFunc extends Declaration{
    
    public ProcDeclaration pAST;
    public FuncDeclaration fAST;
    
    public ProcFunc(ProcDeclaration pAST, SourcePosition pos ){
        super(pos);
        this.pAST = pAST;
        fAST = null;
    }
    
    public ProcFunc(FuncDeclaration fAST, SourcePosition pos ){
        super(pos);
        pAST = null;
        this.fAST = fAST;
    }

    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitProcFunc(this, o);

    }
    
}
