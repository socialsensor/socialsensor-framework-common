package eu.socialsensor.framework.common.factories;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import eu.socialsensor.framework.common.domain.WebPage;


/**
 *
 * @author etzoannos - e.tzoannos@atc.gr
 */
public class WebPageFactory {

    static Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create();

    public static synchronized WebPage create(String json) {
        synchronized (gson) {
            WebPage webPage = gson.fromJson(json, WebPage.class);
            return webPage;
        }
    }

}
