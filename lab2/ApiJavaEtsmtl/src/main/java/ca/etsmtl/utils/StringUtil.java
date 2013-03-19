/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ca.etsmtl.utils;

import java.util.Collection;
import java.util.Iterator;
import java.util.logging.Logger;


public class StringUtil {
    

    static private Logger logger = Logger.getLogger(StringUtil.class.getName());

    /**
     * Methode de comparison entre deux chaine de caractères non null et non vide.
     * 
     * @param string1
     * @param string2
     * @return 
     */
    public static boolean matchNotNullNotEmptyString(String string1, String string2) {
        try {
            if (string1 == null || "".equals(string1)) return false;
            if (string2 == null || "".equals(string2)) return false;
            if (string1.equals(string2)) return true;
        } catch (Exception ex) {
            logger.info("Erreur StringUtil.matchNotNullNotEmptyString " + ex.getStackTrace());
        }
        return false;
    }

    /**
     *  Methode pour vérifié qu'une chaine de caractères est non null et non vide.
     * 
     * @param str
     * @return 
     */
    public static boolean notEmptyAndNotNull(String str) {
        try {
            if (null != str && "" != str) return true;
        } catch (Exception ex) {
            logger.info("Erreur StringUtil.notEmptyAndNotNull " + ex.getStackTrace());
        }
        return false;
    }
    
    
  @SuppressWarnings("rawtypes")
  public static String toReadableString(Collection collection) {
    Iterator it = collection.iterator();
    StringBuilder strb = new StringBuilder();
    while(it.hasNext()) {
      Object next = it.next();
      strb.append(next.toString() + ", ");
    }
    if (strb.length() > 2) {
      strb.delete(strb.length()-2, strb.length());
    }
    return strb.toString();
  }    
    
}
