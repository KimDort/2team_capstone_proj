package teamcapstone.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Dashboard_table")
@Data
public class Dashboard {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long orderId;

    private String storeName;
    private String itemName;
    private Integer itemQty;
    private Integer price;
    private String status;
    private Date orderDt;
    private Date cookedCompDt;
    private Date deliveryCompDt;
}
