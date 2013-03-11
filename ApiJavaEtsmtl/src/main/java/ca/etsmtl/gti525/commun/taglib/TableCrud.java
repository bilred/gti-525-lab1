package ca.etsmtl.gti525.commun.taglib;

import java.util.ArrayList;
import java.util.List;
import org.primefaces.event.SelectEvent;

/**
 * IHM Table CRUD (1-LISTER, 2-INSERTE, 3-UPDATE, 4-REMOVE) Option: 4-SELECTION <br/>
 * Chaque méthode et observe un évènement dans l'IHM <br/>
 * <br/>
 * 1- void doGetAllEnregistrement(); <br/>
 * 2- void doInsert(); <br/>
 * 3- void onSelectionerOfEditer(TypeColonne row); <br/>
 * 4- void doModif(); <br/>
 * 5- void onDetailsEnregistrement(TypeColonne row); <br/>
 * 6- void onDetailsEnregistrement(TypeColonne row) <br/>
 * 7- void onSelectionerEnregistrement(SelectEvent event); <br/>
 * <br/>
 * @param <Type> 
 * @param <TypeColonne> 
 * @author B.REDOUANE
 */
public abstract class TableCrud<Type, TypeColonne> {
   
    private List<Type> listEnregistrement;  //Affichage All Enregistrement
    private List<TypeColonne> colonneTableCrudS;
    private TypeColonne colonneTableCrud;   //Utliser pour la gestion l'action "Add"
    
    private Type actionOnEdit;              //Utliser comme tmp pour la gestion l'action "Modf"
    private Type actionOnDetails;           //Utliser comme tmp pour la gestion l'action "Details"
    private TypeColonne actionDelete;       //Utliser comme tmp pour la gestion l'action "Supp"
    private TypeColonne selectedOnAction;   //Utliser comme tmp pour la gestion l'action "Select Ligne"
    
    private Type selectedRadioButton;     //pour les RadioButton Based Selection 
    private Type[] selectedsCheckbox;  //pour les Checkbox Based Selection 
    
    /**
     * initialisation avec le bon "new Class"
     * @param entiryClass 
     * @param colonneTableCrud 
     */
    public TableCrud(Type entiryClass, TypeColonne colonneTableCrud) {
        this.colonneTableCrudS = new ArrayList<TypeColonne>(); //colonneTableCrudS;
        this.colonneTableCrud = colonneTableCrud;
        
        this.selectedOnAction = colonneTableCrud;
        this.actionDelete = colonneTableCrud;
        
        this.actionOnEdit = entiryClass;
        this.actionOnDetails = entiryClass;
        
        this.selectedRadioButton = entiryClass;
//        this.selectedsCheckbox = (Type[]) new ArrayList<Type>().toArray(); //Array.newInstance(Class.forName(className), size);
    }

    /**
     * Ecoute le bouton Actueliser
     */
    public abstract void doGetAllEnregistrement(); //throws ExeptionFindAll; //@Interceptors(BusinessExeptionInterceptor.class)
    /**
     * Ecoute le bouton Ajouter
     */
    public abstract void doInsert(); //throws ExceptionAdd;    
    /**
     * Ecoute l'evenement onEditeListner (bouton modifier dans la pageCrud),  pageModif?faces-redirect=true 
     * @param row
     */
    public abstract void onSelectionerOfEditer(TypeColonne row);// throws ExeptionUpdate;
    /**
     * Ecoute bouton validé la modification dans la pageModif
     */    
    public abstract void doModif();// throws ExeptionUpdate;  
    /**
     * Ecoute le bouton Supprimer
     */
    public abstract void onRemouveEnregistrement();// throws ExeptionDelete;
    /**
     * Ecoute l'evenement onSelectListner (choix d'une ligne sur la DataTable)
     * @param event
     */    
    public abstract void onSelectionerEnregistrement(SelectEvent event);// throws ExceptionOnSelect;
    /**
     * @param row 
     */
    public abstract void onDetailsEnregistrement(TypeColonne row);// throws ExceptionDetail;
   
//    public abstract void onEditerEnregistrement(RowEditEvent event); //Boutton Stilo direct modif sur ihm
    
    
    
    /* **************Getter Setter******************* */
    public List<Type> getListEnregistrement() {
        if(listEnregistrement==null) listEnregistrement = new ArrayList<Type>();
        return listEnregistrement;
    }

    public void setListEnregistrement(List<Type> listEnregistrement) {
        if(listEnregistrement==null) listEnregistrement = new ArrayList<Type>();
        this.listEnregistrement = listEnregistrement;
    }

    public TypeColonne getColonneTableCrud() {
        return colonneTableCrud;
    }

    public void setColonneTableCrud(TypeColonne colonneTableCrud) {
        this.colonneTableCrud = colonneTableCrud;
    }

    public List<TypeColonne> getColonneTableCrudS() {
        if(colonneTableCrudS==null) colonneTableCrudS = new ArrayList<TypeColonne>();
        return colonneTableCrudS;
    }

    public void setColonneTableCrudS(List<TypeColonne> colonneTableCrudS) {
        if(colonneTableCrudS==null) colonneTableCrudS = new ArrayList<TypeColonne>();
        this.colonneTableCrudS = colonneTableCrudS;
    }
    
    public TypeColonne getSelectedOnAction() {
        return selectedOnAction;
    }

    public void setSelectedOnAction(TypeColonne selectedOnAction) {
        this.selectedOnAction = selectedOnAction;
    }
    
    public Type getActionOnEdit() {
        return actionOnEdit;
    }

    public void setActionOnEdit(Type actionOnEdit) {
        this.actionOnEdit = actionOnEdit;
    }
    
    public Type getActionOnDetails() {
        return actionOnDetails;
    }

    public void setActionOnDetails(Type actionOnDetails) {
        this.actionOnDetails = actionOnDetails;
    }
    
    public TypeColonne getActionDelete() {
        return actionDelete;
    }

    public void setActionDelete(TypeColonne actionDelete) {
        this.actionDelete = actionDelete;
    }

    public Type getSelectedRadioButton() {
        return selectedRadioButton;
    }

    public void setSelectedRadioButton(Type selectedRadioButton) {
        this.selectedRadioButton = selectedRadioButton;
    }

    public Type[] getSelectedsCheckbox() {
        return selectedsCheckbox;
    }

    public void setSelectedsCheckbox(Type[] selectedsCheckbox) {
        this.selectedsCheckbox = selectedsCheckbox;
    }
       
}