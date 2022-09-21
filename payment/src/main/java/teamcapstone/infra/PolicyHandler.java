package teamcapstone.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import teamcapstone.config.kafka.KafkaProcessor;
import teamcapstone.domain.*;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    PayinfoRepository payinfoRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderCanceled'"
    )
    public void wheneverOrderCanceled_PayCancel(
        @Payload OrderCanceled orderCanceled
    ) {
        OrderCanceled event = orderCanceled;
        System.out.println(
            "\n\n##### listener PayCancel : " + orderCanceled + "\n\n"
        );

        // Sample Logic //
        Payinfo.payCancel(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='StoreCanceled'"
    )
    public void wheneverStoreCanceled_PayCancel(
        @Payload StoreCanceled storeCanceled
    ) {
        StoreCanceled event = storeCanceled;
        System.out.println(
            "\n\n##### listener PayCancel : " + storeCanceled + "\n\n"
        );

        // Sample Logic //
        Payinfo.payCancel(event);
    }
    // keep

}
