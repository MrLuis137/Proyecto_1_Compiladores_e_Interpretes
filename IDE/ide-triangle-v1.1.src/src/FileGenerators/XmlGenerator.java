package FileGenerators;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.io.FileOutputStream;
import java.io.IOException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.OutputStream;
import java.util.Enumeration;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
 
/*---------------------------------------------------------------
****************************************************************
* Generador de XML
* Editores: Oswaldo Ramirez
****************************************************************/
public class XmlGenerator {
    
    

    Document doc;
    Element last;
    Element root;
    
    public XmlGenerator() throws ParserConfigurationException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        doc = docBuilder.newDocument();
        
        //hacemos el root
        Element rootElement = doc.createElement("Program");
        doc.appendChild(rootElement);
        root = rootElement;
        last = rootElement;
        
    }
    
    
    //si solo se da el nombre, se genera en ROOT
    public Element newChild(String name) {
        Element element = doc.createElement(name);
        root.appendChild(element);
        last = element;
        return element;
    }
    
    //si solo se da el nombre, se da el padre
    public Element newChildLast(String name) {
        Element element = doc.createElement(name);
        last.appendChild(element);
        last = element;
        return element;
    }
    //si se da nombre y valor, se usa como padre el ultimo elemento creado
    public Element newChildLast(String name, String value) {
        Element element = doc.createElement(name);
        last.appendChild(element);
        element.setAttribute("value", value);
        last = element;
        return element;
    }
    
    //añadir un hijo a un nodo especifco
    public Element newChildSP(Element especial, String name) {
        Element element = doc.createElement(name);
        especial.appendChild(element);
        last = element;
        return element;
    }
    
    //añadir un hijo a un nodo especifco, tiene value
    public Element newChildSP(Element especial, String name, String value) {
        Element element = doc.createElement(name);
        especial.appendChild(element);
        element.setAttribute("value", value);
        last = element;
        return element;
    }
    

    
    public void generateXML(DefaultMutableTreeNode tree, String path) throws IOException, TransformerException {
        System.out.println("----------- " +
                           "Generando XML..." +
                           "----------- ");
        
        //procedemos a viajar por el arbol y hacer el xml
        traverseTree(tree, root);
        
        path = path.replace(".tri", ".xml");
        
        writeXml(doc, new FileOutputStream(path));
    }
    
    private void traverseTree(DefaultMutableTreeNode tree, Element father){
       
        if (tree.isLeaf() && tree.toString().equals("Nothing") == false){
            return;
        }


        //para manejar las hojras del arbol(values)
        Boolean hasLeaf = false;
        String leafName = "";

        //iteramos por los hijos a ver si hay una hoja
        Enumeration<TreeNode> children = tree.children();
        while(children.hasMoreElements()){
            TreeNode child = children.nextElement(); 
            if(child.isLeaf()){
                hasLeaf = true;
                leafName = child.toString();
                break;
            }
        }

        String name = tree.toString();
        name = name.replace(" ","");
        Element e;
        

        if(tree.isRoot()){
            e = father;
        }
        else{
            if (hasLeaf && leafName.equals("Nothing") == false ){
            e = newChildSP(father,name,leafName);  
            }
            else{
                e = newChildSP(father,name);
            }
        }
            
        
        


        children = tree.children();
        while(children.hasMoreElements()){
            traverseTree((DefaultMutableTreeNode) children.nextElement(), e);
        }

    
    }
    
    // write doc to output stream
    private static void writeXml(Document doc,
                                 OutputStream output)
            throws TransformerException {

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(output);

        transformer.transform(source, result);
        
        System.out.println("----------- " +
                           "XML Generado!" +
                           "----------- ");

    }
}
