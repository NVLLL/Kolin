package com.guow.chapter4

fun main(args: Array<String>) {
    /**
     * Char
     *  - Char不属于数字类型，而且kotlin不支持隐式类型转换。即，在kotlin中不能把声明Char类型的变量赋值给Int类型变量：
     *   * val c: Char = 'A'
     *   * val i: Int = c // error: 在Java中可以
     *  - Char中定义的函数：
     *   * public override fun compareTo(other: Char): Int
     *   * public operator fun plus(other: Int): Char     加(+)
     *   * public operator fun minus(other: Char): Int    减(-)
     *   * public operator fun minus(other: Int): Char
     *   * public operator fun inc(): Char                自增(++)
     *   * public operator fun dec(): Char                自减(--)
     *   * public operator fun rangeTo(other: Char): CharRange
     *   * public fun toByte(): Byte
     *   * public fun toChar(): Char
     *   * public fun toShort(): Short   // 省略其他类型转换函数
     */
    println('A'.compareTo('A'))  // 相等 0
    println('A'.compareTo('B'))  // 不相等 -1
    println('A' + 32)  // 'a'  'A'.plus(32)
    // println('A' + 1L) error:Char只重载了与Int相加的运算

    println('A'.minus('B'))   // -1 等价于:'A' - 'B'
    println('A' - 'B')              // -1

    println('A'.inc())              // 'B'
    // println('A'++) error:不能在字符的字面值上直接使用 ++ 运算符
    var c1 = 'A'
    val b = c1++
    println(b)

    for(char in 'A'.rangeTo('z')) {  // ['A','z']
        println(char)
    }
}