/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author miguel
 */
import org.apache.fontbox.util.Charsets;
import org.apache.pdfbox.util.PDFTextStripper;

public class Leer_PDF {
    PDFParser parser;
    String parsedText;
    PDFTextStripper pdfStripper;
    PDDocument pdDoc;
    COSDocument cosDoc;
    PDFDocumentInformation pdDocInfo;
    
    public Leer_PDF() {}
    
    public String pdftoText(String fileName){
    //se verifica q es un archivo
    File f=new File(fileName);
    if(!f.isFile()){
        return null;
    }
    //se verifica si se  puede abrir el TnputStream
    try{
        parser = new PDFParser(new FileInputStream(f));
    } catch (Exception e) {
        System.out.println("No se puede abrir. ");
        return null;
    }
    //En este proceso se abre, convierte y se cierra
    //El archivo PDF
    try{
        parser.parse();
        cosDoc=parser.getDocument();
        pdfStripper = new PDFTextStripper();
        pdDoc = new PDDocument(cosDoc);
        parsedText = pdfStripper.getText(pdDoc);
        cosDoc.close();
        pdDoc.close();
    } catch (Exception e){
        System.out.println("Ocurrio un error. ");
        e.printStackTrace();
        try {
            if (cosDoc != null){
                cosDoc.close();
            }
            if (pdDoc != null){
                pdDoc.close();
            } catch (Exception e1){
                    e.printStackTrace();
              }
            return null;
    } 
    return parsedText ;
   }
    public void main(){
        //se crea una nueva instancia de la clase Leer_PDF
        Leer_PDF pdfTextParserObj = new Leer_PDF();
        //Con el metodo pdftotext se lee y convierte el PDF
        //en el texto simple
        //solo cambie esto parametros ya que la ruta la agarro desde un JINTERNALFRAME Y AL IGUAL LA
        //IMPRIMO EN UN JIXTAEA
        String pdfToText = pdfTextParserObj.pdftoText(ELIGIR_PDF.JL_RUTA.getText() + "");
        ELIGIR_PDF.JTA_SALIDA.append(pdfToText);
        
    }
}
        
        
        
   
