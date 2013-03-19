package ca.etsmtl.gti525.exception;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.el.ELException;
import javax.faces.FacesException;
import javax.faces.application.ViewExpiredException;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;


public class ExceptionHandler extends ExceptionHandlerWrapper {

    private static final Logger LOG = Logger.getLogger(ExceptionHandler.class.getName());
    private final javax.faces.context.ExceptionHandler wrapped;

    public ExceptionHandler(final javax.faces.context.ExceptionHandler wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public javax.faces.context.ExceptionHandler getWrapped() {
        return this.wrapped;
    }

    @Override
    public void handle() throws FacesException {
        for (final Iterator<ExceptionQueuedEvent> it = getUnhandledExceptionQueuedEvents().iterator(); it.hasNext();) {
            Throwable t = it.next().getContext().getException();
            while ((t instanceof FacesException || t instanceof ELException)  //EJBException
                    && t.getCause() != null) {
                t = t.getCause();
            }

            final FacesContext facesContext = FacesContext.getCurrentInstance();
            final ExternalContext externalContext = facesContext.getExternalContext();
            String root = facesContext.getExternalContext().getRequestContextPath();
            final Map<String, Object> requestMap = externalContext.getRequestMap();
            try {
                LOG.info("{}: {}" + t.getClass().getSimpleName() + t.getMessage());
                String message;
                if (t instanceof ViewExpiredException) {
                    final String viewId = ((ViewExpiredException) t).getViewId();
                    message = "View is expired. <a href='/ifos" + viewId + "'>Back</a>";
                    try {
                        externalContext.redirect(root);
                    } catch (IOException ex) {
                        Logger.getLogger(ExceptionHandler.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
                    message = t.getMessage(); // beware, don't leak internal info!
                    requestMap.put("errorMsg", message);
                    Logger.getLogger(ExceptionHandler.class.getName()).log(Level.SEVERE, null, t);

                    try {
                        externalContext.redirect(root + "/faces/commun/erreur/autre.xhtml");
                    } catch (IOException ex) {
                        Logger.getLogger(ExceptionHandler.class.getName()).log(Level.SEVERE, null, ex);
                    }


                }

                facesContext.responseComplete();
            } finally {
                it.remove();
            }
        }

        getWrapped().handle();
    }
}
