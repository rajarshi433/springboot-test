package com.jtrac.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "t_comment")
@Table(name = "t_comment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column(nullable = false)
    private String comment;
    private String commentBy;
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "pdn_id", referencedColumnName = "pdnId")
    private PDNEntity pdn;
}
