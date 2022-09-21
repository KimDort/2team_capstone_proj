package teamcapstone.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import teamcapstone.domain.OrderCanceled;

@Entity
@Table(name = "Order_table")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String storeName;

    private String itemName;

    private Integer itemQty;

    private Integer price;

    private String orderStatus;

    private Date orderDate;
}
