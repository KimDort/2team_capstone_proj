package teamcapstone.domain;

import java.util.*;
import lombok.Data;
import teamcapstone.infra.AbstractEvent;

@Data
public class DeliveryCompleted extends AbstractEvent {

    private Long id;
    private Long orderId;
    private Date startDt;
    private Date pickupedDt;
    private Date compDt;
    private String status;
}
