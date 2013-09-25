package eu.socialsensor.framework.common.domain.alethiometer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *
 * @author etzoannos
 */
public class Score {

    @Expose
    @SerializedName(value = "contributor score")
    private ContributorScore contributorScore;
    @Expose
    @SerializedName(value = "content score")
    private ContentScore contentScore;
    @Expose
    @SerializedName(value = "context score")
    private ContextScore contextScore;
    @Expose
    @SerializedName(value = "total score")
    private int score = 0;
    @Expose
    @SerializedName(value = "total context score")
    private int totalContextScore = 0;
    @Expose
    @SerializedName(value = "total content score")
    private int totalContentScore = 0;
    @Expose
    @SerializedName(value = "total contributor score")
    private int totalContributorScore = 0;

    public Score() {
        contributorScore = new ContributorScore();
        contentScore = new ContentScore();
        contextScore = new ContextScore();
    }

    public int getTotalContextScore() {
        return totalContextScore;
    }

    public void setTotalContextScore(int totalContextScore) {
        this.totalContextScore = totalContextScore;
    }

    public int getTotalContentScore() {
        return totalContentScore;
    }

    public void setTotalContentScore(int totalContentScore) {
        this.totalContentScore = totalContentScore;
    }

    public int getTotalContributorScore() {
        return totalContributorScore;
    }

    public void setTotalContributorScore(int totalContributorScore) {
        this.totalContributorScore = totalContributorScore;
    }

    
    
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public ContentScore getContentScore() {
        return contentScore;
    }

    public void setContentScore(ContentScore contentScore) {
        this.contentScore = contentScore;
    }

    public ContextScore getContextScore() {
        return contextScore;
    }

    public void setContextScore(ContextScore contextScore) {
        this.contextScore = contextScore;
    }

    public ContributorScore getContributorScore() {
        return contributorScore;
    }

    public void setContributorScore(ContributorScore contributorScore) {
        this.contributorScore = contributorScore;
    }
}
