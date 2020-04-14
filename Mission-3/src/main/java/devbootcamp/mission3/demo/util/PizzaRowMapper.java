package devbootcamp.mission3.demo.util;

import devbootcamp.mission3.demo.model.Pizza;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PizzaRowMapper implements RowMapper<Pizza> {
    @Override
    public Pizza mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Pizza pizza = new Pizza();

        pizza.setId(rs.getLong("id"));
        pizza.setMenu(rs.getString("menu"));
        pizza.setExtraTopping(rs.getString("extra_topping"));
        pizza.setFavorite(rs.getBoolean("is_favorite"));

        return pizza;
    }
}
