package com.lwf.pojo.vo;

import com.lwf.pojo.User;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author lwf
 * @title: LayUiMsg
 * @projectName 11_24springMVC
 * @description: TODO
 * @date 2020/11/2617:20
 */
@Data
public class LayUiMsg implements Serializable {
    private Integer code;
    private String msg;
    private Integer count;
    private List<User> data;
}
