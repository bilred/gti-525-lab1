/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.etsmtl.gti525.dao.presentation;

import ca.etsmtl.gti525.entity.presentation.*;
import java.util.List;

/**
 *
 * @author shonguiz
 */
public class StubPresentation {
    private List<Spectacle> spectacles;
    private List<Representation> representations;
    private List<Artiste> artistes;
    private List<Salle> salles;
    private List<Billet> billets;
    
    public StubPresentation(){
        Artiste art1 = new Artiste();
        Artiste art2 = new Artiste();
        Artiste art3 = new Artiste();
        Artiste art4 = new Artiste();
        Artiste art5 = new Artiste();
        Artiste art6 = new Artiste();
        
        Spectacle spec1 = new Spectacle();
        Spectacle spec2 = new Spectacle();
        Spectacle spec3 = new Spectacle();
        Spectacle spec4 = new Spectacle();
        Spectacle spec5 = new Spectacle();
        Spectacle spec6 = new Spectacle();
        Spectacle spec7 = new Spectacle();
        Spectacle spec8 = new Spectacle();
        Spectacle spec9 = new Spectacle();
        Spectacle spec10 = new Spectacle();
        Spectacle spec11 = new Spectacle();
        Spectacle spec12 = new Spectacle();
        Spectacle spec13 = new Spectacle();
        Spectacle spec14 = new Spectacle();
        Spectacle spec15 = new Spectacle();
        Spectacle spec16 = new Spectacle();
        Spectacle spec17 = new Spectacle();
        Spectacle spec18 = new Spectacle();
        
        art1.setNom("CHRISTOPHER OWENS ");
        art1.setLienPhoto("img_cw_art");
        art1.setDescription("Description1");
        
        art2.setNom("OMAR RODRIGUEZ LOPEZ GROUP ");
        art2.setLienPhoto("img_orlg_art");
        art2.setDescription("Description2");
        
        art3.setNom("JOSH RITTER & THE ROYAL CITY BAND");
        art3.setLienPhoto("img_jr_art");
        art3.setDescription("Description3");
        
        art4.setNom("WAKEY!WAKEY!");
        art4.setLienPhoto("img_ww_art");
        art4.setDescription("Description4");
        
        art5.setNom("REVIVAL");
        art5.setLienPhoto("img_r_art");
        art5.setDescription("Description5");
        
        art6.setNom("THE MACCABEES");
        art6.setLienPhoto("img_tm_art");
        art6.setDescription("Description6");
        
        
        spec1.setNomSpectacle("Tournée Canada 2013");
        spec1.setDescription("Description1");
        spec1.setId(Long.MIN_VALUE);
        spec1.setArtiste(art1);
        
        
        
        spec2.setNomSpectacle("Tournée USA 2013");
        spec2.setDescription("Description2");
        spec2.setId(Long.MIN_VALUE);
        spec2.setArtiste(art1);
        

        spec3.setNomSpectacle("Tournée Europe 2013");
        spec3.setDescription("Description3");
        spec3.setId(Long.MIN_VALUE);
        spec3.setArtiste(art1);
        
        spec4.setNomSpectacle("Tournée Canada 2013");
        spec4.setDescription("Description4");
        spec4.setId(Long.MIN_VALUE);
        spec4.setArtiste(art2);
        
        spec5.setNomSpectacle("Tournée USA 2013");
        spec5.setDescription("Description5");
        spec5.setId(Long.MIN_VALUE);
        spec5.setArtiste(art2);
        
        spec6.setNomSpectacle("Tournée Europe 2013");
        spec6.setDescription("Description6");
        spec6.setId(Long.MIN_VALUE);
        spec6.setArtiste(art2);
        
        spec7.setNomSpectacle("Tournée Canada 2013");
        spec7.setDescription("Description7");
        spec7.setId(Long.MIN_VALUE);
        spec7.setArtiste(art3);
        
        spec8.setNomSpectacle("Tournée USA 2013");
        spec8.setDescription("Description8");
        spec8.setId(Long.MIN_VALUE);
        spec8.setArtiste(art3);
        
        spec9.setNomSpectacle("Tournée Europe 2013");
        spec9.setDescription("Description9");
        spec9.setId(Long.MIN_VALUE);
        spec9.setArtiste(art3);
        
        spec10.setNomSpectacle("Tournée Canada 2013");
        spec10.setDescription("Description10");
        spec10.setId(Long.MIN_VALUE);
        spec10.setArtiste(art4);
        
        spec11.setNomSpectacle("Tournée USA 2013");
        spec11.setDescription("Description11");
        spec11.setId(Long.MIN_VALUE);
        spec11.setArtiste(art4);
        
        spec12.setNomSpectacle("Tournée Europe 2013");
        spec12.setDescription("Description12");
        spec12.setId(Long.MIN_VALUE);
        spec12.setArtiste(art4);
        
        spec13.setNomSpectacle("Tournée Canada 2013");
        spec13.setDescription("Description13");
        spec13.setId(Long.MIN_VALUE);
        spec13.setArtiste(art5);
        
        spec14.setNomSpectacle("Tournée USA 2013");
        spec14.setDescription("Description14");
        spec14.setId(Long.MIN_VALUE);
        spec14.setArtiste(art5);
        
        spec15.setNomSpectacle("Tournée Europe 2013");
        spec15.setDescription("Description15");
        spec15.setId(Long.MIN_VALUE);
        spec15.setArtiste(art5);
        
        spec16.setNomSpectacle("Tournée Canada 2013");
        spec16.setDescription("Description16");
        spec16.setId(Long.MIN_VALUE);
        spec16.setArtiste(art6);
        
        spec17.setNomSpectacle("Tournée USA 2013");
        spec17.setDescription("Description17");
        spec17.setId(Long.MIN_VALUE);
        spec17.setArtiste(art6);
        
        spec18.setNomSpectacle("Tournée Europe 2013");
        spec18.setDescription("Description18");
        spec18.setId(Long.MIN_VALUE);
        spec18.setArtiste(art6);
        
    }
}