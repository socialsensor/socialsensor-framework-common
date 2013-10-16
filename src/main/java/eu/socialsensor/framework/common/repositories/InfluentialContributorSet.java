
package eu.socialsensor.framework.common.repositories;

import eu.socialsensor.framework.common.domain.Contributor;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 * @author gpetkos
 */
public class InfluentialContributorSet {
    public Map<String,Contributor> influencers;

    public InfluentialContributorSet(String filename) {
        loadFromFile(filename,true);
    }
    
    public boolean contains(String influencerId){
        Contributor contributor=influencers.get(influencerId);
        if(contributor==null)
            return false;
        return true;
    }
    
    
    private void loadFromFile(String filename,boolean clearExisting){
        if(influencers==null){
            influencers=new HashMap<String,Contributor>();
        }
        if(clearExisting)
            influencers.clear();
            try{
               BufferedReader influencersReader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(filename), "UTF8"));
                String next_line;
                while((next_line=influencersReader.readLine())!=null){
                    int n_words=0;
                    if((next_line.trim().length()>0)&&(next_line.startsWith("keywords:"))){
                        next_line=next_line.replaceFirst("keywords:", "");
                        next_line.trim();
                        String[] parts=next_line.split(" ");
                        n_words=parts.length;
                    }
                    next_line=influencersReader.readLine();
                    if((next_line!=null)&&(next_line.trim().length()>0)&&(next_line.startsWith("influencers:"))){
                        next_line=next_line.replace("influencers: ", "");
                        next_line=next_line.trim();
                        String[] parts=next_line.split(" ");
                        int i;
                        for(i=0;i<parts.length;i++){
                            String[] parts2=parts[i].split(":");
                            String new_id=parts2[0];
                            Contributor contributor=influencers.get(new_id);
                            if(contributor==null){
                                contributor=new Contributor(new_id);
                                influencers.put(new_id,contributor);
                            }
                        }
                    }
                }
            influencersReader.close();
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        
    }
    
  /**
   * Determines whether the Twitter status is related to one of the users in the
   * set of influential contributors.
   * 
   * @param sender
   *          if the person who created the status is in the ids set, return
   *          true
   * @param userMentions
   *          if the status contains a user mention that is contained in the ids
   *          set, return true
   * @param retweetOrigin
   *          if the status is a retweet that was originated by a user in the
   *          ids set, return true
   * @returns true if one of the ids in the input parameter matches an id found
   *          in the tweet
   */
  public boolean isTwitterJsonStringRelatedTo(String tweet, boolean sender,boolean userMentions, boolean retweetOrigin) {
    StatusRepresentation s = new StatusRepresentation(); 
    s.init(null, tweet);
    boolean matches = s.isRelatedTo(this, true, true, true); 
    return matches;
  }
    
    
    
    
}
