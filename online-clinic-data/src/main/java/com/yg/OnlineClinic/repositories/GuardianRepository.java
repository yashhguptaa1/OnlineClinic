package com.yg.OnlineClinic.repositories;

import com.yg.OnlineClinic.model.Guardian;
import org.springframework.data.repository.CrudRepository;

public interface GuardianRepository extends CrudRepository<Guardian,Long> {

    Guardian findByLastName(String lastName);

}
