package teamcapstone.domain;

import java.util.*;
import lombok.Data;
import teamcapstone.infra.AbstractEvent;

@Data
public class Ordered extends AbstractEvent {

    private Long id;
    private String storeName;
    private String itemName;
    private Integer itemQty;
    private Integer price;
    private String orderStatus;
    private Date orderDate;
}
