package etsmtl;

import java.io.IOException;
import javax.faces.component.NamingContainer;
import javax.faces.component.UIData;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.context.FacesContext;

/**
 * <pre>
 * Mon backing bean : (son but est d'ajouter a un Composant JSF de la logique métier...)
 * Suivre les convontion définit pour le nomage, ce fichier doit avoir :  (le même nom de mon composant + doit être dans le même packege de ma librery (dossier) de composant composite.)
 * Ajouter la propriéter bending=#{cc.data} dans le composant composite. (qui est représanter dans cette classe par "UIData data")
 * Tamplete de classe : public class backingBean 'extends UIData' et implements NamingContainer
 * Doit implaimenter cette mehode avec le même return "public String getFamily() {return "javax.faces.NamingContainer";}"
 * 
 * Remarque : 
 * Ce backing bean peut être écrit en groovy (si celui-ci est activé sur l’application), ou bien en java Comme actuelement.
 * 
 * Exemple sur le net :
 * http://www.cestpasdur.com/2010/09/23/jsf2-developpement-avance-composant-composite
 * 
 * Code source :
 * https://github.com/dgouyette/jugsummercamp
 * 
 * </pre>
 * @author redouane.billel
 */
public class tableCrud extends UIData implements NamingContainer {

    /**
     * Methode devant être surchargée par le composant 
     * @return 
     */
    @Override
    public String getFamily() { return "javax.faces.NamingContainer"; }
//  private final static Logger LOGGER  = LoggerFactory.getLogger(tableCrud.class);
    private HtmlOutputText psedo;
    private UIData data;  //valeur bindée au composant

    @Override
    public void encodeBegin(FacesContext context) throws IOException {
//        DataModel dataModel = new ListDataModel();

        super.encodeBegin(context);
    }

    public UIData getData() {
        return data;
    }

    public void setData(UIData data) {
        this.data = data;
    }
}
