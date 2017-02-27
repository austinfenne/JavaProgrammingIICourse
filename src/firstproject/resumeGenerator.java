
package firstproject;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.awt.Desktop;
import com.itextpdf.text.Document;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPCell;
import java.io.FileOutputStream;
import firstproject.Database;
import java.sql.ResultSet;
import java.util.ArrayList;
 

public class resumeGenerator {
  
    private Database db = new Database();
    private ResultSet rs = null;
    



    void createResume() throws IOException {
        
        
        ProfileData Profile = new ProfileData();
    
        
        
           Document resume = new Document();
        try {
            
            PdfWriter.getInstance(resume, new FileOutputStream("resume.pdf"));
            resume.open();
            LineSeparator line;
            line = new LineSeparator();
            Font f = new Font();
            resume.add( Chunk.NEWLINE );
            String space = "";
            Font font2 = new Font(Font.FontFamily.HELVETICA  , 18, Font.BOLD | Font.UNDERLINE);
            resume.add(new Paragraph("RESUME", font2)); 
            Paragraph name = new Paragraph((String) Profile.getfName()+ " " + Profile.getlName());
            name.setAlignment(Paragraph.ALIGN_LEFT);
            resume.add( name );
            Paragraph email = new Paragraph((String) Profile.getEmail());
            email.setAlignment(Paragraph.ALIGN_RIGHT);
            resume.add(email );
            Paragraph contact = new Paragraph((String) Profile.getCphone());
            contact.setAlignment(Paragraph.ALIGN_RIGHT);
            resume.add(contact);  
            resume.add(Chunk.NEWLINE);
            resume.add(line);
            resume.add(Chunk.NEWLINE);
            
            
       
            Font font1 = new Font(Font.FontFamily.HELVETICA  , 13, Font.BOLD | Font.UNDERLINE);
            resume.add(new Chunk("Summary ", font1));
            resume.add(Chunk.NEWLINE);
            resume.add(Chunk.NEWLINE);
            Paragraph summary;
            summary = new Paragraph((String) Profile.getSummary());
            summary.setIndentationLeft(50);
            resume.add(summary);
            resume.add(Chunk.NEWLINE);
        
            
            resume.add(Chunk.NEWLINE);
            resume.add(new Chunk("Experience ", font1));
            resume.add(Chunk.NEWLINE);
            PdfPTable EXPtable = new PdfPTable(4);
            PdfPCell EXPcell1 = new PdfPCell(new Paragraph("Company"));
            PdfPCell EXPcell2 = new PdfPCell(new Paragraph("Position"));
            PdfPCell EXPcell3 = new PdfPCell(new Paragraph("From-Date"));
            PdfPCell EXPcell4 = new PdfPCell(new Paragraph("End-Date"));
            PdfPCell EXPcell5;
            EXPcell5 = new PdfPCell(new Paragraph((String) Profile.getCompany()));
            resume.add(EXPcell5);
            resume.add(Chunk.NEWLINE);
            PdfPCell EXPcell6 = new PdfPCell(new Paragraph((String) Profile.getPosition()));
            resume.add(EXPcell6);
            PdfPCell EXPcell7;
            EXPcell7 = new PdfPCell(new Paragraph((String) Profile.getFromDate())) ;
            resume.add(EXPcell7);
            PdfPCell EXPcell8;
            EXPcell8 = new PdfPCell(new Paragraph((String) Profile.getEndDate())) ;
            resume.add(EXPcell8);
            
        
          
            
         
            
            
            EXPtable.addCell(EXPcell1);
            EXPtable.addCell(EXPcell2);
            EXPtable.addCell(EXPcell3);
            EXPtable.addCell(EXPcell4);
            EXPtable.addCell(EXPcell5);
            EXPtable.addCell(EXPcell6);
            EXPtable.addCell(EXPcell7);
            EXPtable.addCell(EXPcell8);
           

            resume.add(EXPtable);
            
            resume.add(new Paragraph("Description: "));
            Paragraph Description;
            Description = new Paragraph((String) Profile.getDescription());
            Description.setIndentationLeft(50);
            resume.add(Description);
            resume.add(Chunk.NEWLINE);
              
            
            resume.add(Chunk.NEWLINE);
            
            
      
            resume.add(new Chunk("Qualification ", font1));
            resume.add(Chunk.NEWLINE);
            PdfPTable table = new PdfPTable(3);
            PdfPCell cell1 = new PdfPCell(new Paragraph("College"));
            PdfPCell cell2 = new PdfPCell(new Paragraph("GPA"));
            PdfPCell cell3 = new PdfPCell(new Paragraph("Graduation"));
            PdfPCell cell4;
            cell4 = new PdfPCell(new Paragraph((String) Profile.getSchool()));
            resume.add(cell4);
            resume.add(Chunk.NEWLINE);
            PdfPCell cell5 = new PdfPCell(new Paragraph((String) "4.0"));
            resume.add(cell5);
            PdfPCell cell6;
            cell6 = new PdfPCell(new Paragraph((String) Profile.getGraduation())) ;
            resume.add(cell6);
            

            
            table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);
            table.addCell(cell4);
            table.addCell(cell5);
            table.addCell(cell6);

            resume.add(table);
            resume.add(Chunk.NEWLINE);

 
            
            
            Font font4;
            font4 = new Font(Font.FontFamily.HELVETICA  , 13, Font.BOLD | Font.UNDERLINE);
            resume.add(new Chunk("Skills", font1));
            resume.add(Chunk.NEWLINE);
             resume.add(Chunk.NEWLINE);
             
            ArrayList<String> Skills = new ArrayList<String>();
            Skills = Profile.getSkills();
            String[] ArrSkills = new String[Skills.size()];
            ArrSkills = Skills.toArray(ArrSkills);
           
            for( int i =0; i < Skills.size(); i++) {
            Paragraph name1;
            String SkillPrint = ArrSkills[i];
            name1 = new Paragraph((String) SkillPrint);
            name1.setIndentationLeft(50);
            resume.add(name1);
             resume.add(Chunk.NEWLINE);
            }
            resume.close();
            
        } catch(DocumentException | FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        File file = new File("resume.pdf");
        Desktop.getDesktop().open(file);
        
    }
    
    
    
//        public Map getDetails() {
//        Map details = null;                    //stores values from form
//          
//        
//            
//        String candidateName = name.getText();
//        details.put("Name" , candidateName);
//        
//        String candidateEmail;
//        candidateEmail = email.getText();
//        details.put("Email" , candidateEmail);
//        
//        String schoolX;
//        schoolX = school1.getText();
//        details.put("SchoolX" , schoolX);
//        
//        String percentageX = marks1.getText();
//        details.put("PercentageX" , percentageX);
//        
//        String dateX = dateXField.getText();
//        details.put("Date X" , dateX);
//        
//        String schoolXII = school2.getText();
//        details.put("SchoolXII" , schoolXII);
//        
//        String dateXII = dateXIIField.getText();
//        details.put("Date XII" , dateXII);
//        
//        String percentageXII = marks2.getText();
//        details.put("PercentageXII" , percentageXII);
//        
//        String graduateCollege = college1.getText();
//        details.put("GraduationCollege" , graduateCollege);
//        
//        String graduateUniversity = university1.getText();
//        details.put("GraduateUniversity" , graduateUniversity);
//        
//        String graduationDate = dateCollege1Field.getText();
//        details.put("Graduation date" , graduationDate);
//        
//        String graduateCGPA = cgpa1.getText();
//        details.put("GraduationCGPA", graduateCGPA);
//        
//        String postGraduateCollege = college2.getText();
//        details.put("PostGraduationCollege" , postGraduateCollege);
//        
//        String postGraduateUniversity = university2.getText();
//        details.put("PostGraduateUniversity" , postGraduateUniversity);
//        
//        String postGraduationDate = dateCollege2Field.getText();
//        details.put("Post Graduation date" , postGraduationDate);
//        
//        String postGraduateCGPA = cgpa2.getText();
//        details.put("PostGraduateCGPA", postGraduateCGPA);
//        
//        String contactNo = contactNumber.getText();
//        details.put("ContactNumber" , contactNo);
//        
//        String projectName1 = projectNameField1.getText();
//        String projectDescription1 = projectDescriptionField1.getText();
//        details.put("ProjectName1" , projectName1);
//        details.put("projectDescription1" , projectDescription1);
//        
//        String projectName2 = projectNameField2.getText();
//        String projectDescription2 = projectDescriptionField2.getText();
//        details.put("ProjectName2" , projectName2);
//        details.put("projectDescription2" , projectDescription2);
//        
//        String projectName3 = projectNameField3.getText();
//        String projectDescription3 = projectDescriptionField3.getText();
//        details.put("ProjectName3" , projectName3);
//        details.put("projectDescription3" , projectDescription3);
//        
//        String projectName4 = projectNameField4.getText();
//        String projectDescription4 = projectDescriptionField4.getText();
//        details.put("ProjectName4" , projectName4);
//        details.put("projectDescription4" , projectDescription4);
//        
//        String skills = skillsField.getText();
//        details.put("Skills" , skills);
//        
//        return details;
//    }
}
