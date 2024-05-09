/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trieulq.Categories;

import java.io.Serializable;

/**
 *
 * @author Lương Quốc Triệu - SE172431
 */
public class CategoriesDTO  implements Serializable{
    private String CategorieID;
    private String CategorieName;
    private String Description;

    public CategoriesDTO() {
    }

    public CategoriesDTO(String CategorieID, String CategorieName, String Description) {
        this.CategorieID = CategorieID;
        this.CategorieName = CategorieName;
        this.Description = Description;
    }

    public String getCategorieID() {
        return CategorieID;
    }

    public void setCategorieID(String CategorieID) {
        this.CategorieID = CategorieID;
    }

    public String getCategorieName() {
        return CategorieName;
    }

    public void setCategorieName(String CategorieName) {
        this.CategorieName = CategorieName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    @Override
    public String toString() {
        return "CategoriesDTO{" + "CategorieID=" + CategorieID + ", CategorieName=" + CategorieName + ", Description=" + Description + '}';
    }
    
    
}
