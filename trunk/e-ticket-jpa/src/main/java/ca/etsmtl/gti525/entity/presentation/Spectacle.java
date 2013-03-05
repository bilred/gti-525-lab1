package ca.etsmtl.gti525.entity.presentation;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author B.REDOUANE
 *
 */
@Entity
@Table(name = "SHOW_SPECTACLE")
public class Spectacle implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ElementCollection  
    @CollectionTable(name = "T_TYPES_SPECTACLE")
    @Column(name = "TYPES_SPECTACLE")    
    private List<String> typesSpectacle;
    
    @Column(name="NOM_SPECTACLE")
    private String nomSpectacle;
    
    @Column(name="DESCRIPTION")
    private String description;
    @Column(name="LIEN_VIDEO")
    private String lienVideo;  //type Blop
    @Column(name="LIEN_IMAGE")
    private String lienImage;
    
    @OneToOne
    private Artiste artiste;   
    @OneToMany(mappedBy = "spectacle")
    private List<Representation> representations;

    
    public List<String> getTypesSpectacle() {
        return typesSpectacle;
    }

    public void setTypesSpectacle(List<String> typesSpectacle) {
        this.typesSpectacle = typesSpectacle;
    }

    public String getNomSpectacle() {
        return nomSpectacle;
    }

    public void setNomSpectacle(String nomSpectacle) {
        this.nomSpectacle = nomSpectacle;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Representation> getRepresentations() {
        return representations;
    }

    public void setRepresentations(List<Representation> representations) {
        this.representations = representations;
    }

    public String getLienVideo() {
        return lienVideo;
    }

    public void setLienVideo(String lienVideo) {
        this.lienVideo = lienVideo;
    }

    public String getLienImage() {
        return lienImage;
    }

    public void setLienImage(String lienImage) {
        this.lienImage = lienImage;
    }

    public Artiste getArtiste() {
        return artiste;
    }

    public void setArtiste(Artiste artiste) {
        this.artiste = artiste;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}