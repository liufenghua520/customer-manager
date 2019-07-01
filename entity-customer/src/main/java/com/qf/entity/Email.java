package com.qf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Email implements Serializable {
    private String receiver ;
    private String sender ;
    private String title ;
    private String content ;
    private Date sendTime ;

}
