package com.formhospedor.backend.model;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "aws_account_info")
public class AwsAccountInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String secretKey;

    @Column
    private String accessKey;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser user;

}
