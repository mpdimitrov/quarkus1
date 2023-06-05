package fr.titi;

import java.util.List;
import java.util.UUID;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Product extends PanacheEntityBase {

    @Id
    @GeneratedValue(generator = "uuid")
    @Schema(readOnly = true)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public UUID id;

    @Size(min = 3, max = 30)
    @NotBlank
    @Column(unique = true, updatable = false, nullable = false, length = 30)
    public String name;

    @Column(nullable = false, columnDefinition = "TEXT")
    public String description = "";

    @NotNull
    @Column(nullable = false)
    public double price = 0;

    public String image;

    public Integer stock = 0;

    public List<String> categories = List.of();

}
