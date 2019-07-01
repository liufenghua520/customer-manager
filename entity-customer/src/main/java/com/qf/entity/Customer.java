package com.qf.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id ;
    private String username ;
    private String password ;
    private String nickname ;
    private String email ;

    @TableField(exist = false)
    private int code ;

}
