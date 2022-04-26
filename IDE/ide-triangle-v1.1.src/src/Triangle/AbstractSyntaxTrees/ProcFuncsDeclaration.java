/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;
import java.util.ArrayList;

/**
 *
 * @author lalem
 */
public class ProcFuncsDeclaration extends Declaration{

    ProcFunc pfAST;
    ArrayList<ProcFunc> pfASTs;
    
    public ProcFuncsDeclaration(ProcFunc pfAST1,ProcFunc pfAST2, SourcePosition pos){
        super(pos);
        this.pfAST =  pfAST1;
        pfASTs.add(pfAST2);
    }
    
    public void addProcFunc(ProcFunc pfAST){
        pfASTs.add(pfAST);
    }
    
    @Override
    public Object visit(Visitor v, Object o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
