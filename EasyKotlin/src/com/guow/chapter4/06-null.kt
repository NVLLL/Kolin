package com.guow.chapter4

/**
 * Created by Administrator on 2018/7/30 0030.
 */
fun main(args: Array<String>) {
    /**
     * Kotlin中null属于Nothing?
     * 在 kotlin/Library.kt 中定义了null的"+"运算符重载
     *  - public operator fun String?.plus(other: Any?): String
     */
    println(null + 3) // null3
    // 反过来就不行，因为在Int中没有重载传入null参数的 plus()
//    println(3 + null) // error

    /**
     * 声明可为null的变量o
     */
    val str: String? = null

    println(getLength(str)) // null
//    println(getLen(str))  // error: kotlin.KotlinNullPointerException
}

/**
 * 非空调用：?.
 *  - 如果str为null则返回null
 */
fun getLength(str: String?) = str?.length

/**
 * 非空断言：!!
 *  - 如果str为null则抛出NPE
 */
fun getLen(str: String?) = str!!.length