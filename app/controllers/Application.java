package controllers;

import models.Transaction;
import play.libs.Json;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index(String src, String dst, int limit) {
        return ok(index.render(src, dst, limit));
    }
    
    public static Result transactions(String src, String dst, int limit){
    	//return ok(transactions.render(Transaction.findAll()));
    	//return ok(Json.toJson(Transaction.findAll()));
    	return ok(Json.toJson(Transaction.filter(src, dst, limit)));
    }

}
