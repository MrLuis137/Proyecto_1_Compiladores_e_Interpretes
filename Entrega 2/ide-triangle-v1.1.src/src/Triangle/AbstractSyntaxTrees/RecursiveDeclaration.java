/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

/*---------------------------------------------------------------
****************************************************************
* AST de recurive Declatation
* Editores: Tania Sanchez
****************************************************************/
public class RecursiveDeclaration extends Declaration{

    public ProcFunc pfAST;
    public RecursiveDeclaration pfcsAST;
    
    public RecursiveDeclaration(ProcFunc pfAST1,RecursiveDeclaration pfAST2, SourcePosition pos){
        super(pos);
        this.pfAST =  pfAST1;
        this.pfcsAST = pfAST2;
    }


    public Object visit(Visitor v, Object o) {
        return v.visitRecursiveDeclaration(this, o);
    }
    
    

    
}
