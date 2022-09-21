package teamcapstone.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import teamcapstone.StoreApplication;
import teamcapstone.domain.CookComplted;
import teamcapstone.domain.StoreCanceled;
import teamcapstone.domain.StoreConfirmed;

@Entity
@Table(name = "Store_table")
@Data
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long orderId;

    private Long itemPrice;

    private String itemName;

    private String storeName;

    private String itemStatus;

    private String orderStatus;

    private Date orderDate;

    private Date compltDate;

    @PostPersist
    public void onPostPersist() {
        StoreConfirmed storeConfirmed = new StoreConfirmed(this);
        storeConfirmed.publishAfterCommit();

        StoreCanceled storeCanceled = new StoreCanceled(this);
        storeCanceled.publishAfterCommit();

        CookComplted cookComplted = new CookComplted(this);
        cookComplted.publishAfterCommit();
    }

    @PreRemove
    public void onPreRemove() {}

    public static StoreRepository repository() {
        StoreRepository storeRepository = StoreApplication.applicationContext.getBean(
            StoreRepository.class
        );
        return storeRepository;
    }

    public static void orderRecevie(PaymentApproved paymentApproved) {
        /** Example 1:  new item 
        Store store = new Store();
        repository().save(store);

        */

        /** Example 2:  finding and process
        
        repository().findById(paymentApproved.get???()).ifPresent(store->{
            
            store // do something
            repository().save(store);


         });
        */

    }

    public static void orderRecevie(OrderCanceled orderCanceled) {
        /** Example 1:  new item 
        Store store = new Store();
        repository().save(store);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderCanceled.get???()).ifPresent(store->{
            
            store // do something
            repository().save(store);


         });
        */

    }
}
