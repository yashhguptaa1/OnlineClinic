package com.yg.OnlineClinic.services.map;

import com.yg.OnlineClinic.model.BaseEntity;

import java.util.*;

/*
These Map Services have been built with purpose of using normal HashMap collections as way of
acting as a DB instead of using actual DB such as Mysql

 */
public abstract class AbstractMapService <T extends BaseEntity,ID extends Long>{

    protected Map<Long,T>map=new HashMap<>();

    Set<T>findAll()
    {
        //System.out.println(map);
        return new HashSet<>(map.values());

    }

    T findById(ID id)
    {
        return map.get(id);

    }

    T save(T object){

        if(object!=null)
        {
            if(object.getId()==null)
            {
                object.setId(getNextId());
            }
            map.put(object.getId(), object);

        }
        else {
            throw new RuntimeException("Object cant be null");
        }

        return object;
    }

    void deleteById(ID id){
        map.remove(id);
    }

    void delete(T object){
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }


    private Long getNextId()
    {
        Long nextId = null;

        try {
            nextId = Collections.max(map.keySet()) + 1;
        } catch (NoSuchElementException e) {
            nextId = 1L;
        }

        return nextId;    }



}
