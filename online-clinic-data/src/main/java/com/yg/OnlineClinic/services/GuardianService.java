package com.yg.OnlineClinic.services;

import com.yg.OnlineClinic.model.Guardian;

public interface GuardianService extends CrudService<Guardian,Long>{

    Guardian findByLastName(String lastName);
}
