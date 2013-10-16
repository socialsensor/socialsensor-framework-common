package eu.socialsensor.framework.common.domain.alethiometer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author etzoannos
 */
public class Post {

    private String content;
    @Expose
    @SerializedName(value = "urls")
    private List<URLInfo> urlInfoList = new ArrayList<URLInfo>();
    @Expose
    @SerializedName(value = "score")
    private Score score = new Score();

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<URLInfo> getUrlInfoList() {
        return urlInfoList;
    }

    public void setUrlInfoList(List<URLInfo> urlInfoList) {
        this.urlInfoList = urlInfoList;
    }

    public void addUrlInfo(URLInfo urlInfo) {
        this.urlInfoList.add(urlInfo);
    }
}
