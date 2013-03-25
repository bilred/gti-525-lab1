package ca.etsmtl.gti525.commun.manager;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;

/**
 * Cette Classe Contient toutes les Méthodes (Requête simple en JPA Criteria API, les plus communément utilisé).<br/>
 * Toutes ces méthodes sont implémentées de façon générique et peuvent être utilisées pour toutes les entités (testé, Approuvé et Validé, déjà fait ses preuves).<br/>
 * Bon lien : http://docs.oracle.com/javaee/6/tutorial/doc/gjivm.html <br/><br/>
 * source :<br/>
 * http://docs.oracle.com/javaee/ <br/>
 * http://docs.oracle.com/javase/specs/ <br/>
 * 
 * <br/><br/>
 * Historique des modifications : <br/>
 * 4/01/2012 Ajout factorisation de la méthode " List<Type> findAllOrderBy(String attributOfEntity) "<br/>
 * 15/01/2012 Ajout factorisation de la méthode " List<Type> findWithOneWhere(SingularAttribute attributOfEntity, String critreOfWhere) "<br/>
 * 07/02/2012 Ajout factorisation de la méthode " List<Type> findNotWithOneWhere(SingularAttribute attributOfEntity, String critreOfWhere) "<br/>
 * 15/05/2012 Ajout 3 méthodes basées sur les prédicats.
 * 21/06/2012 Ajout de 2 Méthodes getCurrentMaxOfId(); et getCurrentMinOfId();
 * @param <Type> 
 * @author YACINE FEKAR & B.REDOUANE & Hadjout Dalil
 */
public abstract class AbstractManager<Type> implements Serializable {
    
    private Class<Type> entityClass;


    public AbstractManager(Class<Type> entityClass) {
        this.entityClass = entityClass;
    }

//    protected Class<Type> getEntityClass() {
//       return entityClass;
//    }
    
    protected abstract EntityManager getEntityManager();
    protected abstract Logger getLogger();
    
    /**
     * Pour la création d'enregistrement.<br/>
     * @param entity 
     */
//    @Transactional(readOnly = true)
    public void create(Type entity) { //throws ExceptionAdd
        try {
            getEntityManager().persist(entity);
        } catch (Exception ex) {
            getLogger().log(Level.WARNING, "Exception lors de l''appel au service" + entityClass + " Impl.create {0} : ", ex.getMessage()); //ex.getStackTrace()
        }
    }
    
    /**
     * Pour la Modification d'enregistrement.<br/>
     * @param entity 
     */
    public void edit(Type entity) {
        try {
            getEntityManager().merge(entity);
        } catch (Exception ex) {
            getLogger().log(Level.WARNING, "Exception lors de l''appel au service " + entityClass + " Impl.edit {0} : ", ex.getMessage());
        }
    }

    /**
     * Pour la Suppression d'enregistrement.<br/>
     * @param entity 
     */
    public void remove(Type entity) {
        try {
            getEntityManager().remove(getEntityManager().merge(entity));
        } catch (Exception ex) {
            getLogger().log(Level.WARNING, "Exception lors de l''appel au service " + entityClass + " Impl.remove {0} : ", ex.getMessage());
        }
    }

    /**
     * Pour la Recherche par ID d'un enregistrement.<br/>
     * @param id
     * @return 
     */
    public Type find(Object id) {
        try {
            return getEntityManager().find(entityClass, id);
        } catch (Exception ex) {
            getLogger().log(Level.WARNING, "Exception lors de l''appel au service " + entityClass + " Impl.find {0} : ", ex.getMessage());
            return null;
        }
    }

    /**
     * Pour un SELECT * FROM laTable.<br/>
     * @return 
     */
    public List<Type> findAll() {
        try {
            CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
            cq.select(cq.from(entityClass));
            return getEntityManager().createQuery(cq).getResultList();

        } catch (Exception ex) {
            getLogger().log(Level.WARNING, "Exception lors de l''appel au service " + entityClass + " Impl.findAll {0} : ", ex.getMessage());
            return null;
        }
    }

    /**
     * Pour récup dune List d'enregistrement ce trouvant entre une Borne supérieure et une borne inférieur.<br/>
     * @param range
     * @return 
     */
    public List<Type> findRange(int[] range) {
        try {
            CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
            cq.select(cq.from(entityClass));
            Query q = getEntityManager().createQuery(cq);
            q.setMaxResults(range[1] - range[0]);
            q.setFirstResult(range[0]);
            return q.getResultList();
        } catch (Exception ex) {
            getLogger().log(Level.WARNING, "Exception lors de l''appel au service " + entityClass + " Impl.findRange {0} : ", ex.getMessage());
            return null;
        }
    }

    /**
     * Pour Compter le nombre d'enregistrements dans une table.<br/>
     * @return 
     */
    public int count() {
        try {
            CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
            Root<Type> rt = cq.from(entityClass);
            cq.select(getEntityManager().getCriteriaBuilder().count(rt));
            Query q = getEntityManager().createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } catch (Exception ex) {
            getLogger().log(Level.WARNING, "Exception lors de l''appel au service " + entityClass + " Impl.count {0} : ", ex.getMessage());
            return -1;

        }
    }

    /**
     * Permet de faire un FindAll OrderBy par un(1) des attributs de l'entity.<br/>
     * <br/>
     * Remarque : Sur la façon d'utiliser le paramétre "attributOfEntity"<br/> 
     * en passe en paramétre l'attribut a partir du méta-model des entity<br/>
     * (pour plus de maintenabilité et de flexibilité) Exemple : « Pays_.libelle.getName() » == "le nom du champs dans la BDD"<br/>
     * 
     * //    @Interceptors(ElitLogInterceptor.class)
     * @param attributOfEntity L'attribut avec qui en fait le tri<br/>
     * @return La liste de tous les entity quel contiens<br/>
     */
    public List<Type> findAllOrderBy(SingularAttribute attributOfEntity) {
        try {
            CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
            CriteriaQuery<Type> criteriaQuery = (CriteriaQuery<Type>) criteriaBuilder.createQuery();
            Root<Type> from = criteriaQuery.from(entityClass);
            CriteriaQuery<Type> select = criteriaQuery.select(from);
            select.orderBy(criteriaBuilder.asc(from.get(attributOfEntity)));
            TypedQuery<Type> typedQuery = getEntityManager().createQuery(select);
            List<Type> resultList = typedQuery.getResultList();
            return resultList;
        } catch (Exception ex) {
            getLogger().log(Level.WARNING, "Exception lors de l''appel au service " + entityClass + " Impl.findAllOrderBy {1} : ", ex.getMessage());
            return null;
        }
    }

    /**
     * Permet de faire un Find avec un seul critère.<br/>
     * <br/>
     * Remarque : Sur la façon d'utiliser le paramétre "attributOfEntity"<br/> 
     * en passe en paramétre l'attribut a partir du méta-model des entity, 
     * (pour plus de maintenabilité et de flexibilité) Exemple : « Pays_.libelle.getName() » == "le nom du champs dans la BDD"<br/>
     * Ex requête JPQL<br/><br/>
     * public List<Type> findWithOneWhere(String critreOfWhere){  
     *   Query query = em.createQuery("select e from TRubriqueVar e  where e.rubVarPK.codeSociete=:critreOfWhere");
     *   query.setParameter("critreOfWhere", critreOfWhere);
     *   return query.getResultList(); 
     * }
     * 
     * //@Interceptors(ElitLogInterceptor.class)
     * @param attributOfEntity <br/>
     * @param critreOfWhere (Nombre de critères illimités) <br/>
     * @return 
     */    
    public List<Type> findWithOneWhere(SingularAttribute attributOfEntity, String... critreOfWhere) {
        try {
            CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
            CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
            Root<Type> from = criteriaQuery.from(entityClass);
            CriteriaQuery<Type> select = (CriteriaQuery<Type>) criteriaQuery.select(from);

            Predicate p = criteriaBuilder.conjunction();
            for (Object filter : critreOfWhere) {
//          p = criteriaBuilder.conjunction();

                if (filter != null) {
                    p = criteriaBuilder.and(p, criteriaBuilder.equal(from.get(attributOfEntity), filter));
                }

            }
            select.where(p); //select.where(criteriaBuilder.equal(from.get(attributOfEntity), critreOfWhere));

            TypedQuery<Type> typedQuery = getEntityManager().createQuery(select);
            List<Type> resultList = typedQuery.getResultList();
            return resultList;
        } catch (Exception ex) {
            getLogger().log(Level.WARNING, "Exception lors de l''appel au service " + entityClass + " Impl.findAllOneWhere {2} : ", ex.getMessage());
            return null;
        }
    }

    /**
     * Permet de faire un findWithOneWhere avec un seul critère inversé.<br/>
     * <br/>
     * Remarque : Sur la façon d'utiliser le paramétre "attributOfEntity"<br/> 
     * en passe en paramétre l'attribut a partir du méta-model des entity<br/>
     * (pour plus de maintenabilité et de flexibilité) Exemple : « Pays_.libelle.getName() » == "le nom du champs dans la BDD"<br/><br/>
     * 
     * Exemple : (en JPQL)<br/>
     * public List<Type> findNotWithOneWhere(String critreOfWhere){  
     *   Query query = em.createQuery("select e from TRubriqueVar e  where e.rubVarPK.codeSociete !=:critreOfWhere");
     *   query.setParameter("critreOfWhere", critreOfWhere);
     *   return query.getResultList(); 
     * }
     * 
     * //    @Interceptors(ElitLogInterceptor.class)     //CollectionAttribute
     * @param attributOfEntity <br/>
     * @param critreOfWhere (Nombre de critères illimités)<br/>
     * @return 
     */
    public List<Type> findNotWithOneWhere(SingularAttribute attributOfEntity, Object... critreOfWhere) {
        try {
            CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
            CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
            Root<Type> from = criteriaQuery.from(entityClass);
            CriteriaQuery<Type> select = (CriteriaQuery<Type>) criteriaQuery.select(from);

            Predicate p = criteriaBuilder.conjunction();
            for (Object filter : critreOfWhere) {
//          p = criteriaBuilder.conjunction();

                if (filter != null) {
                    p = criteriaBuilder.and(p, criteriaBuilder.notEqual(from.get(attributOfEntity), filter));
                }

            }
            select.where(p); //select.where(criteriaBuilder.notEqual(from.get(attributOfEntity), tab[1] ));

            TypedQuery<Type> typedQuery = getEntityManager().createQuery(select);
            List<Type> resultList = typedQuery.getResultList();
            return resultList;
        } catch (Exception ex) {
            getLogger().log(Level.WARNING, "Exception lors de l''appel au service " + entityClass + " Impl.findNotWithOneWhere {2} : ", ex.getMessage());
            return null;
        }

    }

    /**
     * Permet la récupération du Max champ Id (Généralement en auto incrément).<br/><br/>
     * 
     * le "@SuppressWarnings ({"rawtypes", "unchecked"})" pour désactivais le message de Warning du Compilateur.<br/>
     * rawtypes : les warnings quand on utilise par exemple List au lieu de List<String>.<br/>
     * unchecked : les warnings quand on fait des casts d'un type paramétré à un autre, dont le compilateur ne peut pas vérifier la sûreté.<br/>
     * 
     * Exemple : <code>
     * List<Integer> list1 = new ArrayList<Integer>();
     * list1.add(8);
     * List<?> list2 = list1;
     * List<String> list3 = (List<String>)list2; // warning: le cast n'est pas sûr, il ne peut pas être vérifié.
     * String text = list3.get(0); // ClassCastException. Le warning avait prévenu
     * </code>
     * 
     * @return 
     */
    @SuppressWarnings ({"rawtypes", "unchecked"})
    public long getCurrentMaxOfId() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root rt = cq.from(entityClass);
        
        cq.select(getEntityManager().getCriteriaBuilder().max(rt.get("id")));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        Object result = q.getSingleResult();
        if (result == null) {
            return 0L;
        }
        return ( (Long) result).longValue();
    }
    
    /**
     * Permet la récupération du Min champ Id (Généralement en auto incrément).<br/><br/>
     * 
     * le "@SuppressWarnings ({"rawtypes", "unchecked"})" pour désactivais le message de Warning du Compilateur.<br/>
     * rawtypes : les warnings quand on utilise par exemple List au lieu de List<String>.<br/>
     * unchecked : les warnings quand on fait des casts d'un type paramétré à un autre, dont le compilateur ne peut pas vérifier la sûreté.<br/>
     * 
     * Exemple : <code>
     * List<Integer> list1 = new ArrayList<Integer>();
     * list1.add(8);
     * List<?> list2 = list1;
     * List<String> list3 = (List<String>)list2; // warning: le cast n'est pas sûr, il ne peut pas être vérifié.
     * String text = list3.get(0); // ClassCastException. Le warning avait prévenu
     * </code>
     * 
     * @return 
     */
    @SuppressWarnings ({"rawtypes", "unchecked"})
    public long getCurrentMinOfId() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root rt = cq.from(entityClass);
        
        cq.select(getEntityManager().getCriteriaBuilder().min( rt.get("id") ));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        Object result = q.getSingleResult();
        if (result == null) {
            return 0L;
        }
        return ( (Long) result).longValue();
    }    
  
    
    /**
     * Permet de vérifier l'existence d'un élément d'une table précédemment choisie.<br/>
     * <br/>
     * Remarque : utiliser pour éviter l'incohérence des données.<br/>
     * Exemple : si je choisi une valeur dans une liste déroulante et celle-ci et utilisée pour remplir un _FK (cas de non suppression en cascade)<br/>
     *           Donc avant l'utilisation de cette ligne qui contient cette _FK je dois vérifier son existence.<br/><br/> 
     * 
     * //@Interceptors(ElitLogInterceptor.class)
     * @param id Identifient d'une entity<br/>
     * @return True si existe, False s'il n'existe pas.<br/>
     */
    public boolean checksExistence(Object id) {

        try {
            return (getEntityManager().find(entityClass, id) == null);
        } catch (Exception ex) {
            getLogger().log(Level.WARNING, "Exception lors de l''appel au service " + entityClass + " Impl.checksExistence {0} : ", ex.getMessage());
            return false;
        }

    }

    /**
     * Fait par Dalil...
     * 
     * @param select
     * @param attributOfEntity
     * @param critreOfWhere
     * @return 
     */
    public CriteriaQuery<Type> creteriaMultiCritrsQueryForSingularAttribute(CriteriaQuery<Type> select, SingularAttribute attributOfEntity, Object... critreOfWhere) {
        try {
            CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
            CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
            Root<Type> from = criteriaQuery.from(entityClass);

            Predicate p = criteriaBuilder.conjunction();
//          p = criteriaBuilder.conjunction();

            for (Object filter : critreOfWhere) {
//          p = criteriaBuilder.conjunction();

                if (filter != null) {
                    p = criteriaBuilder.and(p, criteriaBuilder.equal(from.get(attributOfEntity), filter));
                }
            }


            select.where(p); //select.where(criteriaBuilder.notEqual(from.get(attributOfEntity), tab[1] ));

            return select;
        } catch (Exception ex) {
            getLogger().log(Level.WARNING, "Exception lors de l''appel au service " + entityClass + " Impl.findNotWithOneWhere {2} : ", ex.getMessage());
            return null;
        }

    }

    /**
     * Fait par Dalil...
     * 
     * @param p
     * @param attributOfEntity
     * @param critreOfWhere
     * @return 
     */
    public Predicate creteriaMultiOrCritrsQueryForSingularAttribute(Predicate p, SingularAttribute attributOfEntity, Object... critreOfWhere) {
        try {
            CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
            CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
            Root<Type> from = criteriaQuery.from(entityClass);

            Predicate p1 = null;
             Predicate[] preds = null;
            if (p != null) {
                preds = new Predicate[critreOfWhere.length + 1];
            } else {
                preds = new Predicate[critreOfWhere.length];
            }
            int i = 1;
            if (p != null) {
                preds[0] = p;
            } else {
                i = 0;
            }
            for (Object filter : critreOfWhere) {
                p1 = criteriaBuilder.equal(from.get(attributOfEntity), filter);
                preds[i++] = p1;
            }
            p = criteriaBuilder.or(preds);

            return p;
        } catch (Exception ex) {
            getLogger().log(Level.WARNING, "Exception lors de l''appel au service " + entityClass + " Impl.findNotWithOneWhere {2} : ", ex.getMessage());
            return null;
        }

    }

    
    /**
     * Fait par Dalil...
     * 
     * @param p
     * @param attributOfEntity
     * @param critreOfWhere
     * @return 
     */
    public Predicate creteriaMultiAndCritrsQueryForSingularAttribute(Predicate p, SingularAttribute attributOfEntity, Object... critreOfWhere) {
        try {
            CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
            CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
            Root<Type> from = criteriaQuery.from(entityClass);

            Predicate p1 = null;
            Predicate[] preds = null;
            if (p != null) {
                preds = new Predicate[critreOfWhere.length + 1];
            } else {
                preds = new Predicate[critreOfWhere.length];
            }
            int i = 1;
            if (p != null) {
                preds[0] = p;
            } else {
                i = 0;
            }
            for (Object filter : critreOfWhere) {
                p1 = criteriaBuilder.equal(from.get(attributOfEntity), filter);
                preds[i++] = p1;
            }
            p = criteriaBuilder.and(preds);

            return p;
        } catch (Exception ex) {
            getLogger().log(Level.WARNING, "Exception lors de l''appel au service " + entityClass + " Impl.findNotWithOneWhere {2} : ", ex.getMessage());
            return null;
        }

    }

    /**
     * Fait par Dalil.
     * 
     * Select * from entityClass Where ??
     * 
     * @param p
     * @return 
     */
    public List<Type> getResultList(Predicate p) {
        try {
            CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
            CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
            Root<Type> from = criteriaQuery.from(entityClass);
            CriteriaQuery<Type> select = (CriteriaQuery<Type>) criteriaQuery.select(from);

            select.where(p); //select.where(criteriaBuilder.notEqual(from.get(attributOfEntity), tab[1] ));

            TypedQuery<Type> typedQuery = getEntityManager().createQuery(select);
            List<Type> resultList = typedQuery.getResultList();
            return resultList;
        } catch (Exception ex) {
            getLogger().log(Level.WARNING, "Exception lors de l''appel au service " + entityClass + " Impl.findNotWithOneWhere {2} : ", ex.getMessage());
            return null;
        }

    }

    /**
     * Source : (a voir)
     * http://paddyweblog.blogspot.com/2010/04/some-examples-of-criteria-api-jpa-20.html
     * 
     * 
     * Exemple en JPQL:
     * <pre>
     * String param = "Arc%";
     * 
     *   Query query = em.createQuery(
     *        "select m from Music m where m.artisteName like :param");
     *   query.setParameter("param", param);
     *  List<Music> musics = query.getResultList();
     * 
     *   for (Music music : musics){
     *       System.out.println(music);
     *   }
     * </pre>
     * 
     * 
     * Exemple de paramétre, param = "Arc%";
     * @param param
     * @return 
     */
    public List<Type> findLike(String param){
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Type> query = cb.createQuery(entityClass);

        Root<Type> music3 = query.from(entityClass);
        query.where(cb.like(music3.<String>get("artisteName"),
                            cb.parameter(String.class, "param")));

        TypedQuery<Type> tq = getEntityManager().createQuery(query);
        tq.setParameter("param", param);
        List<Type> musics = tq.getResultList();
        return musics;
    }
  
    /**
     * Exemple en JPQL:
     * <pre>
     * String param = "Archive";
     * 
     *   Query query = em.createQuery(
     *        "select count(m) from Music m where m.artisteName = :artisteNameParam");
     *   query.setParameter("artisteNameParam", param);
     *   Long count1 = (Long)query.getSingleResult();
     * 
     *   System.out.println("count : "+count1);
     * </pre>
     * 
     * 
     * @param param
     * @return 
     */
    public Long countWithWhere(String param){
        //String param = "Archive";

        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Long> query = cb.createQuery(Long.class);

        Root<Type> music = query.from(entityClass);
        query.select(cb.count(music));
        query.where(cb.equal(music.<String>get("artisteName"),
                             cb.parameter(String.class,"artisteNameParam")));

        TypedQuery<Long> tq = getEntityManager().createQuery(query);
        tq.setParameter("artisteNameParam", param);

        Long count = tq.getSingleResult();

        System.out.println("count : "+count);
        return count;
    }
    
    /**
     * 
     * Exemple en JPQL: 
     * <pre>
     * String param = "Arc%";
     * 
     *   Query query = em.createQuery(
     *        "select distinct m.artisteName from Music m where m.artisteName like :param");
     *   query.setParameter("param", param);
     *   List<String> artistes= query.getResultList();
     * 
     *   for (String artiste : artistes){
     *       System.out.println(artiste);
     *   } 
     * </pre>
     * 
     * @param param
     * @return 
     */
    public List<Type> findDistinctLike(String param){
        //String param = "Arc%";

        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<String> query = cb.createQuery(String.class);

        Root<Type> music = query.from(entityClass);
        query.select(music.<String>get("artisteName"));
        query.distinct(true);

        query.where(cb.like(music.<String>get("artisteName"),
                            cb.parameter(String.class, "param")));

        TypedQuery<String> tq = getEntityManager().createQuery(query);
        tq.setParameter("param", param);

        List<String> artistes = tq.getResultList();


        for (String artiste : artistes){
            System.out.println(artiste);
        }
        return (List<Type>) artistes;
    } 
    
    
    
    
//     ----------------------------------------------------    
//     public Person getPersonByEmail(String personEmail) {
//        try {
//            return (Person) em
//                .createQuery("SELECT OBJECT(Person) FROM Person person WHERE person.emailAddress = :personEmail")
//                .setParameter("personEmail", personEmail).getSingleResult();
//        } catch (NoResultException e) {
//            log.warn("Person could not be found");
//        } catch (Exception e) {
//            log.warn("Could not get PersonByMail", e);
//        }
//        return null;
//    }*    
    
    /**
     * jounture entre deux table JPQL ()
     * remarque elle retourn des TRbriqueVar (qui est aussi des une rubFix !! parle dite) mais la sortie de la requet est rubFix
     */
//    @Override
//    public List<TRubriqueVar> ListerRubVarSociete(String codeSociete){
//        Query query = em.createQuery("select a from TRubriquepfixe a, TRubriqueVar e  where a.codrub=e.rubVarPK.codrub and e.rubVarPK.codeSociete=:codeSociete");// where e.TRubriqueVarPK.codeSociete=: codeSociete");
//        query.setParameter("codeSociete", codeSociete);
//        return query.getResultList(); 
//    }
   
}
