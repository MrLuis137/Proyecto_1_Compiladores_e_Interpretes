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
public class ForCommand extends Command {
    Expression eAST;
    Command cAST;
    Command lAST; 
    ForCommandDefinition fdAST;

    ForCommand(ForCommandDefinition fdAST, Expression eAST, Command cAST, Command lAST, SourcePosition pos) {
        super(pos);
        this.eAST = eAST;
        this.cAST = cAST;
        this.lAST = lAST;
        
        this.fdAST = fdAST;
    }
    
    @Override
    public Object visit(Visitor v, Object o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
