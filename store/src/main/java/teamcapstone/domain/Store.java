package teamcapstone.domain;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

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

    @CreationTimestamp
    private Date compltDate;

    @PostPersist
    public void onPostPersist() {
        StoreConfirmed storeConfirmed = new StoreConfirmed(this);
        storeConfirmed.publishAfterCommit();
    }

    @PreRemove
    public void onPreRemove() {
        StoreCanceled storeCanceled = new StoreCanceled(this);
        storeCanceled.publishAfterCommit();
    }

    public static StoreRepository repository() {
        StoreRepository storeRepository = StoreApplication.applicationContext.getBean(
            StoreRepository.class
        );
        return storeRepository;
    }

    public void cookComplt() {
        CookComplted cookComplted = new CookComplted(this);
        cookComplted.publishAfterCommit();
    }

    public static void orderRecevie(PaymentApproved paymentApproved) {
        //Example 1:  new item 
        Store store = new Store();

        store.setOrderId(paymentApproved.getOrderId());
        store.setItemPrice(paymentApproved.getPrice().longValue());
        store.setStoreName("SAMPLE_STORE_1");

        repository().save(store);

        /** Example 2:  finding and process
        
        repository().findById(paymentApproved.get???()).ifPresent(store->{
            
            store // do something
            repository().save(store);


         });
        */

    }

    public static void orderRecevie(OrderCanceled orderCanceled) {

        //Example 2:  finding and process
        repository().findByOrderId(orderCanceled.getId()).ifPresent(store->{
            repository().save(store);
         });

    }
}
