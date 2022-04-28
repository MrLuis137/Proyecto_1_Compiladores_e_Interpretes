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
public class PrivateDeclaration extends Declaration {
    
    public Declaration dAST;
    public Declaration dAST2;
    
    public PrivateDeclaration (Declaration dAST, Declaration dAST2, SourcePosition pos){
        super(pos);
        this.dAST = dAST;
        this.dAST2 = dAST2;
    }

    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitPrivateDeclaration(this, o);
    }
    
    
}
