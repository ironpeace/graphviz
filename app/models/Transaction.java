package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import play.db.ebean.Model;

import com.avaje.ebean.ExpressionList;

@Entity
@Table(name="transaction")
public class Transaction extends Model {

	private static final long serialVersionUID = 1L;
	
	public String source;
	public String target;
	public String value;
	
	public static Model.Finder<String,Transaction> find = new Model.Finder<String,Transaction>(String.class, Transaction.class);
    
    public static List<Transaction> findAll() {
        return find.all();
    }
    
    public static List<Transaction> filter(String src, String dst, int limit) {
    	ExpressionList<Transaction> el = find.where();
    	
    	if(!src.equals("")) el = el.like("source", "%" + src + "%");
    	
    	if(!dst.equals("")) el = el.like("target", "%" + dst + "%");
    	
        return el.setMaxRows(limit).findList();
    }
}
