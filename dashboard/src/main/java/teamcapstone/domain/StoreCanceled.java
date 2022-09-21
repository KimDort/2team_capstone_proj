package teamcapstone.domain;

import java.util.*;
import lombok.Data;
import teamcapstone.infra.AbstractEvent;

@Data
public class StoreCanceled extends AbstractEvent {

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
}
