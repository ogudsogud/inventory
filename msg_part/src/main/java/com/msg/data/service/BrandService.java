package com.msg.data.service;

import com.msg.data.model.BrandModel;

import java.util.List;

/**
 * Created by Ogudsogud on 7/21/2018.
 */
public interface BrandService {

    List<BrandModel> getDataBrand();

    boolean insertBrand(BrandModel brandModel);

    BrandModel getByIdBrand(String id_brand);

    boolean isBrandExist(String brand_name);

    BrandModel getByBrandName(String brand_name);

    void updateBrand(BrandModel brandModel);

    void deleteBrand(int id_brand);
}
