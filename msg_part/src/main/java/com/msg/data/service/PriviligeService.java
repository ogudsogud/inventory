package com.msg.data.service;

import com.msg.data.model.PrivilageModel;
import org.springframework.security.access.annotation.Secured;

/**
 * Created by yoga.wiguna on 26/07/2018.
 */
public interface PriviligeService {

    @Secured({"ROLE_ADMIN"})
    PrivilageModel getNik(String nik);

}
