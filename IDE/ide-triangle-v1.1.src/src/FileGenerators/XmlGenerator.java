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
 

public class XmlGenerator {
    
    

    Document doc;
    Element last;
    Element root;
    
    public XmlGenerator() throws ParserConfigurationException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        doc = docBuilder.newDocument();
        
        //hacemos el root
        Element rootElement = doc.createElement("program");
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
    

    
    public void generateXML() throws IOException, TransformerException {
        System.out.println("----------- " +
                           "Generando XML..." +
                           "----------- ");
        // print XML to system console
        writeXml(doc, new FileOutputStream("output.xml"));
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
