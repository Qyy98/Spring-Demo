package com.example.springdemo.general.sign;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Signature
 *
 * @Description
 * @Author QianYiyu
 * @Date 2022/08/28 21:50
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Signature {

}
