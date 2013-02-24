package ca.etsmtl.gti525.factory.presentation;

import ca.etsmtl.gti525.factory.IFabrique;
import ca.etsmtl.gti525.show.Billet;
import ca.etsmtl.gti525.show.Representation;
import ca.etsmtl.gti525.show.Spectacle;


public class DomainePresentationFabrique implements IFabrique {
	public DomainePresentation createPresentation(String typePresontation) {
		DomainePresentation m;
		if (typePresontation == "Spectacle") {
			m = new Spectacle();
		} else if(typePresontation == "Representation") {
			m = new Representation();
		} else {
			m = new Billet();
		}
		return m;
	}

}