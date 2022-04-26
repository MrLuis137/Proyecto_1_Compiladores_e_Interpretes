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
    
    ProcDeclaration pdAST;
    FuncDeclaration fAST;
    
    public ProcFunc(ProcDeclaration pdAST, SourcePosition pos ){
        super(pos);
        this.pdAST = pdAST;
        fAST = null;
    }
    
    public ProcFunc(FuncDeclaration fAST, SourcePosition pos ){
        super(pos);
        pdAST = null;
        this.fAST = fAST;
    }

    @Override
    public Object visit(Visitor v, Object o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
