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
    DeliveryRepository deliveryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CookComplted'"
    )
    public void wheneverCookComplted_DeliveryStart(
        @Payload CookComplted cookComplted
    ) {
        CookComplted event = cookComplted;
        System.out.println(
            "\n\n##### listener DeliveryStart : " + cookComplted + "\n\n"
        );

        // Sample Logic //
        Delivery.deliveryStart(event);
    }
    // keep

}
