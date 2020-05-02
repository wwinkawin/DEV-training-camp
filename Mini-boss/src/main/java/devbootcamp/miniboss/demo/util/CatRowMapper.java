package devbootcamp.miniboss.demo.util;

import devbootcamp.miniboss.demo.model.catFacts.Cat;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CatRowMapper implements RowMapper<Cat> {
    @Override
    public Cat mapRow(ResultSet rs, int i) throws SQLException {
        final Cat cat = new Cat();
        cat.setId(rs.getLong("id"));
        cat.set_id(rs.getString("cat_fact_id"));
        cat.setText(rs.getString("cat_fact_text"));
        return cat;
    }
}
