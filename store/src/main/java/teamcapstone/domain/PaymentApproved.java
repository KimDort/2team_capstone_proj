package teamcapstone.domain;

import java.util.*;
import lombok.*;
import teamcapstone.domain.*;
import teamcapstone.infra.AbstractEvent;

@Data
@ToString
public class PaymentApproved extends AbstractEvent {

    private Long id;
    private Long orderId;
    private Double price;
    private String status;
    // keep

}
