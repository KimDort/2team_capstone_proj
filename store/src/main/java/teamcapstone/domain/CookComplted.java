package teamcapstone.domain;

import java.util.*;
import lombok.*;
import teamcapstone.domain.*;
import teamcapstone.infra.AbstractEvent;

@Data
@ToString
public class CookComplted extends AbstractEvent {

    private Long id;
    private Long orderId;
    private Long itemPrice;
    private String itemName;
    private String sotreName;
    private String itemStatus;
    private String orderStatus;
    private Date orderDate;
    private String storeName;
    private Date compltDate;

    public CookComplted(Store aggregate) {
        super(aggregate);
    }

    public CookComplted() {
        super();
    }
    // keep

}
