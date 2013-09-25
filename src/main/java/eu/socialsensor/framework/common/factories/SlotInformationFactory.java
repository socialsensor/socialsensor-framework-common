package eu.socialsensor.framework.common.factories;

import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import eu.socialsensor.framework.common.domain.dysco.Ngram;
import eu.socialsensor.framework.common.domain.dysco.SlotInformation;

/**
 *
 * @author etzoannos - e.tzoannos@atc.gr
 */
public class SlotInformationFactory {

    public static SlotInformation create(String json) {
        try {
            Gson gson = new GsonBuilder()
            	.registerTypeAdapter(Map.class, new SlotInformation.CustomAdapter())
            	.enableComplexMapKeySerialization()
            	.create();
            SlotInformation slotInformation = gson.fromJson(json, SlotInformation.class);
            return slotInformation;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }
    
    public static void main(String...args) {
		SlotInformation slot = new SlotInformation();
		
		slot.AddRepresentativeNgram(new Ngram("t1", 0.2f));
		
		slot.AddNgramTweet("t1", "id1");
		slot.AddNgramTweet("t1", "id2");
		
		String json = slot.toJSONString();
		System.out.println(json);
		
		SlotInformation slot2 = SlotInformationFactory.create(json);
		
		System.out.println("\n==\n");
		
		System.out.println(slot2.toJSONString());
	}
}
