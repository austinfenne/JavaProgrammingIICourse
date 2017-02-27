package firstproject;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChangePage
{
 
    private String file;
    
    public void nextPage(ActionEvent e, int pgNum) throws IOException
    {
        switch (pgNum)
        {
            case 6:
               file = "FXMLPersonalInfo";
               setFile(file);
               gotoPage(e,file);
                break;
            case 1: //Personal Info
                file = "FXMLOnlinePrecense";
                setFile(file);
                gotoPage(e, file);
                break;
            case 2: //Online Presence
                file = "FXMLExperienceLevel";
                setFile(file);
                gotoPage(e, file);
                break;
            case 3: //Experience Level
                file = "FXMLExperience";
                setFile(file);
                gotoPage(e, file);
                break;
            case 4: //Experience
                file = "FXMLEducation";
                setFile(file);
                gotoPage(e, file);
                break;
            case 5: //Education
                file = "FXMLSummary";
                setFile(file);
                gotoPage(e, file);
                break;
            case 7: // Summary
                file = "FXMLAdditionalSkills";
                setFile(file);
                gotoPage(e,file);
                break;
            case 8: // Skills
                file = "FXMLTemplateSelection";
                setFile(file);
                gotoPage(e,file);
                break;
   
        }
    }
    
    public void prevPage(ActionEvent e, int pgNum) throws IOException
    {
        switch (pgNum)
        {
            case 1: //Personal Info
                file = "FXMLPersonalInfo";
                setFile(file);
                gotoPage(e, file);
                break;
            case 2: //Online Presence
                file = "FXMLPersonalInfo";
                setFile(file);
                gotoPage(e, file);
                break;
            case 3: //Experience Level
                file = "FXMLOnlinePrecense";
                setFile(file);
                gotoPage(e, file);
                break;
            case 4: //Experience
                file = "FXMLExperienceLevel";
                setFile(file);
                gotoPage(e, file);
                break;
            case 5: //Education
                file = "FXMLExperience";
                setFile(file);
                gotoPage(e, file);
                break;
        }
    }
    
    public void setFile(String file)
    {
        this.file = file;
    }
    
    public String getFile(String file)
    {
        return file;
    }
    
    public void gotoPage(ActionEvent e, String file) throws IOException
    {
           Parent home_page_parent = FXMLLoader.load(getClass().getResource(getFile(file) + ".fxml"));
           Scene home_page_scene = new Scene(home_page_parent);
           Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
           
           String css = FirstProject.class.getResource("format.css").toExternalForm();
           home_page_scene.getStylesheets().add(css);
           
           app_stage.setScene(home_page_scene);
           app_stage.show();
    }
    
}
