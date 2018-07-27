package com.guow.chapter4

/**
 * Created by Administrator on 2018/7/27 0027.
 */
fun main(args: Array<String>) {
    /**
     * 布尔类型(Boolean): true | false
     *  - public operator fun not(): Boolean                 // 逻辑非(!)
     *  - public infix fun and(other: Boolean): Boolean      // 短路与(&&)
     *  - public infix fun or(other: Boolean): Boolean       // 短路或(||)
     *  - public infix fun xor(other: Boolean): Boolean      // 异或(^) 相同false，不同true
     *  - public override fun compareTo(other: Boolean): Int
     */
    println(true.not())     // false
    println(false && true)  // false
    println(true and true)  // true   infix:可以使用中缀表达式，等价于 true.and(true)
    println(true || false)  // true
    println(true or false)  // true
    println(true xor true)  // false
    println(false xor false)// false
    println(true xor false) // true

}