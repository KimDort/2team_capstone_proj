package teamcapstone.domain;

import java.util.*;
import lombok.*;
import teamcapstone.domain.*;
import teamcapstone.infra.AbstractEvent;

@Data
@ToString
public class StoreConfirmed extends AbstractEvent {

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

    public StoreConfirmed(Store aggregate) {
        super(aggregate);
    }

    public StoreConfirmed() {
        super();
    }
    // keep

}
