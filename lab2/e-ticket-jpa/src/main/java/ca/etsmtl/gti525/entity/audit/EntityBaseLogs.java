package ca.etsmtl.gti525.entity.audit;

import ca.etsmtl.utils.DateUtils;
import java.sql.Timestamp;
import javax.faces.context.FacesContext;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * c'est les Trigger SQL
 */
@MappedSuperclass
public abstract class EntityBaseLogs {

    /**
     * Update date
     */
    @Column(name = "UPDATE_TS", insertable = false, updatable = true)
    private Timestamp dateMajTech;
    /**
     * Creation date
     */
    @Column(name = "CREATION_TS", insertable = true, updatable = false)
    private Timestamp dateCreaTech;
    /**
     * first creator
     */
    @Column(name = "CREATOR", insertable = true, updatable = false)
    private String creator;
    /**
     * first creator
     */
    @Column(name = "LAST_UPDATER", insertable = false, updatable = true)
    private String lastUpdater;

    /**
     * @return the dateMajTech
     */
    public Timestamp getDateMajTech() {
        return dateMajTech;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getLastUpdater() {
        return lastUpdater;
    }

    public void setLastUpdater(String lastUpdater) {
        this.lastUpdater = lastUpdater;
    }

    /**
     * @param dateMajTech
     *            the dateMajTech to set
     */
    void setDateMajTech(Timestamp dateMajTech) {
        this.dateMajTech = dateMajTech;
    }

    /**
     * @return the dateCreaTech
     */
    public Timestamp getDateCreaTech() {
        return dateCreaTech;
    }

    /**
     * @param dateCreaTech
     *            the dateCreaTech to set
     */
    void setDateCreaTech(Timestamp dateCreaTech) {
        this.dateCreaTech = dateCreaTech;
    }

    @PrePersist
    void onCreate() {
        this.setDateCreaTech(DateUtils.getCurrentTimeStamp());

        FacesContext fc = FacesContext.getCurrentInstance();
        String id = null;
        if (fc != null) {
            id = fc.getExternalContext().getRemoteUser();

        } else {
            id = "batch.batch";
        }
        this.creator = id;
    }

    @PreUpdate
    void onPersist() {
        this.setDateMajTech(DateUtils.getCurrentTimeStamp());
        FacesContext fc = FacesContext.getCurrentInstance();
        String id = null;
        if (fc != null) {
            id = fc.getExternalContext().getRemoteUser();

        } else {
            id = "batch.batch";

        }
        this.lastUpdater = id;
    }
}
