package com.guow.chapter4

fun main(args: Array<String>) {
    /**
     * 数组Array：
     */
    val arr = arrayOf(1,2,3)
    println(arr::class)
    println(arr::class.java)

    /**
     * Kotlin 中允许放入不同类型的数据，会自动转为java.lang.Object。
     * 同时，由于kotlin的类型自动推断，我们任然可以看到数据的实际类型
     */
    val arr1 = arrayOf(1, 2, "Kotlin", true)
    arr1.forEach { println(it::class.java) }

    /**
     * arrayOfNulls<reified @PureReifiable T>(size: Int)
     *  - 创建指定大小，所有元素为null的数组
     */
    val arrayOfNulls = arrayOfNulls<Int>(3)
    arrayOfNulls.forEach { println(it) }

    /**
     * 不同于Java，在Kotlin中数组是不型变的，即不能将Array<String>赋值给Array<Any>
     */

    /**
     * 原生数组类型：
     *  BooleanArray
     *  ByteArray
     *  CharArray
     *  ShortArray
     *  IntArray
     *  LongArray
     *  FloatArray
     *  DoubleArray
     * 这些类与Array没有继承关系，但是具有相同的操作方式。他们也有相关的工厂方法：
     *  - booleanArrayOf()
     *  - byteArrayOf()
     *  - charArrayOf()
     *  - ...
     */
}