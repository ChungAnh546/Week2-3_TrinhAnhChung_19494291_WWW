package vn.edu.iuh.fit.backend.pks;

import lombok.Data;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
@Data
@Embeddable
public class OrderDetailPK implements Serializable {
    private long order_id;
    private long product_id;
}
