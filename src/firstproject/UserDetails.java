package firstproject;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class UserDetails {

    private final StringProperty skill;
   
    //Default constructor
    public UserDetails(String skill) {
        this.skill = new SimpleStringProperty(skill);

    }

    //Getters
    public String getSkill() {
        return skill.get();
    }

  

    //Setters
    public void setSkill(String value) {
        skill.set(value);
    }

   

    //Property values
    public StringProperty skillProperty() {
        return skill;
    }


}