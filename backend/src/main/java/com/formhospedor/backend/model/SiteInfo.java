package com.formhospedor.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "site_info")
public class SiteInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String siteName;

    @Column
    private String url;

    @ManyToOne
    @JoinColumn(name = "aws_account_info_id")
    private AwsAccountInfo awsAccountInfo;

    public SiteInfo(String siteName, String url, AwsAccountInfo awsAccountInfo) {
        this.siteName = siteName;
        this.url = url;
        this.awsAccountInfo = awsAccountInfo;
    }

}
