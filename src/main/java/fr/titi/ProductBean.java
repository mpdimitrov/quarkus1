package fr.titi;

import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.QueryParam;

public class ProductBean {
    @QueryParam("name")
    @DefaultValue("")
    public String name;

    @QueryParam("sort")
    @DefaultValue("price")
    public String sort;
}
