import java.util.List;
import java.util.Map;

import models.Transaction;

import play.*;
import play.libs.*;

import com.avaje.ebean.Ebean;

public class Global extends GlobalSettings {

	
	public void onStart(Application app) {
		Logger.info("Application has started *************************");
        InitialData.insert(app);
        
    }
	
	public void onStop(Application app) {
        Logger.info("Application shutdown... *************************");
    }
    
    static class InitialData {
        public static void insert(Application app) {
            if(Ebean.find(Transaction.class).findRowCount() == 0) {
            	
                @SuppressWarnings("unchecked")
				Map<String,List<Object>> all = (Map<String,List<Object>>)Yaml.load("initial-data.yml");
                
                Ebean.save(all.get("transactions"));
                
            }
        }
    }
    
}
