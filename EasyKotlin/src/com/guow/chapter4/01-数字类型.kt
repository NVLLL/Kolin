package com.guow.chapter4

/**
 * Created by Administrator on 2018/7/27 0027.
 */
fun main(args: Array<String>) {
    /**
     * Any：Kotlin中所有类型的超类，Any中提供的方法：
     *  - equals() 在kotlin中 == 会被编译器翻译成调用 equals() 函数
     *  - hashCode()
     *  - toString()
     */
    val any = Any()
    println(any)                // java.lang.Object@266474c2
    println(any::class)         // class kotlin.Any
    println(any::class.java)    // class java.lang.Object

    /**
     * Kotlin中没有Java的基本数据类型(如byte,short,int等)，所有类型都是引用类型
     * 数字(Number)类型包括：
     *  - Byte
     *  - Short
     *  - Int
     *  - Long
     *  - Float
     *  - Double
     *
     * 数字类型都继承自Number，在Number中提供了显示的类型转换函数：
     *  - toDouble(): Double
     *  - toFloat(): Float
     *  - toLong(): Long
     *  - toInt(): Int
     *  - toChar(): Char
     *  - toShort(): Short
     *  - toByte(): Byte
     */
    println(123::class)     // class kotlin.Int
    println(123::class.java)// int

    val c: Char = 'A'
    val i: Int = c.toInt()
    println(i) // 65

    /**
     * 运算符重载
     * - kotlin虽然没有隐式类型转换，但是它对一些运算符进行重载可以做适当转换
     * - 下面是Long类型中对运算符"+"的重载
     *   * public operator fun plus(other: Byte): Long
     *   * public operator fun plus(other: Short): Long
     *   * public operator fun plus(other: Int): Long
     *   * public operator fun plus(other: Long): Long
     *   * public operator fun plus(other: Float): Float
     *   * public operator fun plus(other: Double): Double
     */
    val l = 1L + 3    // 编译器会翻译成: 1L.plus(3)
    println(l::class) // Long + Int = Long
    // println(1L + 'A') error: Long类型的plus()函数只接受Byte、Short、Int、Long、Float或Double中的一种作为入参

    /**
     * 位运算符：对于位运算只能通过中缀符号调用
     *  - shl(bits)  有符号左移( << )
     *  - shr(bits)  有符号右移( >> )
     *  - ushl(bits) 无符号左移( <<< )
     *  - and(bits)  位与( & )
     *  - or(bits)   位或( | )
     *  - xor(bits)  位异或( ^ )
     *  - inv()      位非( ! )
     */
    val rl = 1 shl 2
    println(rl)     // 4
    val rr = 1 shr 2
    println(rr)     // 0

    /**
     * 字面值：kotlin中常量的字面值有以下几种
     *  - 十进制：123，3.1415926
     *   * 整数默认为Int类型,Long类型用大写 L 标记
     *   * 浮点数默认为Double类型，Float类型用 f或F 标记
     *  - 十六进制：0x0F
     *  - 二进制：0b00000101
     * kotlin中没有可用八进制表示的的字面值
     *
     */

}
