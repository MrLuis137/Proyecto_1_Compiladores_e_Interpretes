/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

/*---------------------------------------------------------------
****************************************************************
* AST de Variable inicializada
* Editores: Tania Sanchez 
****************************************************************/
 public class InitializedVarDeclaration extends Declaration{
    
    public Identifier I;
    public Expression E;
   
   public InitializedVarDeclaration (Identifier iAST,Expression eAST,
                         SourcePosition thePosition) {
    super (thePosition);
    I = iAST;
    E = eAST;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitInitializedVarDeclaration(this, o);
  }


}
