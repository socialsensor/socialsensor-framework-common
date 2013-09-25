package eu.socialsensor.framework.common.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *
 * @author etzoannos - e.tzoannos@atc.gr
 */
public class MediaItemLight {
  
    @Expose
    @SerializedName(value = "mediaLink")
    String mediaLink;
    @Expose
    @SerializedName(value = "thumbnailLink")
    String thumbnailLink;

    public MediaItemLight(String mediaLink, String thumbnailLink) {
        this.mediaLink = mediaLink;
        this.thumbnailLink = thumbnailLink;
    }

    public String getMediaLink() {
        return mediaLink;
    }

    public void setMediaLink(String mediaLink) {
        this.mediaLink = mediaLink;
    }

    public String getThumbnailLink() {
        return thumbnailLink;
    }

    public void setThumbnailLink(String thumbnailLink) {
        this.thumbnailLink = thumbnailLink;
    }
}
