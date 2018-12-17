package com.luoc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author luoc
 * @date 2018/12/6 0006
 * @Time 15:13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String userName;

    private String passWord;
}
