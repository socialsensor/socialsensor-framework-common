package eu.socialsensor.framework.common.factories;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import eu.socialsensor.framework.common.domain.Item;
import eu.socialsensor.framework.common.domain.Keyword;
import eu.socialsensor.framework.common.domain.MediaItem;
import eu.socialsensor.framework.common.domain.PlatformUser;
import eu.socialsensor.framework.common.domain.Source;
import eu.socialsensor.framework.common.domain.StreamUser;
import eu.socialsensor.framework.common.domain.Timeslot;
import eu.socialsensor.framework.common.domain.Topic;
import eu.socialsensor.framework.common.domain.WebPage;
import eu.socialsensor.framework.common.domain.dysco.SlotInformation;
import eu.socialsensor.framework.common.influencers.Influencer;
import eu.socialsensor.framework.common.influencers.KeywordInfluencersPair;

/**
 *
 * @author etzoannos - e.tzoannos@atc.gr
 */
public class ObjectFactory {

    static Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create();

    public static synchronized Item createItem(String json) {
        synchronized (gson) {
            Item item = gson.fromJson(json, Item.class);
            return item;
        }
    }


    public static MediaItem createMediaItem(String json) {
        synchronized (gson) {
            MediaItem item = gson.fromJson(json, MediaItem.class);
            return item;
        }
    }

    public static synchronized StreamUser createUser(String json) {
        synchronized (gson) {
            StreamUser item = gson.fromJson(json, StreamUser.class);
            return item;
        }
    }

    public static synchronized Influencer createInfluencer(String json) {
        synchronized (gson) {
            Influencer influencer = gson.fromJson(json, Influencer.class);
            return influencer;
        }
    }

    public static synchronized Keyword createKeyword(String json) {
        synchronized (gson) {
            Keyword keyword = gson.fromJson(json, Keyword.class);
            return keyword;
        }
    }

    public static synchronized Source createSource(String json) {
        synchronized (gson) {
            Source source = gson.fromJson(json, Source.class);
            return source;
        }
    }
    
    public static synchronized PlatformUser createPlatformUser(String json) {
        synchronized (gson) {
            PlatformUser user = gson.fromJson(json, PlatformUser.class);
            return user;
        }
    }
    
    public static synchronized Timeslot createTimeslot(String json) {
        synchronized (gson) {
        	Timeslot timeslot = gson.fromJson(json, Timeslot.class);
            return timeslot;
        }
    }
    
    public static synchronized KeywordInfluencersPair createKeywordInfluencersPair(String json) {
        synchronized (gson) {
            KeywordInfluencersPair pair = gson.fromJson(json, KeywordInfluencersPair.class);
            return pair;
        }
    }
    
    public static SlotInformation createSlotInformation(String json) {
        try {
            Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
            SlotInformation slotInformation = gson.fromJson(json, SlotInformation.class);
            return slotInformation;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }
    
    public static synchronized WebPage createWebPage(String json) {
        synchronized (gson) {
            WebPage webPage = gson.fromJson(json, WebPage.class);
            return webPage;
        }
    }
    
    public static synchronized Topic createTopic(String json) {
        synchronized (gson) {
            Topic topic = gson.fromJson(json, Topic.class);
            return topic;
        }
    }
}
