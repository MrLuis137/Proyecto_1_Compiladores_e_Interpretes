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
public class RepeatDo extends Command{
    public Expression eAST;
    public Command cAST;
    Command lAST;
    public boolean isWhile;
    
    public RepeatDo ( Command cAST, Expression eAST, Command lAST,Boolean isWhile, SourcePosition thePosition){
        super(thePosition);
        this.eAST = eAST;
        this.cAST = cAST;
        this.lAST = lAST;
    }

    @Override
    public Object visit(Visitor v, Object o) {
       return v.visitRepeatDo(this, o);
    }
}
