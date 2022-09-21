package teamcapstone.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import teamcapstone.PaymentApplication;
import teamcapstone.domain.PaymentCanceled;

@Entity
@Table(name = "Payinfo_table")
@Data
public class Payinfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long orderId;

    private Double price;

    private String status;

    @PostPersist
    public void onPostPersist() {
        PaymentCanceled paymentCanceled = new PaymentCanceled(this);
        paymentCanceled.publishAfterCommit();
    }

    public static PayinfoRepository repository() {
        PayinfoRepository payinfoRepository = PaymentApplication.applicationContext.getBean(
            PayinfoRepository.class
        );
        return payinfoRepository;
    }

    public void pay() {
        PaymentApproved paymentApproved = new PaymentApproved(this);
        paymentApproved.publishAfterCommit();
    }

    public static void payCancel(OrderCanceled orderCanceled) {
        /** Example 1:  new item  
        Payinfo payinfo = new Payinfo();
        repository().save(payinfo);

        PaymentCanceled paymentCanceled = new PaymentCanceled(payinfo);
        paymentCanceled.publishAfterCommit();
        */

        /**  Example 2:  finding and process */
        
        repository().findById(orderCanceled.getId()).ifPresent(payinfo->{
            
            //payinfo // do something
            payinfo.status = orderCanceled.getOrderStatus();

            repository().save(payinfo);

            PaymentCanceled paymentCanceled = new PaymentCanceled(payinfo);
            paymentCanceled.publishAfterCommit();

         });

    }

    public static void payCancel(StoreCanceled storeCanceled) {
        /** Example 1:  new item 
        Payinfo payinfo = new Payinfo();
        repository().save(payinfo);

        PaymentCanceled paymentCanceled = new PaymentCanceled(payinfo);
        paymentCanceled.publishAfterCommit();
        */

        /** Example 2:  finding and process */
        
        repository().findById(storeCanceled.getId()).ifPresent(payinfo->{
            //payinfo // do something
            
            payinfo.status = storeCanceled.getOrderStatus(); 
            repository().save(payinfo);

            PaymentCanceled paymentCanceled = new PaymentCanceled(payinfo);
            paymentCanceled.publishAfterCommit();

         });
        

    }
}
