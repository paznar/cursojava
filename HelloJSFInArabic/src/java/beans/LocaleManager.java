/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class LocaleManager {

    private Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
    private String direction = null; 

    public String getDirection() {
        return direction;
    }


    /*
     * This method is not used but can be useful
     * to identify the current locale
     */
    public Locale getLocale() {
        return locale;
    }

    public String getLanguage() {
        return locale.getLanguage();
    }

    public void setLanguage(String language) {
        locale = new Locale(language);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
        System.out.println(locale);
        if (locale.toString().equalsIgnoreCase("ar")){
            direction="RTL";
             System.out.println("rtl");
        }
        else{
            direction="LTR";
        }
    }

}
