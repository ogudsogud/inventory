package com.msg.data.service;

import com.msg.data.model.BrandModel;

/**
 * Created by Ogudsogud on 7/21/2018.
 */
public interface BrandService {

    boolean insertBrand(BrandModel brandModel);

    BrandModel getByIdBrand(String id_brand);
}
