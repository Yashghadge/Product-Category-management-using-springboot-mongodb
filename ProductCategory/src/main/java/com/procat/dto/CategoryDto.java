package com.procat.dto;

import java.util.List;

import lombok.Data;

@Data
public class CategoryDto {
	  private String id;
	  private String name;
	  private List<ProductDto> products;
}
