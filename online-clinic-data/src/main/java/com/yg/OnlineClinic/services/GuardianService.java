package com.yg.OnlineClinic.services;

import com.yg.OnlineClinic.model.Guardian;

import java.util.List;

public interface GuardianService extends CrudService<Guardian,Long>{

    Guardian findByLastName(String lastName);

    List<Guardian>findAllByLastNameLike(String lastName);
}
