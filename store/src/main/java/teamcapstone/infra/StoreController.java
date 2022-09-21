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
@RequestMapping(value = "/stores")
@Transactional
public class StoreController {

    @Autowired
    StoreRepository storeRepository;

    @RequestMapping(
        value = "/{id}/cookcomplt",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Store cookComplt(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /store/cookComplt  called #####");
        Optional<Store> optionalStore = storeRepository.findById(id);

        optionalStore.orElseThrow(() -> new Exception("No Entity Found"));
        Store store = optionalStore.get();
        store.cookComplt();

        storeRepository.save(store);
        return store;
    }
    // keep
}
