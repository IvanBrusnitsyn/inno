package edu.innotech.inno.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigInteger;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Entity(name = "tpp_product_register")
public class ProductRegister {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @ToString.Exclude
    private Product productId;

    private String type;

    private BigInteger account;

    private String currencyCode;

    private String state;

    private String accountNumber;

//    для времени (Instant) - используем аннотацию @CreationTimestamp - в БД заполнится текущим временем
}
