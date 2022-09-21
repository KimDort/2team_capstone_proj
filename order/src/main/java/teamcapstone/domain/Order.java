package teamcapstone.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import teamcapstone.OrderApplication;

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

    @PostPersist
    public void onPostPersist() {}

    public static OrderRepository repository() {
        OrderRepository orderRepository = OrderApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }

    public void order() {
        Ordered ordered = new Ordered(this);
        ordered.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        teamcapstone.external.Payinfo payinfo = new teamcapstone.external.Payinfo();
        // mappings goes here
        OrderApplication.applicationContext
            .getBean(teamcapstone.external.PayinfoService.class)
            .pay(payinfo);
    }

    public void orderCancel() {
        OrderCanceled orderCanceled = new OrderCanceled(this);
        orderCanceled.publishAfterCommit();
    }
}
