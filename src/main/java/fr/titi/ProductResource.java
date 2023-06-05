package fr.titi;

import java.util.List;
import java.util.UUID;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;

@Path("/products")
public class ProductResource {

    @GET
    public List<Product> list(@BeanParam ProductBean bean) {
        return Product.find("name like ?1 order by " + bean.sort, "%" + bean.name + "%").list();
    }

    @GET
    @Path("/{id}")
    public Product get(UUID id) {
        return Product.findById(id);
    }

    @POST
    @Transactional
    public Product add(Product product) {
        product.persist();
        return product;
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Product update(UUID id, Product product) {
        Product entity = Product.findById(id);
        entity.name = product.name;
        entity.description = product.description;
        entity.price = product.price;
        entity.image = product.image;
        entity.stock = product.stock;
        return entity;
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public void delete(UUID id) {
        Product entity = Product.findById(id);
        entity.delete();
    }
}
