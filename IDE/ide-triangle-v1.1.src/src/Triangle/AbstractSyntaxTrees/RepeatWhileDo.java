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
public class RepeatWhileDo extends Command {
    
    public Expression eAST;
    public Command cAST;
    
    public RepeatWhileDo(Expression eAST, Command cAST, SourcePosition thePosition){
        super(thePosition);
        this.eAST = eAST;
        this.cAST = cAST;
    }

    @Override
    public Object visit(Visitor v, Object o) {
       return v.visitRepeatWhileDo(this, o);
    }

    
}
