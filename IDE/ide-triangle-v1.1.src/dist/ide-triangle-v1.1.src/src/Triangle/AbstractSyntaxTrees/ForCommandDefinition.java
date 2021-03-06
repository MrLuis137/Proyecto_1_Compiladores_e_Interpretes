/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

/*---------------------------------------------------------------
****************************************************************
* AST de For Command
* Editores: Luis Diego AZ
****************************************************************/
public class ForCommandDefinition extends Command{
    public Identifier iAST;
    public Expression esAST;
    
    public ForCommandDefinition(Identifier iAST, Expression esAST, SourcePosition postion){
        super(postion);
        this.iAST = iAST;
        this.esAST = esAST;
    }
        
    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitForCommandDef(this, o);
    }
    
    
}
