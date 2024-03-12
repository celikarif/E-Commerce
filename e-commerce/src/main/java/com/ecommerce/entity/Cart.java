package com.ecommerce.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="cart")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class Cart extends Base{

    @Column(name = "total_amount")
    private Double totalAmount;

    @OneToMany(mappedBy = "cart" ,  cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Product> products;

    @OneToMany(mappedBy = "cart" , fetch = FetchType.EAGER )
    @JsonBackReference
    private List<Order> orders;

    @JsonBackReference
    @OneToOne(mappedBy = "cart")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Customer customer;


    @Override
    public String toString() {
        return "Cart{" +
                "id=" + getId() +
                ", totalAmount=" + totalAmount +
                '}';
    }



}

