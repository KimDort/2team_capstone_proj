package teamcapstone.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import teamcapstone.domain.*;

@RepositoryRestResource(collectionResourceRel = "payinfos", path = "payinfos")
public interface PayinfoRepository
    extends PagingAndSortingRepository<Payinfo, Long> {}
