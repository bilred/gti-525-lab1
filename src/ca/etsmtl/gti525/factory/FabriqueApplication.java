package ca.etsmtl.gti525.factory;

import ca.etsmtl.gti525.factory.presentation.DomainePresentation;
import ca.etsmtl.gti525.factory.presentation.DomainePresentationFabrique;


public class FabriqueApplication {
	public static void main(String[] args) {

		String typePresontation = "Spectacle"; // ou Representation

		IFabrique fabrique = new DomainePresentationFabrique();
		
		DomainePresentation mouvement = fabrique.createPresentation(typePresontation);

		mouvement.afficherPresontationCree();
	}
}







//public class ClasseSpectacle extends DomainePresentation {
//	@Override
//	public void afficherPresontationCree(){
//		System.out.println("Spectacle");
//	}
//}
//
//public class ClasseRepresentation extends DomainePresentation {
//	@Override
//	public void afficherPresontationCree(){
//		System.out.println("Representation");
//	}
//}