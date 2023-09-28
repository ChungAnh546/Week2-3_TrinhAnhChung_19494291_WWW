package vn.edu.iuh.fit.week2_trinhanhchung_19494291_www.pks;

import jakarta.persistence.Embeddable;
import lombok.Data;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

import java.io.Serializable;

@Data
@Embeddable
public class ProductPricePK implements Serializable {
    private long product_id;
    private DateTime price_date_time;
}
