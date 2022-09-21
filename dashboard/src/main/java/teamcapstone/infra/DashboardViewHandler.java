package teamcapstone.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import teamcapstone.config.kafka.KafkaProcessor;
import teamcapstone.domain.*;

@Service
public class DashboardViewHandler {

    @Autowired
    private DashboardRepository dashboardRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrdered_then_CREATE_1(@Payload Ordered ordered) {
        try {
            if (!ordered.validate()) return;

            // view 객체 생성
            Dashboard dashboard = new Dashboard();
            // view 객체에 이벤트의 Value 를 set 함
            dashboard.setOrderId(ordered.getId());
            dashboard.setStoreName(ordered.getStoreName());
            dashboard.setItemName(ordered.getItemName());
            dashboard.setItemQty(ordered.getItemQty());
            dashboard.setPrice(ordered.getPrice());
            dashboard.setStatus("ORDERED");
            dashboard.setOrderDt(ordered.getOrderDate());
            // view 레파지 토리에 save
            dashboardRepository.save(dashboard);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenStoreConfirmed_then_UPDATE_1(
        @Payload StoreConfirmed storeConfirmed
    ) {
        try {
            if (!storeConfirmed.validate()) return;
            // view 객체 조회
            Optional<Dashboard> dashboardOptional = dashboardRepository.findByOrderId(
                storeConfirmed.getOrderId()
            );

            if (dashboardOptional.isPresent()) {
                Dashboard dashboard = dashboardOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashboard.setStatus("ORDER_CONFIRMED");
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryStarted_then_UPDATE_2(
        @Payload DeliveryStarted deliveryStarted
    ) {
        try {
            if (!deliveryStarted.validate()) return;
            // view 객체 조회
            Optional<Dashboard> dashboardOptional = dashboardRepository.findByOrderId(
                deliveryStarted.getOrderId()
            );

            if (dashboardOptional.isPresent()) {
                Dashboard dashboard = dashboardOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashboard.setStatus("DELIVERY_STARTED");
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaymentApproved_then_UPDATE_3(
        @Payload PaymentApproved paymentApproved
    ) {
        try {
            if (!paymentApproved.validate()) return;
            // view 객체 조회
            Optional<Dashboard> dashboardOptional = dashboardRepository.findByOrderId(
                paymentApproved.getOrderId()
            );

            if (dashboardOptional.isPresent()) {
                Dashboard dashboard = dashboardOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashboard.setStatus("PAYED");
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderCanceled_then_UPDATE_4(
        @Payload OrderCanceled orderCanceled
    ) {
        try {
            if (!orderCanceled.validate()) return;
            // view 객체 조회
            Optional<Dashboard> dashboardOptional = dashboardRepository.findByOrderId(
                orderCanceled.getId()
            );

            if (dashboardOptional.isPresent()) {
                Dashboard dashboard = dashboardOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashboard.setStatus("ORDER_CANCELED");
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryCompleted_then_UPDATE_5(
        @Payload DeliveryCompleted deliveryCompleted
    ) {
        try {
            if (!deliveryCompleted.validate()) return;
            // view 객체 조회
            Optional<Dashboard> dashboardOptional = dashboardRepository.findByOrderId(
                deliveryCompleted.getOrderId()
            );

            if (dashboardOptional.isPresent()) {
                Dashboard dashboard = dashboardOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashboard.setStatus("DELIVERY_COMPLETED");
                dashboard.setDeliveryCompDt(deliveryCompleted.getCompDt());
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenPickuped_then_UPDATE_6(@Payload Pickuped pickuped) {
        try {
            if (!pickuped.validate()) return;
            // view 객체 조회
            Optional<Dashboard> dashboardOptional = dashboardRepository.findByOrderId(
                pickuped.getOrderId()
            );

            if (dashboardOptional.isPresent()) {
                Dashboard dashboard = dashboardOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashboard.setStatus("PICKUPED");
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenCookComplted_then_UPDATE_7(
        @Payload CookComplted cookComplted
    ) {
        try {
            if (!cookComplted.validate()) return;
            // view 객체 조회
            Optional<Dashboard> dashboardOptional = dashboardRepository.findByOrderId(
                cookComplted.getOrderId()
            );

            if (dashboardOptional.isPresent()) {
                Dashboard dashboard = dashboardOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashboard.setStatus("COOK_COMPLETED");
                dashboard.setCookedCompDt(cookComplted.getCompltDate());
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaymentCanceled_then_UPDATE_8(
        @Payload PaymentCanceled paymentCanceled
    ) {
        try {
            if (!paymentCanceled.validate()) return;
            // view 객체 조회
            Optional<Dashboard> dashboardOptional = dashboardRepository.findByOrderId(
                paymentCanceled.getOrderId()
            );

            if (dashboardOptional.isPresent()) {
                Dashboard dashboard = dashboardOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashboard.setStatus("PAYMENT_CANCELED");
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenStoreCanceled_then_UPDATE_9(
        @Payload StoreCanceled storeCanceled
    ) {
        try {
            if (!storeCanceled.validate()) return;
            // view 객체 조회
            Optional<Dashboard> dashboardOptional = dashboardRepository.findByOrderId(
                storeCanceled.getOrderId()
            );

            if (dashboardOptional.isPresent()) {
                Dashboard dashboard = dashboardOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashboard.setStatus("STORE_CANCELED");
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // keep

}
