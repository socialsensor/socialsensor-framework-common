package eu.socialsensor.framework.common.factories;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import eu.socialsensor.framework.common.influencers.KeywordInfluencersPair;

/**
 *
 * @author etzoannos - e.tzoannos@atc.gr
 */
public class KeywordInfluencersPairFactory {

    static Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create();

    public static synchronized KeywordInfluencersPair create(String json) {
        synchronized (gson) {
            KeywordInfluencersPair pair = gson.fromJson(json, KeywordInfluencersPair.class);
            return pair;
        }
    }
}
