package com.formhospedor.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
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
