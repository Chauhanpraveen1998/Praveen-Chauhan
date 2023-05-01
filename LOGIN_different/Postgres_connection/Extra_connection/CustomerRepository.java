import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Customer> findAll() {
        return jdbcTemplate.query("SELECT * FROM customer",
            (rs, rowNum) -> new Customer(rs.getInt("id"), rs.getString("name"), rs.getString("email")));
    }
}
