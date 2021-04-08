package com.landkay.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description //TODO
 * @param
 * @author landkay
 * @Date 17:13 2018/8/2
 * @return
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {

    Integer userId;
    String userName;
    Integer age;
}


