package teamcapstone.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import teamcapstone.domain.*;

@Component
public class PayinfoHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Payinfo>> {

    @Override
    public EntityModel<Payinfo> process(EntityModel<Payinfo> model) {
        return model;
    }
}
