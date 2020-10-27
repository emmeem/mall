package com.junbin.mall.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Coupon {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long Id;

    private String type;

    private String name;

    private Integer count;

    private Integer amount;

    private Date start_time;

    private Date end_time;

    private String note;

    private String companyName;
}
