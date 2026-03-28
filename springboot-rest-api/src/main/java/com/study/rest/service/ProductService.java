package com.study.rest.service;

import com.study.rest.dto.ColorDto;
import com.study.rest.dto.CommonResponseDto;
import com.study.rest.dto.ProductDto;
import com.study.rest.dto.SizeDto;
import com.study.rest.entity.Color;

import java.util.List;

public interface ProductService {
    List<SizeDto.Info> getSizeListAll();
    List<Color> getColorListAll();

    CommonResponseDto registerProduct(ProductDto.Register register);

    CommonResponseDto registerSize(SizeDto.Info info);

    CommonResponseDto registerColor(ColorDto.Info info);








}
