package FileGenerators;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;  
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import org.jsoup.Jsoup;  
import org.jsoup.nodes.Document;  
import org.jsoup.nodes.Element;

/*---------------------------------------------------------------
****************************************************************
* Generador de HTML
* Editores: Oswaldo Ramirez
****************************************************************/
public class HtmlGenerator {
    
    //generamos el HTML
    public void generateHTML(String path)  throws IOException {
        System.out.println("----------- " +
                           "Generando HTML..." +
                           "----------- ");
        
        Path filePath = Path.of(path);
        String codigo = Files.readString(filePath);
        

        File input = new File("template.html"); //cargamos la plantilla
        Document doc = Jsoup.parse(input, "UTF-8", ""); //lo parseamos para poderlo editar
        Element code = doc.select("code").first(); //buscamos el elemento codigo
        code.text(codigo); //colocamos el texto del codigo dentro del elemento
        
        String html = doc.html(); //volvemos a convertir lo parseado y editado, en un archivo html
        
        writeHTML(html,path);
       
    }
    
    private void writeHTML(String html, String path) throws IOException{
        
        BufferedWriter htmlWriter =
                new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path.replace(".tri", ".html")), "UTF-8")); //creamos el archivo
        htmlWriter.write(html); //escribimos al archivo
        htmlWriter.close();
        
        System.out.println("----------- " +
                           "HTML Generado!" +
                           "----------- ");
    }
}
