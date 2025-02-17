package com.example.lbg_assessment.core.common

import com.example.lbg_assessment.data.model.ProductListDTO
import com.example.lbg_assessment.domain.model.ProductItem

fun ProductListDTO.toProductList() : ProductItem {
    return ProductItem(id = this.id, image= this.image, title = this.title, description= this.description)
}