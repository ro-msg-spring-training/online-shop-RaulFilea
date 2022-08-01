package ro.msg.learning.shop.assemblers;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import ro.msg.learning.shop.controllers.ProductCategoryController;
import ro.msg.learning.shop.entities.ProductCategory;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ProductCategoryAssembler implements RepresentationModelAssembler<ProductCategory, EntityModel<ProductCategory>> {

    @Override
    public EntityModel<ProductCategory> toModel(ProductCategory productCategory) {

        return EntityModel.of(productCategory);
                //linkTo(methodOn(ProductCategoryController.class).one(productCategory.getId())).withSelfRel());
//                linkTo(methodOn(ProductCategoryController.class).all()).withRel("productcategory"));
    }
}