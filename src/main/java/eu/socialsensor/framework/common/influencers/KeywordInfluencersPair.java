package eu.socialsensor.framework.common.influencers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import eu.socialsensor.framework.common.domain.JSONable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author etzoannos - e.tzoannos@atc.gr
 */
public class KeywordInfluencersPair implements JSONable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -2843750626885344827L;
	
	
	@Expose
    @SerializedName(value = "keyword")
    private String keyword;
    @Expose
    @SerializedName(value = "influencer")
    private List<Influencer> influencers = new ArrayList<Influencer>();

    public KeywordInfluencersPair() {
    }

    public KeywordInfluencersPair(String keyword, List<Influencer> influencers) {
        this.influencers = influencers;
        this.keyword = keyword;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public List<Influencer> getInfluencers() {
        return influencers;
    }

    public void setInfluencers(List<Influencer> influencers) {
        this.influencers = influencers;
    }

    @Override
    public String toJSONString() {

        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        return gson.toJson(this);
    }
 
}
