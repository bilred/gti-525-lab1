package dz.elit.commun.transfert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Utilisé pour fair le transfaire d'une List en Map.<br/>
 * Ou dans mon cas pour Simulé une Collection de List (besoin JSF => une p:collector balise qui prend pas en parramétre des Map)<br/><br/>
 * <br/>
 * PojoMap == une repréantation simplifier d'une Map(Clés, Valeur)
 * 
 * Condition : la taille des deux liste doit étre egale (pour respet du pricipe des Map(clés, Valeur))<br/><br/>
 * 
 * Actuélement utilsé pour affichage dans l'IHM pour (Bnaque,AganceBancaire), (Wilaya, Commune)
 * Vision : il serais intersaison de faire passer c'est méthode en en Static (pour utilisation sans instanciation)
 * 
 * @author redouane.billel
 */
public class PojoMap<KeyType, ValueType> {
    
    private KeyType key;
    private ValueType valeur;

    
    public PojoMap() { }
    public PojoMap(KeyType key, ValueType valeur) {
        this.key = key;
        this.valeur = valeur;
    }

 
//    public void addPojoMap(KeyType key, ValueType valeur){
//        this.keys.add( key );
//        this.valeurs.add( valeur );
//    }
    
    /**
     * Permet la transformation d'une PojoMap (du type de cette classe) a une List.<br/><br/>
     * 
     * Utilisé dans le but d'extraire d'une map les valeurs Clés mais sous une forme de List Java.<br/>
     * 
     * @param list
     * @return 
     */
    public List<KeyType> getListKeyOfPojoMap(List<PojoMap<KeyType, ValueType>> list){
        List<KeyType> listKey = new ArrayList<KeyType>();    
        for(PojoMap<KeyType, ValueType> pojoAgenceBancaire : list)
            listKey.add( pojoAgenceBancaire.key );    
 
        return listKey;
    }
    
    /**
     * Permet la transformation d'une PojoMap (du type de cette classe) a une List.<br/><br/>
     * 
     * Utilisé dans le but d'extraire d'une map les valeurs (sans les Clés) mais sous une forme de List Java.<br/>
     * 
     * @param list
     * @return 
     */
    public List<ValueType> getListValeurOfPojoMap(List<PojoMap<KeyType, ValueType>> list){
        List<ValueType> listValeur = new ArrayList<ValueType>();    
        for(PojoMap<KeyType, ValueType> pojoAgenceBancaire : list)
            listValeur.add( pojoAgenceBancaire.valeur );     
 
        return listValeur;        
    } 
    
    /**
     * Permet la transformation d'une PojoMap a une Map JAVA.
     * 
     * @param pojoMaps
     * @return 
     */
    public Map<KeyType, ValueType> getMap(List<PojoMap<KeyType, ValueType>> pojoMaps){
        Map<KeyType, ValueType> maps = new HashMap<KeyType, ValueType>();
        for (int i=0; i<pojoMaps.size(); i++) 
            maps.put(pojoMaps.get(i).key, pojoMaps.get(i).valeur);
        return maps;
    }    
    
    /**
     * Transforme une Map a une List de PojoMap.<br/>
     * l'ide viens du JAVA: Integer.valeuOf , ....
     * 
     * @param maps
     * @return 
     */
    public List<PojoMap<KeyType, ValueType>> getPojoMap(Map<KeyType, ValueType> maps){
        List<PojoMap<KeyType,ValueType>> pojoMap = new ArrayList<PojoMap<KeyType, ValueType>>(); 
        
         List listk = PojoMap.transformeArrayToList( maps.keySet().toArray());
         pojoMap.addAll( listk );
         List listv = (List) maps.values();
         pojoMap.addAll( listv );            
        
        return pojoMap;
    }    

    /**
     * Fait une conversion de deux listes (le 1er représente les Clés, l'autre les Valeur associé à cette chaque Clés) pour retourner une Map.<br/><br/>
     * 
     * Question quand une méthode devient Static ?
     * 
     * @param listsKey
     * @param listsValue
     * @return 
     */
    public static Map<?, ?> convertListToMap(List<?> listsKey, List<?> listsValue) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        for(int i=0; i<listsKey.size(); i++) map.put(listsKey.get(i), listsValue.get(i));
        
        return map;
    }    

    /**
     * Transforme une Map a une List de PojoMap.<br/> (d'oublant de méthode)
     * 
     * @param map
     * @return 
     */
    public List<PojoMap<KeyType, ValueType>> convertMapToListPojo(Map<?,?> map) {
        List<PojoMap<KeyType, ValueType>> list = new ArrayList<PojoMap<KeyType, ValueType>>();
        List<KeyType> listKeys = new ArrayList<KeyType>(); List<ValueType> listValeurs = new ArrayList<ValueType>();
        
        listKeys = (List<KeyType>) PojoMap.transformeArrayToList( map.keySet().toArray() );
        listValeurs = (List<ValueType>) PojoMap.transformeArrayToList( map.values().toArray() );
        
        for(int i = 0; i < listKeys.size(); i++) {
           list.add( new PojoMap<KeyType, ValueType>(listKeys.get(i), listValeurs.get(i))  ); 
        }
        
        return list;
    }     
    
    /**
     * Transforme un Tableau (Array) a une List<?> Java.<br/>
     * 
     * @param array
     * @return 
     */
    public static List<?> transformeArrayToList(Object[] array){
        List<Object> list = new ArrayList();
        list.addAll(Arrays.asList(array));
        
        return list;
    }

    
    
    /* ***************Getter Setter******************* */
    public KeyType getKey() {
        return key;
    }

    public void setKey(KeyType key) {
        this.key = key;
    }

    public ValueType getValeur() {
        return valeur;
    }

    public void setValeur(ValueType valeur) {
        this.valeur = valeur;
    }
    /* ********************************** */
}
