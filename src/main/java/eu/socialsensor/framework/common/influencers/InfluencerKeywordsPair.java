/*
 * Copyright 2014 stzoannos.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
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
package eu.socialsensor.framework.common.influencers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import eu.socialsensor.framework.common.domain.JSONable;
import eu.socialsensor.framework.common.domain.Keyword;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author stzoannos
 */
public class InfluencerKeywordsPair implements JSONable {

    @Expose
    @SerializedName(value = "influencer")
    private String influencer;
    @Expose
    @SerializedName(value = "keywords")
    private List<Keyword> keywords = new ArrayList<Keyword>();

    public InfluencerKeywordsPair() {
    }

    public InfluencerKeywordsPair(String influencer, List<Keyword> keywords) {
        this.influencer = influencer;
        this.keywords = keywords;
    }

    public String getInfluencer() {
        return influencer;
    }

    public void setInfluencer(String influencer) {
        this.influencer = influencer;
    }

    public List<Keyword> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<Keyword> keywords) {
        this.keywords = keywords;
    }

  
    @Override
    public String toJSONString() {

        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        return gson.toJson(this);
    }

}
