package eu.dauphine.aows.review.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reviews",
       uniqueConstraints = {
           @UniqueConstraint(name = "uk_review_id_product_id", columnNames = {"id", "product_id"})
       })
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    private String author;

    private String subject;

    private String content;

}
