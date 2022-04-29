package FileGenerators;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;  
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
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
        
        codigo = codigo.replaceAll("(?m)^[ \t]*\r?\n", "");
        codigo = codigo.replace("\t","     ");

        
        BufferedReader txtReader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("template.html")));
        
        String template = "";
        for (String line; (line = txtReader.readLine()) != null;) {
            String newLine = line;
            if (newLine.contains("<pre><code id=\"code\">")){
                System.out.println(codigo);
                newLine = "<pre><code id=\"code\">" + codigo + "</code></pre>";
            }else{
                newLine = unEscapeString(newLine);
            }
                    
            
            template += newLine + "\n";
        }
        

        
        String html = template; //volvemos a convertir lo parseado y editado, en un archivo html
        
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
    
    
    public static String unEscapeString(String s){
    StringBuilder sb = new StringBuilder();
    for (int i=0; i<s.length(); i++)
        switch (s.charAt(i)){
            case '\n': sb.append("\\n"); break;
            case '\t': sb.append("\\t"); break;
            // ... rest of escape characters
            default: sb.append(s.charAt(i));
        }
    return sb.toString();
}
}
