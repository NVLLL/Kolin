package com.guow.chapter4

/**
 * Created by Administrator on 2018/7/30 0030.
 */
fun main(args: Array<String>) {
    /**
     * is、!is 运算符：用来判断对象是否为特定类型，类似Java的instanceof
     */
    val str = "abc"
    if(str is String) {
        // is 结果为true，kotlin会自动进行类型转换
        println(str.length)
    } else {
        // other
    }

    /**
     * as 显示进行类型转换
     *  - 如果类型不兼容，抛出java.lang.ClassCastException异常
     *  - 使用 as? 运算符，类型不兼容时返回 null
     *  - 在kotlin中，子类型禁止转换为父类型
     */
    val intNumber = 11
//    val s = intNumber as String   // java.lang.ClassCastException
//    println(s.length)
    val s = intNumber as? String
    println(s) // null
}