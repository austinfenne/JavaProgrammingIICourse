/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstproject;

import com.itextpdf.text.BaseColor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
 
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
/*
 *
 * @author kimx5154
 */
public class resumeGen {
    
    
    public void makeResume(){
        
      Document document = new Document();
      try
      {
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Template2.pdf"));
        document.open();
        
        PdfPTable table = new PdfPTable(2); // 2 columns.
        table.setWidthPercentage(30); //Width 100%
        table.setSpacingBefore(10f); //Space before table
        table.setSpacingAfter(10f); //Space after table
        
        //Set column widths
        float[] columnWidths = {1f, 1f};
        table.setWidths(columnWidths);
         
        //create name
        Paragraph name = new Paragraph(("Name"));
        name.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(name);
         
        //create city
        PdfPCell city = new PdfPCell (new Paragraph("City"));
        city.setBorderColor(BaseColor.WHITE);
        city.setPadding(10);
        city.setHorizontalAlignment(Element.ALIGN_CENTER);
        city.setVerticalAlignment(Element.ALIGN_MIDDLE);
        
        //create states
        PdfPCell state = new PdfPCell (new Paragraph("State"));
        state.setBorderColor(BaseColor.WHITE);
        state.setPadding(10);
        state.setHorizontalAlignment(Element.ALIGN_CENTER);
        state.setVerticalAlignment(Element.ALIGN_MIDDLE);
        
         
        table.addCell(city);
        table.addCell(state);
        
        document.add(table);
        
        //create Summary
        Paragraph summary = new Paragraph(("Summary"));
        summary.setAlignment(Paragraph.ALIGN_LEFT);
        document.add(summary);
        
        //create WorkEXP
        Paragraph workEXP = new Paragraph(("Work Experience"));
        workEXP.setAlignment(Paragraph.ALIGN_LEFT);
        document.add(workEXP);
        
        //create Education
        Paragraph education = new Paragraph(("Education"));
        education.setAlignment(Paragraph.ALIGN_LEFT);
        document.add(education);
        
        //create AddIno
        Paragraph addInfo = new Paragraph(("Addtional Information"));
        addInfo.setAlignment(Paragraph.ALIGN_LEFT);
        document.add(addInfo);
        
       
        
        document.close();
        writer.close();
      } catch (Exception e)
      {
         e.printStackTrace();
      }
   }
}

