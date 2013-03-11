package ca.etsmtl.gti525.commun;

/**
 *  En peu faire du Polymorphisme (injecter du code en plus de l'existant)
 * @author REDOUANE
 */
public abstract class AbstractControleur extends InitDao{
    
    //@Ingection couche model et métier
      //Fait dans InitDAO
    

    
    @Override
    public void initPresentation() {
        super.initPresentation();
        //this.daoPresentation;
    }

    @Override
    public void initVante() {
        super.initVante();
    }

    @Override
    public void initStubsPresentation() {
        super.initStubsPresentation();
        //InitDao.stubsDaoPresentation
    }

    @Override
    public void initStubsVante() {
        super.initStubsVante();
    }   
    
}
