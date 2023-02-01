package com.example.FashionOnlineShop.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Product")
public class Product {

    public enum ProductSize{
        SMALL,
        MEDIUM,
        LARGE,
        XLARGE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "subtitle")
    private String subtitle;

    @Column(name = "description")
    private String description;

    @Column(name = "quantity")
    private Integer quantity;

    //ToDo:change Integer to BigDecimal
    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Column(name = "product_size")
    @Enumerated(value = EnumType.STRING)
    private ProductSize productSize;

    @Column(name = "is_availability")
    private Boolean isAvailability;

    @CreationTimestamp
    @Column(name = "create_date")
    private LocalDateTime createDate;

    @UpdateTimestamp
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    @Version
    @Column
    private Long version;




}
