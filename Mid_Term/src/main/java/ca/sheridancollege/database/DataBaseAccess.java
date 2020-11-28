package ca.sheridancollege.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.beans.StoreData;

@Repository
public class DataBaseAccess {
	@Autowired
	NamedParameterJdbcTemplate jdbc;
	
	public void addDrink(StoreData d) {
		
		MapSqlParameterSource p = new MapSqlParameterSource();
		
		String query="INSERT INTO data VALUES" +  "(:fname,:lname, :no , :email)";
		
		p.addValue("fname", d.getFnm());
		p.addValue("lname", d.getLnm());
		p.addValue("no", d.getNo());
		p.addValue("email", d.getEmail());
		
		jdbc.update(query, p);
	}
	
	
}
