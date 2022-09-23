package teamcapstone.domain;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import teamcapstone.domain.*;

@RepositoryRestResource(collectionResourceRel = "stores", path = "stores")
public interface StoreRepository extends PagingAndSortingRepository<Store, Long> {
    public Optional<Store> findByOrderId(Long orderId);
}
