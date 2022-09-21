package teamcapstone.domain;

import java.util.*;
import lombok.*;
import teamcapstone.domain.*;
import teamcapstone.infra.AbstractEvent;

@Data
@ToString
public class Pickuped extends AbstractEvent {

    private Long id;
    private Long orderId;
    private Date startDt;
    private Date pickupedDt;
    private Date compDt;
    private String status;

    public Pickuped(Delivery aggregate) {
        super(aggregate);
    }

    public Pickuped() {
        super();
    }
    // keep

}
