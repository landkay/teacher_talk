package com.landkay.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 90818
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    public Integer id;
    public String userName;
    public String password;
    public String name;
    public String age;
    public String sex;
    public String birthday;
    public String created;
    public String updated;
}
