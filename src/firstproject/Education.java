/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstproject;

import java.time.LocalDate;

/**
 *
 * @author rondo017
 */
public class Education {
    private String school;
    private String study;
    private LocalDate startDate;
    private LocalDate endDate;
    
    public Education (String school, String study, LocalDate startDate, LocalDate endDate)
    {
        this.school = school;
        this.study = study;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    public Education (String school, String study)
    {
        this.school = school;
        this.study = study;
    }
    
    public void setSchool(String school)
    {
//        if (school == "")
//            throw new IllegalArgumentException("No School Entered");
        this.school = school;
        
    }
    
    public String getSchool()
    {
        return school;
    }
    
    public void setStudy (String study)
    {
//        if (study == "")
//            throw new IllegalArgumentException("No Field of Study Entered");
        this.study = study;
        
    }
    
    public String getStudy()
    {
        return study;
    }
    
    public void setStartDate (LocalDate startDate)
    {
        this.startDate = startDate;
        
    }
    
    public LocalDate getStartDate ()
    {
        return startDate;
    }
    
    public void setEndDate (LocalDate endDate)
    {
        this.endDate = endDate;
        
    }
    
    public LocalDate getEndDate ()
    {
        return endDate;   
    }
    

}
