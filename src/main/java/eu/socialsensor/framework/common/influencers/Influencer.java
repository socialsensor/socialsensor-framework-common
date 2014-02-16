///////////////////////////////////////////////////////////////////////////
// 
// IBM Confidential
// OCO Source Materials
// (c) Copyright IBM Corp. 2012
// 
// The source code for this program is not published or otherwise divested of 
// its trade secrets, irrespective of what has been deposited with
// the U.S. Copyright Office.
// 
///////////////////////////////////////////////////////////////////////////
package eu.socialsensor.framework.common.influencers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import eu.socialsensor.framework.common.domain.JSONable;
import java.util.Comparator;

/**
 * A class that represent an influencer and its score
 *
 * @author yosimass
 *
 */
public class Influencer implements JSONable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5159368664116513903L;

	public Influencer(String id, float score) {
        super();
        this.id = id;
        this.score = score;
    }
    @Expose
    @SerializedName(value = "id")
    String id;
    @Expose
    @SerializedName(value = "score")
    float score;

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toJSONString() {

        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        return gson.toJson(this);
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other == this) {
            return true;
        }
        if (!(other instanceof Influencer)) {
            return false;
        }
        Influencer otherMyClass = (Influencer) other;

        if (otherMyClass.getId().equals(this.getId())) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    /**
     * descending order comparator
     *
     * @author yosimass
     */
    public static class ScoreComparator implements Comparator<Influencer> {

        public int compare(Influencer o1, Influencer o2) {
            //descending order
            if (o1.getScore() < o2.getScore()) {
                return 1;
            } else if (o1.getScore() == o2.getScore()) {
                return 0;
            } else {
                return -1;
            }
        }
    }
}
