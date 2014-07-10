package eu.socialsensor.framework.common.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Utility class for SocialSensor framework
 *
 * @author etzoannos
 */
public class Util {

    public static Map<String, String> findNetworkSource(String url) throws Exception {

        Map<String, String> result = new HashMap<String, String>();

        String source = null;
        String username = null;

        StringBuilder builder = new StringBuilder();

        if (url.startsWith("https://www.youtube.com/user")) {

            source = "youtube";

            username = builder.append(url).replace(0, 29, "").toString();

        } else if (url.startsWith("https://www.youtube.com/channel")) {

            source = "youtube";

            username = builder.append(url).replace(0, 32, "").toString();

        } else if (url.startsWith("https://www.facebook.com/")) {

            source = "facebook";

            username = builder.append(url).replace(0, 27, "").toString();

        } else if (url.startsWith("https://plus.google.com/u/0/+")) {

            source = "gplus";

            builder.append(url).replace(0, 29, "");

            int position = builder.lastIndexOf("/");

            username = builder.substring(0, position);
            

        } else if (url.startsWith("http://instagram.com")) {

            source = "instagram";

            username = builder.append(url).replace(0, 21, "").toString();

        } else if (url.startsWith("https://www.flickr.com/photos")) {

            source = "flickr";

            username = builder.append(url).replace(0, 30, "").toString();

        } else {
            
            throw new Exception("malformed network url");
        
        }

        result.put(source, username);

        return result;

    }

  
}
