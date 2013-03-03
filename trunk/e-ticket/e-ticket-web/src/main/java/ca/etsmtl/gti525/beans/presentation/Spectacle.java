package ca.etsmtl.gti525.beans.presentation;

import java.util.ArrayList;
import java.util.List;


/**
 * @author B.REDOUANE
 *
 */
public class Spectacle {

	private ArrayList<String> typesSpectacle;
	private String description;
	private String lienVideo;  //type Blop
	private String lienImage;
	
	private Artiste artiste;
	private List<Representation> representations;
	
	
	
	
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
