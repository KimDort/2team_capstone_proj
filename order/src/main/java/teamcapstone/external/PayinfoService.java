package teamcapstone.external;

import java.util.Date;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "payment", url = "${api.url.payment}")
public interface PayinfoService {
    @RequestMapping(method = RequestMethod.POST, path = "/payinfos")
    public void pay(@RequestBody Payinfo payinfo);
    // keep

}
