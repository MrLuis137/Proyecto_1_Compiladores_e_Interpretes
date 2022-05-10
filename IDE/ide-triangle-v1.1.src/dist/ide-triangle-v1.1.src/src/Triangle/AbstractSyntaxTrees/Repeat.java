/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

/*---------------------------------------------------------------
****************************************************************
* AST de Repeat
* Editores: Luis Diego AZ
****************************************************************/
public class Repeat extends Command {
    public Expression eAST;
    public Command cAST;
    public Command lAST;
    public boolean isWhile;
    
    public Repeat(  Expression eAST,Command cAST,Command lAST,Boolean isWhile, SourcePosition thePosition){
        super(thePosition);
        this.eAST = eAST;
        this.cAST = cAST;
        this.lAST = lAST;
    }

    @Override
    public Object visit(Visitor v, Object o) {
       return v.visitRepeat(this, o);
    }
}
