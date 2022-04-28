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
public class Nothing extends Command{

    public Nothing(SourcePosition pos) {
        super(pos);
    }
    
    
    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitNothing(this, o);
    }
    
}
