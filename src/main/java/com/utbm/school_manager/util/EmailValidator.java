/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utbm.school_manager.util;

import java.util.Map;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author konzinov
 */
@FacesValidator("util.emailValidator")
public class EmailValidator implements Validator{
    private Pattern pattern;
    private static final String EMAIL_PATTERN="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                                                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    
    public EmailValidator(){
        pattern = Pattern.compile(EMAIL_PATTERN);
    }
    
    @Override
    public void validate(FacesContext fc, UIComponent uic, Object value) throws ValidatorException {
        if(value == null){
            return ;
        }
        
         if(!pattern.matcher(value.toString()).matches()) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Validation Error", 
                        value + " is not a valid email;"));
        }
         
    }
    
    public Map<String, Object> getMetadata() {
        return null;
    }
 
    public String getValidatorId() {
        return "util.emailValidator";
    }
     
}
