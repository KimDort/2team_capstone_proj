package teamcapstone.domain;

import java.util.*;
import lombok.*;
import teamcapstone.domain.*;
import teamcapstone.infra.AbstractEvent;

@Data
@ToString
public class PaymentCanceled extends AbstractEvent {

    private Long id;
    private Long orderId;
    private Double price;
    private String status;

    public PaymentCanceled(Payinfo aggregate) {
        super(aggregate);
    }

    public PaymentCanceled() {
        super();
    }
    // keep

}
