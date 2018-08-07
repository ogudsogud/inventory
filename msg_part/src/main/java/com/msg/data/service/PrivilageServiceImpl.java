package com.msg.data.service;

import com.msg.data.model.PrivilageModel;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by yoga.wiguna on 26/07/2018.
 */

@Repository
@Transactional
public class PrivilageServiceImpl implements PrivilageService{

    @PersistenceContext
    private EntityManager entityManager;
    public PrivilageModel getNik(String nik) {
        PrivilageModel privilageModel = new PrivilageModel();
        short enabled = 1;
        List<?> list = entityManager.createQuery("SELECT nik, passwd FROM mtr_privilage  WHERE nik = ? AND status = 1")
                .setParameter(1, nik)
                .getResultList();
        if(!list.isEmpty()) {
            privilageModel = (PrivilageModel)list.get(0);
        }
        return privilageModel;
    }


}
