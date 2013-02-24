/**
 * 
 */
package ca.etsmtl.gti525.show;

import java.util.ArrayList;
import java.util.List;

import ca.etsmtl.gti525.factory.presentation.DomainePresentation;


/**
 * @author B.REDOUANE
 *
 */
public class Spectacle extends DomainePresentation {

	private ArrayList<String> typesSpectacle;
	private String description;
	private String lienVideo;  //type Blop
	private String lienImage;
	
	private Artiste artiste;
	private List<Representation> representations;
	
	
	@Override
	public void afficherPresontationCree() {
		// TODO Auto-generated method stub
		
	}
	
	
	public ArrayList<String> getTypesSpectacle() {
		return typesSpectacle;
	}
	public void setTypesSpectacle(ArrayList<String> typesSpectacle) {
		this.typesSpectacle = typesSpectacle;
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

		
	
}
