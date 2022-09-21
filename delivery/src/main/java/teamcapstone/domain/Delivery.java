package teamcapstone.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import teamcapstone.DeliveryApplication;
import teamcapstone.domain.DeliveryStarted;

@Entity
@Table(name = "Delivery_table")
@Data
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long orderId;

    private Date startDt;

    private Date pickupedDt;

    private Date compDt;

    private String status;

    @PostPersist
    public void onPostPersist() {
        DeliveryStarted deliveryStarted = new DeliveryStarted(this);
        deliveryStarted.publishAfterCommit();
    }

    public static DeliveryRepository repository() {
        DeliveryRepository deliveryRepository = DeliveryApplication.applicationContext.getBean(
            DeliveryRepository.class
        );
        return deliveryRepository;
    }

    public void pickup() {
        this.pickupedDt = new Date();
        this.status = "PICKUPED";
        Pickuped pickuped = new Pickuped(this);
        pickuped.publishAfterCommit();
    }

    public void deliveryComplete() {
        this.compDt = new Date();
        this.status = "DELIVERY_COMPLETED";
        DeliveryCompleted deliveryCompleted = new DeliveryCompleted(this);
        deliveryCompleted.publishAfterCommit();
    }

    public static void deliveryStart(CookComplted cookComplted) {
        Delivery delivery = new Delivery();
        delivery.setOrderId(cookComplted.getOrderId());
        delivery.setStartDt(new Date());
        delivery.setStatus("DELIVERY_STARTED");
        repository().save(delivery);

        DeliveryStarted deliveryStarted = new DeliveryStarted(delivery);
        deliveryStarted.publishAfterCommit();
    }
}
