package teamcapstone.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import teamcapstone.domain.*;

@RestController
// @RequestMapping(value="/payinfos")
@Transactional
public class PayinfoController {

    @Autowired
    PayinfoRepository payinfoRepository;

    @RequestMapping(
        value = "payinfos/{id}/pay",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Payinfo pay(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /payinfo/pay  called #####");
        Optional<Payinfo> optionalPayinfo = payinfoRepository.findById(id);

        optionalPayinfo.orElseThrow(() -> new Exception("No Entity Found"));
        Payinfo payinfo = optionalPayinfo.get();
        payinfo.pay();

        payinfoRepository.save(payinfo);
        return payinfo;
    }
    // keep
}
