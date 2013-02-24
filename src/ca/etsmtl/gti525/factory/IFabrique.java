package ca.etsmtl.gti525.factory;

import ca.etsmtl.gti525.factory.presentation.DomainePresentation;

public interface IFabrique {
	DomainePresentation createPresentation(String typePresontation);
}
