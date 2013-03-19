package ca.etsmtl.gti525.vente.crud;

import ca.etsmtl.gti525.beans.paiement.PanierBeans;
import ca.etsmtl.gti525.vente.PanierControleur;
import ca.etsmtl.gti525.commun.taglib.TableCrud;
import ca.etsmtl.gti525.entity.presentation.Representation;
import java.io.Serializable;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author REDOUANE
 */
public class TableCrudPanier extends TableCrud<Representation, PanierBeans> implements Serializable {

    private PanierControleur panierControleur;

    public TableCrudPanier(PanierControleur panierControleur) {
        super(new Representation(), new PanierBeans());
        this.panierControleur = panierControleur;
    }

    @Override
    public void doGetAllEnregistrement() {
        this.setColonneTableCrudS(null);
        this.setListEnregistrement( this.panierControleur.getCacheSessionPresentation().getRepresentationSelected() );

        System.out.println("Taille des représantation : "+this.getListEnregistrement().size()+" -------");
        for (Representation rep : this.getListEnregistrement()) {
            //this.getColonneTableCrud().setNomSpectacle( rep.getSpectacle().getNomSpectacle());
            this.getColonneTableCrud().setPrix( rep.getPrix() );
            //this.getColonneTableCrud().setDateRepresentation(rep.getDateDebut());

        }
    }

    @Override
    public void doInsert() {
    }

    @Override
    public void onSelectionerOfEditer(PanierBeans row) {
    }

    @Override
    public void doModif() {
    }

    @Override
    public void onRemouveEnregistrement() {
    }

    @Override
    public void onSelectionerEnregistrement(SelectEvent event) {
    }

    @Override
    public void onDetailsEnregistrement(PanierBeans row) {
    }

    public PanierControleur getPanierControleur() {
        return panierControleur;
    }
}
