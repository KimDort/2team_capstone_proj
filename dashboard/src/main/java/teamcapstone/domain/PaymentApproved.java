package teamcapstone.domain;

import java.util.*;
import lombok.Data;
import teamcapstone.infra.AbstractEvent;

@Data
public class PaymentApproved extends AbstractEvent {

    private Long id;
    private Long orderId;
    private Double price;
    private String status;
}
