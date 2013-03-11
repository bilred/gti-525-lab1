/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.etsmtl.gti525.dao.presentation;

import ca.etsmtl.gti525.entity.presentation.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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
        
        // Début Séquence instaciation
        
        Artiste art1 = new Artiste();
        Artiste art2 = new Artiste();
        Artiste art3 = new Artiste();
        Artiste art4 = new Artiste();
        Artiste art5 = new Artiste();
        Artiste art6 = new Artiste();
        
        Salle sal1 = new Salle();
        Salle sal2 = new Salle();
        Salle sal3 = new Salle();
        Salle sal4 = new Salle();
        Salle sal5 = new Salle();
        Salle sal6 = new Salle();
        Salle sal7 = new Salle();
        Salle sal8 = new Salle();
        Salle sal9 = new Salle();
        
        Representation rep1 = new Representation ();
        Representation rep2 = new Representation ();
        Representation rep3 = new Representation ();
        Representation rep4 = new Representation ();
        Representation rep5 = new Representation ();
        Representation rep6 = new Representation ();
        Representation rep7 = new Representation ();
        Representation rep8 = new Representation ();
        Representation rep9 = new Representation ();
        Representation rep10 = new Representation ();
        Representation rep11 = new Representation ();
        Representation rep12 = new Representation ();
        Representation rep13 = new Representation ();
        Representation rep14 = new Representation ();
        Representation rep15 = new Representation ();
        Representation rep16 = new Representation ();
        Representation rep17 = new Representation ();
        Representation rep18 = new Representation ();
        Representation rep19 = new Representation ();
        Representation rep20 = new Representation ();
        Representation rep21 = new Representation ();
        Representation rep22 = new Representation ();
        Representation rep23 = new Representation ();
        Representation rep24 = new Representation ();
        Representation rep25 = new Representation ();
        Representation rep26 = new Representation ();
        Representation rep27 = new Representation ();
        Representation rep28 = new Representation ();
        Representation rep29 = new Representation ();
        Representation rep30 = new Representation ();
        Representation rep31 = new Representation ();
        Representation rep32 = new Representation ();
        Representation rep33 = new Representation ();
        Representation rep34 = new Representation ();
        Representation rep35 = new Representation ();
        Representation rep36 = new Representation ();
        Representation rep37 = new Representation ();
        Representation rep38 = new Representation ();
        Representation rep39 = new Representation ();
        Representation rep40 = new Representation ();
        Representation rep41 = new Representation ();
        Representation rep42 = new Representation ();
        Representation rep43 = new Representation ();
        Representation rep44 = new Representation ();
        Representation rep45 = new Representation ();
        Representation rep46 = new Representation ();
        Representation rep47 = new Representation ();
        Representation rep48 = new Representation ();
        Representation rep49 = new Representation ();
        Representation rep50 = new Representation ();
        Representation rep51 = new Representation ();
        Representation rep52 = new Representation ();
        Representation rep53 = new Representation ();
        Representation rep54 = new Representation ();
        
        
        
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
        
        //fin séquence initiation
        
        //début séquence de passation des paramètres, on ne peut pas passer par les constructeurs paramétrés car ils sont interdits dans les beans,
        //l'instanciation pourrait etre optimisée par le biais de tableaux ou de hashmaps et certaines valeurs devront etre changées, Mohammed pourrait s'en occuper.
        
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
        
        
        sal1.setNom("Centre Bell");
        sal1.setAdresseSalle("Montréal");
        sal1.setNbPlace(30000);
        
        sal2.setNom("Ontario Hall");
        sal2.setAdresseSalle("Ontario");
        sal2.setNbPlace(30000);
        
        sal3.setNom("Vancouver Mega-Center");
        sal3.setAdresseSalle("Vancouver");
        sal3.setNbPlace(30000);
        
        sal4.setNom("The World");
        sal4.setAdresseSalle("New York");
        sal1.setNbPlace(60000);
        
        sal5.setNom("Capitol");
        sal5.setAdresseSalle("Washington");
        sal1.setNbPlace(30000);
        
        sal6.setNom("The Heaven");
        sal6.setAdresseSalle("San Fransisco");
        sal1.setNbPlace(40000);
        
        sal7.setNom("Zenith");
        sal7.setAdresseSalle("Paris");
        sal1.setNbPlace(60000);
        
        sal8.setNom("Berghain");
        sal8.setAdresseSalle("Berlin");
        sal1.setNbPlace(5000);
        
        sal9.setNom("Opera");
        sal1.setNbPlace(30000);
        sal9.setAdresseSalle("Mouscou");
        
        
        rep1.setId(Long.MIN_VALUE);
        rep1.setPrix(60F);
        rep1.setDateDebut(new Date());
        rep1.setSalle(sal1);
        representations.add(rep1);
        
        rep2.setId(Long.MIN_VALUE);
        rep2.setPrix(60F);
        rep2.setDateDebut(new Date());
        rep2.setSalle(sal2);
        representations.add(rep2);
        
        
        rep3.setId(Long.MIN_VALUE);
        rep3.setPrix(60F);
        rep3.setDateDebut(new Date());
        rep3.setSalle(sal3);
        representations.add(rep3);
        
        rep4.setId(Long.MIN_VALUE);
        rep4.setPrix(60F);
        rep4.setDateDebut(new Date());
        rep4.setSalle(sal4);
        representations.add(rep4);
        
        rep5.setId(Long.MIN_VALUE);
        rep5.setPrix(60F);
        rep5.setDateDebut(new Date());
        rep5.setSalle(sal5);
        representations.add(rep5);
        
        rep6.setId(Long.MIN_VALUE);
        rep6.setPrix(60F);
        rep6.setDateDebut(new Date());
        rep6.setSalle(sal6);
        representations.add(rep6);
        
        rep7.setId(Long.MIN_VALUE);
        rep7.setPrix(60F);
        rep7.setDateDebut(new Date());
        rep7.setSalle(sal7);
        representations.add(rep7);
        
        rep8.setId(Long.MIN_VALUE);
        rep8.setPrix(60F);
        rep8.setDateDebut(new Date());
        rep8.setSalle(sal8);
        representations.add(rep8);
        
        rep9.setId(Long.MIN_VALUE);
        rep9.setPrix(60F);
        rep9.setDateDebut(new Date());
        rep9.setSalle(sal9);
        representations.add(rep9);
        
        rep10.setId(Long.MIN_VALUE);
        rep10.setPrix(60F);
        rep10.setDateDebut(new Date());
        rep10.setSalle(sal1);
        representations.add(rep10);
        
        rep11.setId(Long.MIN_VALUE);
        rep11.setPrix(60F);
        rep11.setDateDebut(new Date());
        rep11.setSalle(sal2);
        representations.add(rep11);
        
        rep12.setId(Long.MIN_VALUE);
        rep12.setPrix(60F);
        rep12.setDateDebut(new Date());
        rep12.setSalle(sal3);
        representations.add(rep12);
        
        rep13.setId(Long.MIN_VALUE);
        rep13.setPrix(60F);
        rep13.setDateDebut(new Date());
        rep13.setSalle(sal4);
        representations.add(rep13);
        
        rep14.setId(Long.MIN_VALUE);
        rep14.setPrix(60F);
        rep14.setDateDebut(new Date());
        rep14.setSalle(sal5);
        representations.add(rep14);
        
        rep15.setId(Long.MIN_VALUE);
        rep15.setPrix(60F);
        rep15.setDateDebut(new Date());
        rep15.setSalle(sal6);
        representations.add(rep15);
        
        rep16.setId(Long.MIN_VALUE);
        rep16.setPrix(60F);
        rep16.setDateDebut(new Date());
        rep16.setSalle(sal7);
        representations.add(rep16);
        
        rep17.setId(Long.MIN_VALUE);
        rep17.setPrix(60F);
        rep17.setDateDebut(new Date());
        rep17.setSalle(sal8);
        representations.add(rep17);
        
        rep18.setId(Long.MIN_VALUE);
        rep18.setPrix(60F);
        rep18.setDateDebut(new Date());
        rep18.setSalle(sal9);
        representations.add(rep18);
        
        rep19.setId(Long.MIN_VALUE);
        rep19.setPrix(60F);
        rep19.setDateDebut(new Date());
        rep19.setSalle(sal1);
        representations.add(rep19);
        
        rep20.setId(Long.MIN_VALUE);
        rep20.setPrix(60F);
        rep20.setDateDebut(new Date());
        rep20.setSalle(sal2);
        representations.add(rep20);
        
        rep21.setId(Long.MIN_VALUE);
        rep21.setPrix(60F);
        rep21.setDateDebut(new Date());
        rep21.setSalle(sal3);
        representations.add(rep21);
        
        rep22.setId(Long.MIN_VALUE);
        rep22.setPrix(60F);
        rep22.setDateDebut(new Date());
        rep22.setSalle(sal4);
        representations.add(rep22);
        
        rep23.setId(Long.MIN_VALUE);
        rep23.setPrix(60F);
        rep23.setDateDebut(new Date());
        rep23.setSalle(sal5);
        representations.add(rep23);
        
        rep24.setId(Long.MIN_VALUE);
        rep24.setPrix(60F);
        rep24.setDateDebut(new Date());
        rep25.setSalle(sal6);
        representations.add(rep24);
        
        rep25.setId(Long.MIN_VALUE);
        rep25.setPrix(60F);
        rep25.setDateDebut(new Date());
        rep25.setSalle(sal7);
        representations.add(rep25);
        
        rep26.setId(Long.MIN_VALUE);
        rep26.setPrix(60F);
        rep26.setDateDebut(new Date());
        rep26.setSalle(sal8);
        representations.add(rep26);
        
        rep27.setId(Long.MIN_VALUE);
        rep27.setPrix(60F);
        rep27.setDateDebut(new Date());
        rep27.setSalle(sal9);
        representations.add(rep27);
        
        rep28.setId(Long.MIN_VALUE);
        rep28.setPrix(60F);
        rep28.setDateDebut(new Date());
        rep1.setSalle(sal1);
        representations.add(rep28);
        
        rep29.setId(Long.MIN_VALUE);
        rep29.setPrix(60F);
        rep29.setDateDebut(new Date());
        rep29.setSalle(sal2);
        representations.add(rep29);
        
        rep30.setId(Long.MIN_VALUE);
        rep30.setPrix(60F);
        rep30.setDateDebut(new Date());
        rep30.setSalle(sal3);
        representations.add(rep30);
        
        rep31.setId(Long.MIN_VALUE);
        rep31.setPrix(60F);
        rep31.setDateDebut(new Date());
        rep31.setSalle(sal4);
        representations.add(rep31);
        
        rep32.setId(Long.MIN_VALUE);
        rep32.setPrix(60F);
        rep32.setDateDebut(new Date());
        rep32.setSalle(sal5);
        representations.add(rep32);
        
        rep33.setId(Long.MIN_VALUE);
        rep33.setPrix(60F);
        rep33.setDateDebut(new Date());
        rep33.setSalle(sal6);
        representations.add(rep33);
        
        rep34.setId(Long.MIN_VALUE);
        rep34.setPrix(60F);
        rep34.setDateDebut(new Date());
        rep35.setSalle(sal7);
        representations.add(rep34);
        
        rep35.setId(Long.MIN_VALUE);
        rep35.setPrix(60F);
        rep35.setDateDebut(new Date());
        rep35.setSalle(sal8);
        representations.add(rep35);
        
        rep36.setId(Long.MIN_VALUE);
        rep36.setPrix(60F);
        rep36.setDateDebut(new Date());
        rep36.setSalle(sal9);
        representations.add(rep36);
        
        rep37.setId(Long.MIN_VALUE);
        rep37.setPrix(60F);
        rep37.setDateDebut(new Date());
        rep37.setSalle(sal1);
        representations.add(rep37);
        
        rep38.setId(Long.MIN_VALUE);
        rep38.setPrix(60F);
        rep38.setDateDebut(new Date());
        rep38.setSalle(sal2);
        representations.add(rep38);
        
        rep39.setId(Long.MIN_VALUE);
        rep39.setPrix(60F);
        rep39.setDateDebut(new Date());
        rep39.setSalle(sal3);
        representations.add(rep39);
        
        rep40.setId(Long.MIN_VALUE);
        rep40.setPrix(60F);
        rep40.setDateDebut(new Date());
        rep40.setSalle(sal4);
        representations.add(rep40);
        
        rep41.setId(Long.MIN_VALUE);
        rep41.setPrix(60F);
        rep41.setDateDebut(new Date());
        rep41.setSalle(sal5);
        representations.add(rep41);
        
        rep42.setId(Long.MIN_VALUE);
        rep42.setPrix(60F);
        rep42.setDateDebut(new Date());
        rep42.setSalle(sal6);
        representations.add(rep42);
        
        rep43.setId(Long.MIN_VALUE);
        rep43.setPrix(60F);
        rep43.setDateDebut(new Date());
        rep43.setSalle(sal7);
        representations.add(rep43);
        
        rep44.setId(Long.MIN_VALUE);
        rep44.setPrix(60F);
        rep44.setDateDebut(new Date());
        rep44.setSalle(sal8);
        representations.add(rep44);
        
        rep45.setId(Long.MIN_VALUE);
        rep45.setPrix(60F);
        rep45.setDateDebut(new Date());
        rep45.setSalle(sal9);
        representations.add(rep45);
        
        rep46.setId(Long.MIN_VALUE);
        rep46.setPrix(60F);
        rep46.setDateDebut(new Date());
        rep46.setSalle(sal1);
        representations.add(rep46);
        
        rep47.setId(Long.MIN_VALUE);
        rep47.setPrix(60F);
        rep47.setDateDebut(new Date());
        rep47.setSalle(sal2);
        representations.add(rep47);
        
        rep48.setId(Long.MIN_VALUE);
        rep48.setPrix(60F);
        rep48.setDateDebut(new Date());
        rep48.setSalle(sal3);
        representations.add(rep48);
        
        rep49.setId(Long.MIN_VALUE);
        rep49.setPrix(60F);
        rep49.setDateDebut(new Date());
        rep49.setSalle(sal4);
        representations.add(rep49);
        
        rep50.setId(Long.MIN_VALUE);
        rep50.setPrix(60F);
        rep50.setDateDebut(new Date());
        rep50.setSalle(sal5);
        representations.add(rep50);
        
        rep51.setId(Long.MIN_VALUE);
        rep51.setPrix(60F);
        rep51.setDateDebut(new Date());
        rep51.setSalle(sal6);
        representations.add(rep51);
        
        rep52.setId(Long.MIN_VALUE);
        rep52.setPrix(60F);
        rep52.setDateDebut(new Date());
        rep52.setSalle(sal7);
        representations.add(rep52);
        
        rep53.setId(Long.MIN_VALUE);
        rep53.setPrix(60F);
        rep53.setDateDebut(new Date());
        rep53.setSalle(sal8);
        representations.add(rep53);
        
        rep54.setId(Long.MIN_VALUE);
        rep54.setPrix(60F);
        rep54.setDateDebut(new Date());
        rep54.setSalle(sal9);
        representations.add(rep54);
     
        
        spec1.setNomSpectacle("Tournée Canada 2013");
        spec1.setDescription("Description1");
        spec1.setId(Long.MIN_VALUE);
        spec1.setArtiste(art1);
        List<Representation> sousListe1 = new ArrayList<Representation>();
        for (int i =0; i<3; i++){
            sousListe1.add(representations.get(i));
                }
        spec1.setRepresentations(sousListe1);
                
                        
        spec2.setNomSpectacle("Tournée USA 2013");
        spec2.setDescription("Description2");
        spec2.setId(Long.MIN_VALUE);
        spec2.setArtiste(art1);
        List<Representation> sousListe2 = new ArrayList<Representation>();
        for (int i =3; i<6; i++){
            sousListe2.add(representations.get(i));
                }
        spec2.setRepresentations(sousListe2);
        
        spec3.setNomSpectacle("Tournée Europe 2013");
        spec3.setDescription("Description3");
        spec3.setId(Long.MIN_VALUE);
        spec3.setArtiste(art1);
        List<Representation> sousListe3 = new ArrayList<Representation>();
        for (int i =6; i<9; i++){
            sousListe3.add(representations.get(i));
                }
        spec3.setRepresentations(sousListe3);
        
        spec4.setNomSpectacle("Tournée Canada 2013");
        spec4.setDescription("Description4");
        spec4.setId(Long.MIN_VALUE);
        spec4.setArtiste(art2);
        List<Representation> sousListe4 = new ArrayList<Representation>();
        for (int i =9; i<12; i++){
            sousListe4.add(representations.get(i));
                }
        spec4.setRepresentations(sousListe4);
        
        spec5.setNomSpectacle("Tournée USA 2013");
        spec5.setDescription("Description5");
        spec5.setId(Long.MIN_VALUE);
        spec5.setArtiste(art2);
        List<Representation> sousListe5 = new ArrayList<Representation>();
        for (int i =12; i<15; i++){
            sousListe5.add(representations.get(i));
                }
        spec5.setRepresentations(sousListe5);
        
        spec6.setNomSpectacle("Tournée Europe 2013");
        spec6.setDescription("Description6");
        spec6.setId(Long.MIN_VALUE);
        spec6.setArtiste(art2);
        List<Representation> sousListe6 = new ArrayList<Representation>();
        for (int i =15; i<18; i++){
            sousListe6.add(representations.get(i));
                }
        spec6.setRepresentations(sousListe6);
        
        spec7.setNomSpectacle("Tournée Canada 2013");
        spec7.setDescription("Description7");
        spec7.setId(Long.MIN_VALUE);
        spec7.setArtiste(art3);
        List<Representation> sousListe7 = new ArrayList<Representation>();
        for (int i =18; i<21; i++){
            sousListe7.add(representations.get(i));
                }
        spec7.setRepresentations(sousListe7);
        
        spec8.setNomSpectacle("Tournée USA 2013");
        spec8.setDescription("Description8");
        spec8.setId(Long.MIN_VALUE);
        spec8.setArtiste(art3);
        List<Representation> sousListe8 = new ArrayList<Representation>();
        for (int i =21; i<24; i++){
            sousListe8.add(representations.get(i));
                }
        spec8.setRepresentations(sousListe8);
        
        spec9.setNomSpectacle("Tournée Europe 2013");
        spec9.setDescription("Description9");
        spec9.setId(Long.MIN_VALUE);
        spec9.setArtiste(art3);
        List<Representation> sousListe9 = new ArrayList<Representation>();
        for (int i =24; i<27; i++){
            sousListe9.add(representations.get(i));
                }
        spec9.setRepresentations(sousListe9);
        
        spec10.setNomSpectacle("Tournée Canada 2013");
        spec10.setDescription("Description10");
        spec10.setId(Long.MIN_VALUE);
        spec10.setArtiste(art4);
        List<Representation> sousListe10 = new ArrayList<Representation>();
        for (int i =27; i<30; i++){
            sousListe10.add(representations.get(i));
                }
        spec10.setRepresentations(sousListe10);
        
        spec11.setNomSpectacle("Tournée USA 2013");
        spec11.setDescription("Description11");
        spec11.setId(Long.MIN_VALUE);
        spec11.setArtiste(art4);
        List<Representation> sousListe11 = new ArrayList<Representation>();
        for (int i =30; i<33; i++){
            sousListe11.add(representations.get(i));
                }
        spec11.setRepresentations(sousListe11);
        
        spec12.setNomSpectacle("Tournée Europe 2013");
        spec12.setDescription("Description12");
        spec12.setId(Long.MIN_VALUE);
        spec12.setArtiste(art4);
        List<Representation> sousListe12 = new ArrayList<Representation>();
        for (int i =33; i<36; i++){
            sousListe12.add(representations.get(i));
                }
        spec12.setRepresentations(sousListe12);
        
        spec13.setNomSpectacle("Tournée Canada 2013");
        spec13.setDescription("Description13");
        spec13.setId(Long.MIN_VALUE);
        spec13.setArtiste(art5);
        List<Representation> sousListe13 = new ArrayList<Representation>();
        for (int i =36; i<39; i++){
            sousListe13.add(representations.get(i));
                }
        spec13.setRepresentations(sousListe13);
        
        spec14.setNomSpectacle("Tournée USA 2013");
        spec14.setDescription("Description14");
        spec14.setId(Long.MIN_VALUE);
        spec14.setArtiste(art5);
        List<Representation> sousListe14 = new ArrayList<Representation>();
        for (int i =39; i<42; i++){
            sousListe14.add(representations.get(i));
                }
        spec14.setRepresentations(sousListe14);
        
        spec15.setNomSpectacle("Tournée Europe 2013");
        spec15.setDescription("Description15");
        spec15.setId(Long.MIN_VALUE);
        spec15.setArtiste(art5);
        List<Representation> sousListe15 = new ArrayList<Representation>();
        for (int i =42; i<45; i++){
            sousListe15.add(representations.get(i));
                }
        spec15.setRepresentations(sousListe15);
        
        spec16.setNomSpectacle("Tournée Canada 2013");
        spec16.setDescription("Description16");
        spec16.setId(Long.MIN_VALUE);
        spec16.setArtiste(art6);
        List<Representation> sousListe16 = new ArrayList<Representation>();
        for (int i =45; i<48; i++){
            sousListe16.add(representations.get(i));
                }
        spec16.setRepresentations(sousListe16);
        
        spec17.setNomSpectacle("Tournée USA 2013");
        spec17.setDescription("Description17");
        spec17.setId(Long.MIN_VALUE);
        spec17.setArtiste(art6);
        List<Representation> sousListe17 = new ArrayList<Representation>();
        for (int i =48; i<51; i++){
            sousListe17.add(representations.get(i));
                }
        spec17.setRepresentations(sousListe17);
        
        spec18.setNomSpectacle("Tournée Europe 2013");
        spec18.setDescription("Description18");
        spec18.setId(Long.MIN_VALUE);
        spec18.setArtiste(art6);
        List<Representation> sousListe18 = new ArrayList<Representation>();
        for (int i =51; i<54; i++){
            sousListe18.add(representations.get(i));
                }
        spec18.setRepresentations(sousListe18);
        
        
        spectacles.add(spec1);
        spectacles.add(spec2);
        spectacles.add(spec3);
        spectacles.add(spec4);
        spectacles.add(spec5);
        spectacles.add(spec6);
        spectacles.add(spec7);
        spectacles.add(spec8);
        spectacles.add(spec9);
        spectacles.add(spec10);
        spectacles.add(spec11);
        spectacles.add(spec12);
        spectacles.add(spec13);
        spectacles.add(spec14);
        spectacles.add(spec15);
        spectacles.add(spec16);
        spectacles.add(spec17);
        spectacles.add(spec18);
        
        salles.add(sal1);
        salles.add(sal2);
        salles.add(sal3);
        salles.add(sal4);
        salles.add(sal5);
        salles.add(sal6);
        salles.add(sal7);
        salles.add(sal8);
        salles.add(sal9);
        
        artistes.add(art1);
        artistes.add(art2);
        artistes.add(art3);
        artistes.add(art4);
        artistes.add(art5);
        artistes.add(art6);
        
        
        
        //fin séquence de passation des paramètres
    }
}