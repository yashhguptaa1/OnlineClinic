package com.yg.OnlineClinic.services.map;

import com.yg.OnlineClinic.model.Guardian;
import com.yg.OnlineClinic.services.CrudService;

import java.util.Set;

public class GuardianMapService extends AbstractMapService<Guardian,Long> implements CrudService<Guardian,Long> {
    @Override
    public Set<Guardian> findAll() {
        return super.findAll();
    }

    @Override
    public Guardian findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Guardian save(Guardian object) {
        return super.save(object.getId(),object);
    }

    @Override
    public void delete(Guardian object) {
        super.delete(object);

    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);

    }
}
