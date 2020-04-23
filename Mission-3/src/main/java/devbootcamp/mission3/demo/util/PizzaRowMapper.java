package devbootcamp.mission3.demo.util;

import devbootcamp.mission3.demo.model.Pizza;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PizzaRowMapper implements RowMapper<Pizza> {
    @Override
    public Pizza mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Pizza pizza = new Pizza();

        pizza.setId(rs.getLong("id"));
        pizza.setFlavour(rs.getString("flavour"));
        //pizza.setExtraTopping(rs.getString("extra_topping"));
        String extraToppingString = rs.getString("extra_topping").replace("[","").replace("]","");

        //Parse String to Array
        pizza.setExtraTopping(
                new ArrayList<String>(Arrays.asList(extraToppingString.split(",")))
        );
        pizza.setFavorite(rs.getBoolean("is_favorite"));

        return pizza;
    }
}
