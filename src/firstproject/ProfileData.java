/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstproject;

import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class ProfileData {
    private String fName;
    private String lName;
    private String Email;
    private String Hphone;
    private String StreetAddress;
    private String Cphone;
    private String Town;
    private String Province;
    private String Zipcode;
    private String Nation;
    private String Experience;
    private String WWW;
    private String Twitter;
    private String Linkedin;
    
    private String Company[];
    private String Position[];
    private String fromDate[];
    private String endDate[];
    private String Description[];
    
    private String School[];
    private String Study[];
    private String StartDate[];
    private String Graduation[];
    
    
    private Database db = new Database();
    private ResultSet rs = null;

        ProfileData()
        {
            
           try{
            String selectQuery = "SELECT * FROM " + "PersonalInfo" + " where User_ID = " + db.getUser_ID();      
            rs = db.selectStatement(selectQuery);
            try{
                if (rs.next()){
                                
            Database db = new Database();        
                    

                    setfName(rs.getString("firstname"));
                    setlName(rs.getString("lastname"));
                    setEmail(rs.getString("EMAILADDRESS"));
                    setHphone(rs.getString("HPHONE"));
                    setStreetAddress(rs.getString("STREETADDRESS"));
                    setCphone(rs.getString("CPHONE"));
                    setTown(rs.getString("TOWN"));
                    setProvince(rs.getString("PROVINCE"));
                    setZipcode(rs.getString("ZIPCODE"));
                    setNation(rs.getString("NATION"));
                           
               
                    
                }
            }catch (Exception e){
            e.printStackTrace();;
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null,e.getMessage());
            }
                    }catch (Exception e){
            e.printStackTrace();;
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        
                      try{
            String selectQuery = "SELECT * FROM " + "Education" + " where User_ID = " + db.getUser_ID();      
            rs = db.selectStatement(selectQuery);
            try{
                if (rs.next()){
                                
            Database db = new Database();        
                    

                    setfName(rs.getString("SCHOOL"));
                    setlName(rs.getString("STUDY"));
                    setEmail(rs.getString("START_DATE"));
                    setHphone(rs.getString("END_DATE"));
                        
                    
                }
            }catch (Exception e){
            e.printStackTrace();;
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null,e.getMessage());
            }
                    }catch (Exception e){
            e.printStackTrace();;
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
                      
                      
                                 try{
            String selectQuery = "SELECT * FROM " + "WorkExp" + " where User_ID = " + db.getUser_ID();      
            rs = db.selectStatement(selectQuery);
            try{
                if (rs.next()){
                                
            Database db = new Database();        
                    

                    setfName(rs.getString("Company"));
                    setlName(rs.getString("Position"));
                    setEmail(rs.getString("FromDate"));
                    setHphone(rs.getString("EndDate"));
                    setStreetAddress(rs.getString("Description"));
                                            
                }
            }catch (Exception e){
            e.printStackTrace();;
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null,e.getMessage());
            }
                    }catch (Exception e){
            e.printStackTrace();;
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
                                 
                                            try{
            String selectQuery = "SELECT * FROM " + "level" + " where User_ID = " + db.getUser_ID();      
            rs = db.selectStatement(selectQuery);
            try{
                if (rs.next()){
                                
            Database db = new Database();        
                    

                    setExperience(rs.getString("EXPERIENCE"));
                                 
                    
                }
            }catch (Exception e){
            e.printStackTrace();;
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null,e.getMessage());
            }
                    }catch (Exception e){
            e.printStackTrace();;
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
                       try{
            String selectQuery = "SELECT * FROM " + "onlineprecense" + " where User_ID = " + db.getUser_ID();      
            rs = db.selectStatement(selectQuery);
            try{
                if (rs.next()){
                                
            Database db = new Database();        
                    

                    setWWW(rs.getString("WWW"));
                    setTwitter(rs.getString("TWITTER"));
                    setLinkedin(rs.getString("LINKEDIN"));

                           
               
                    
                }
            }catch (Exception e){
            e.printStackTrace();;
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null,e.getMessage());
            }
                    }catch (Exception e){
            e.printStackTrace();;
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
                                            
                                            
        }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getHphone() {
        return Hphone;
    }

    public void setHphone(String Hphone) {
        this.Hphone = Hphone;
    }

    public String getStreetAddress() {
        return StreetAddress;
    }

    public void setStreetAddress(String StreetAddress) {
        this.StreetAddress = StreetAddress;
    }

    public String getCphone() {
        return Cphone;
    }

    public void setCphone(String Cphone) {
        this.Cphone = Cphone;
    }

    public String getTown() {
        return Town;
    }

    public void setTown(String Town) {
        this.Town = Town;
    }

    public String getProvince() {
        return Province;
    }

    public void setProvince(String Province) {
        this.Province = Province;
    }

    public String getZipcode() {
        return Zipcode;
    }
    
    public void setZipcode(String Zipcode) {
        this.Zipcode = Zipcode;
    }

    public String getNation() {
        return Nation;
    }

    public void setNation(String Nation) {
        this.Nation = Nation;
    }

    public String getExperience() {
        return Experience;
    }

    public void setExperience(String Experience) {
        this.Experience = Experience;
    }

    public String getWWW() {
        return WWW;
    }

    public void setWWW(String WWW) {
        this.WWW = WWW;
    }

    public String getTwitter() {
        return Twitter;
    }

    public void setTwitter(String Twitter) {
        this.Twitter = Twitter;
    }

    public String getLinkedin() {
        return Linkedin;
    }

    public void setLinkedin(String Linkedin) {
        this.Linkedin = Linkedin;
    }

    public String[] getCompany() {
        return Company;
    }

    public void setCompany(String[] Company) {
        this.Company = Company;
    }

    public String[] getPosition() {
        return Position;
    }

    public void setPosition(String[] Position) {
        this.Position = Position;
    }

    public String[] getFromDate() {
        return fromDate;
    }

    public void setFromDate(String[] fromDate) {
        this.fromDate = fromDate;
    }


    public String[] getEndDate() {
        return endDate;
    }


    public void setEndDate(String[] endDate) {
        this.endDate = endDate;
    }

    public String[] getDescription() {
        return Description;
    }

    public void setDescription(String[] Description) {
        this.Description = Description;
    }

    public String[] getSchool() {
        return School;
    }

  
    public void setSchool(String[] School) {
        this.School = School;
    }

    public String[] getStudy() {
        return Study;
    }


    public void setStudy(String[] Study) {
        this.Study = Study;
    }


    public String[] getStartDate() {
        return StartDate;
    }


    public void setStartDate(String[] StartDate) {
        this.StartDate = StartDate;
    }


    public String[] getGraduation() {
        return Graduation;
    }


    public void setGraduation(String[] Graduation) {
        this.Graduation = Graduation;
    }


}
