package com.guow.chapter5

/**
 * Kotlin 中的集合分为可变(Mutable)和不可变(Immutable)
 *
 * Created by Administrator on 2018/7/30 0030.
 */
fun main(args: Array<String>) {
    /**
     * 创建不可变集合List
     *  - public inline fun <T> listOf(): List<T> = emptyList()
     *  - public fun <T> listOf(element: T): List<T> = java.util.Collections.singletonList(element)
     *  - public fun <T> listOf(vararg elements: T): List<T> = if (elements.size > 0) elements.asList() else emptyList()
     *
     *  不可变集合中没有操作集合的方法(add、remove等)
     */
    val emptyList = listOf<Int>()
    println(emptyList::class)   // class kotlin.collections.EmptyList

    val singletList = listOf("Kotlin")
    println(singletList::class) // class java.util.Collections$SingletonList

    val list = listOf(1,3,4,5)
    println(list::class)        // class java.util.Arrays$ArrayList

//    list.add(7)

    /**
     * 创建可变集合List:
     *  - 方法同创建不可变集合类似，只不过在前面加上mutable
     *  - 另外,arrayListOf() 可以创建一个Java中的ArrayList实例对象
     *  - toMutableList() 可以将一个Immutable的List转为Mutable
     */
    val emptyMutableList = mutableListOf<Int>()
    emptyMutableList.add(888)
    println(emptyMutableList)

    val arrayList = arrayListOf<Int>(1,3,5,7)
    arrayList.add(9)

    val immutableList = listOf(1,4,5)
    val mutableList = immutableList.toMutableList()
    mutableList.add(9)

    /**
     * 遍历集合
     *  - 使用Iterator迭代器
     *  - 使用 forEach
     */
    val mList = mutableListOf(2,4,5)
    val it = mList.iterator()
    while(it.hasNext()) {
        println(it.next()) // 当调用到最后一个元素时，再次调用next()，会抛出java.util.NoSuchElementException
    }

    /**
     * public inline fun <T> Iterable<T>.forEach(action: (T) -> Unit): Unit {
     *   for (element in this) action(element)
     * }
     */
    mList.forEach { println(it) }

    /**
     * 操作集合：
     *  - add
     *    * override fun add(element: E): Boolean                    向List尾部添加元素
     *    * public fun add(index: Int, element: E): Unit             向指定位置处添加元素
     *    * override fun addAll(elements: Collection<E>): Boolean    添加子集合
     *
     *  - remove
     *    * override fun remove(element: E): Boolean                 移除指定的元素
     *    * public fun removeAt(index: Int): E                       移除指定位置上的元素
     *    * override fun removeAll(elements: Collection<E>): Boolean 删除子集合
     *
     *  - set
     *    * public operator fun set(index: Int, element: E): E       更新下标index上的元素
     *
     *  - clear
     *    * override fun clear(): Unit                               清空集合
     *
     *  - retainAll
     *    * override fun retainAll(elements: Collection<E>): Boolean 取两个集合的交集
     *
     *  - contains
     *    * override fun contains(element: @UnsafeVariance E): Boolean 判断集合是否包含指定元素
     *
     *  - elementAt
     *    * public inline fun <T> List<T>.elementAt(index: Int): T {  获取指定位置上的元素，如果下标越界会抛出IndexOutOfBoundsException
                return get(index)
            }
     *    * public inline fun <T> List<T>.elementAtOrElse(index: Int, defaultValue: (Int) -> T): T {  如果下标越界通过defaultValue()求值
                return if (index >= 0 && index <= lastIndex) get(index) else defaultValue(index)
            }
     *    * public inline fun <T> List<T>.elementAtOrNull(index: Int): T? {  如果下标越界返回null
                return this.getOrNull(index)
            }
     */
    val ret = mList.add(7)
    println(ret)
    println(mList)

    val ret2 = mList.add(0,-1)  // 在指定位置处插入元素
    println(ret2::class)                      // class kotlin.Unit
    println(mList)

    val ret3 = mList.remove(-1)
    println(mList)
    println(ret3)

    val rElement = mList.removeAt(0)
    println(rElement)
    println(mList)

    mList.removeAll(listOf(1,4,5)) // 如果 mList 中含有(1,4,5)集合的元素，则删除；如果不含有不做处理，不抛异常
    println(mList)

    mList.addAll(listOf(88,99))
    println(mList)

    mList.set(0,-11)
    println(mList)

    mList.clear()
    println(mList)

    val mList1 = mutableListOf(1,2,3,4,5,6)
    val mList2 = mutableListOf(2,4,7,8)
    mList1.retainAll(mList2)     // 取两个集合的交集
    println(mList1)  // [2,4]

    val r = mList1.contains(3)
    println(r)

    val elementAt = mList1.elementAt(0)
    println(elementAt)

    val firstEle = mList.elementAtOrElse(0,{-1})
    println(firstEle)  // -1

    val fEle = mList.elementAtOrNull(0)
    println(fEle)      // null

    /**
     * 操作集合：
     *  - first
     *    * public fun <T> List<T>.first(): T {  返回集合中的第一个元素，如果集合为空抛出异常NoSuchElementException
                if (isEmpty())
                    throw NoSuchElementException("List is empty.")
                return this[0]
            }
          * public fun <T> List<T>.firstOrNull(): T? {  返回集合中的第一个元素，如果集合为空则返回null
                return if (isEmpty()) null else this[0]
            }
          * public inline fun <T> Iterable<T>.first(predicate: (T) -> Boolean): T {  返回符合条件的第一个元素，没有则抛出异常
                for (element in this) if (predicate(element)) return element
                throw NoSuchElementException("Collection contains no element matching the predicate.")
            }
          * public inline fun <T> Iterable<T>.firstOrNull(predicate: (T) -> Boolean): T? {  返回符合条件的第一个元素，没有则返回null
                for (element in this) if (predicate(element)) return element
                return null
            }
     *
     */
    println("============================ first ==========================")
    val eList = listOf<Int>()
//    println(eList.first())

    val intList = listOf(1,3,5,4,6);
    println(intList.first { it % 2 == 0 })

    intList.firstOrNull()

    /**
     * 操作集合：
     *  - indexOf
     *    * public fun indexOf(element: @UnsafeVariance E): Int   获取元素的下标
     *    * public inline fun <T> List<T>.indexOfFirst(predicate: (T) -> Boolean): Int 获取第一个满足条件的元素下标，如果没有则返回-1
     *    * public inline fun <T> List<T>.indexOfLast(predicate: (T) -> Boolean): Int 获取最后一个满足条件的元素下标，如果没有则返回-1
     *  - lastIndexOf
     *    * public fun lastIndexOf(element: @UnsafeVariance E): Int 返回符合条件的最后一个元素下标
     */
    println("============================ indexOf ==========================")
    val muList = mutableListOf("Java","C++","JavaScript","PHP","C++","Python")
    println(muList.indexOf("Java"))  // 0

    println(muList.indexOfFirst { it.length == 3 }) // 1

    println(muList.indexOfLast { it.startsWith("Java") }) // 2

    println(muList.lastIndexOf("C++")) // 4

    /**
     * 操作集合：
     *  - last
     *    * public fun <T> List<T>.last(): T    获取List中最后一个元素，如果List为空则抛出 NoSuchElementException
     *    * public fun <T> List<T>.lastOrNull(): T?  获取List中最后一个元素，如果List为空则返回null
     */
    println("============================ last ==========================")
    val lList = mutableListOf("Java","C++","JavaScript")
    println(lList.last())   // JavaScript

    lList.clear()
    println(lList.lastOrNull())  // null

    /**
     * 操作集合：
     *  - single
     *    * public fun <T> List<T>.single(): T    如果该集合只有一个元素，则返回该元素；否则抛出异常
     *    * public inline fun <T> Iterable<T>.single(predicate: (T) -> Boolean): T  返回符合条件的唯一元素
     *    * public fun <T> List<T>.singleOrNull(): T?
     *    * public inline fun <T> Iterable<T>.singleOrNull(predicate: (T) -> Boolean): T?
     */
    println("============================ single ==========================")
    val sList = listOf("Single")
    println(sList.single())

    val sList2 = mutableListOf("Java","C++","JavaScript")
    println(sList2.single { it.length == 3 }) // C++
    sList2.singleOrNull()

    println("============================ 函数算子 ==========================")
    /**
     * 集合类的算子：any、all、none、count、reduce、fold、max、min、sum
     *  - any(): Boolean 判断集合至少有一个元素
     *  - any(predicate: (T) -> Boolean): Boolean 判断集合中至少有一个满足条件的元素
     *
     *  - all(predicate: (T) -> Boolean): Boolean 判断集合中是否所有元素都满足条件
     *
     *  - none(): Boolean 如果集合没有任何元素则返回true，否则返回false
     *  - none(predicate: (T) -> Boolean): Boolean 如果集合没有满足条件的元素返回true，否则返回false
     *
     *  - count(): Int 统计集合中元素的个数
     *  - count(predicate: (T) -> Boolean): Int 统计满足条件的元素的个数
     *
     *  - reduce 累计
     *    * public inline fun <S, T: S> Iterable<T>.reduce(operation: (acc: S, T) -> S): S {
                val iterator = this.iterator()
                if (!iterator.hasNext()) throw UnsupportedOperationException("Empty collection can't be reduced.")
                // 首先把第一个元素赋值给累计子accumulator
                var accumulator: S = iterator.next()
                while (iterator.hasNext()) {
                    // 将accumulator和下一个元素传入operation()进行累计计算，并将结果重新赋值给accumulator
                    accumulator = operation(accumulator, iterator.next())
                }
                return accumulator
            }
          * public inline fun <S, T: S> List<T>.reduceRight(operation: (T, acc: S) -> S): S 从最后一项到第一项累计运算
     *       - 从 operation: (T, acc: S) -> S 的定义上可以看出，累计子是放在后面的
     *
     *  - fold  带初始值的累计
     *    * public inline fun <T, R> Iterable<T>.fold(initial: R, operation: (acc: R, T) -> R): R {
                var accumulator = initial  // 将初始值赋值给累计子
                for (element in this) accumulator = operation(accumulator, element)
                return accumulator
            }
          * public inline fun <T, R> List<T>.foldRight(initial: R, operation: (T, acc: R) -> R): R
     *       - 和reduceRight类似
     *
     *  - forEach(action: (T) -> Unit): Unit 遍历集合
     *  - forEachIndexed(action: (index: Int, T) -> Unit): Unit 带下标的元素遍历
     *
     *  - max(): T、min(): T 查询集合中最大/小值， 如果集合为空则返回null
     *  - maxBy(selector: (T) -> R): T?、minBy(selector: (T) -> R): T?
     *    * 返回集合中通过selector映射后结果最大/小的元素(注意：返回的不是selector运算的结果而是集合的元素)
     *
     *  - sum() 对集合元素求和
     *  - sumBy(selector: (T) -> Int): Int 对集合元素通过selector映射后的结果求和
     */
    val eList2 = listOf<String>()
    println(eList2.any())  // false
    println(eList2.none()) // true

    val eList3 = listOf(2,3,4,5)
    println(eList3.any { it < 3 })  // true

    println(eList3.all { it % 2 == 0 }) // false
    println(eList3.count())  // 4
    println(eList3.count { it % 2 == 0 }) // 2

    val eList4 = listOf<Int>(1,2,3,4,5)
    println(eList4.reduce { sum, next -> sum + next }) // 15

    val strList = listOf("a","b","c")
    println(strList.reduceRight { next, ret -> ret + next }) // cba

    println(eList4.fold("Kotlin") { acc, next -> acc + next }) // Kotlin12345
    println(eList4.foldRight("Kotlin") { next, acc -> acc + next }) // Kotlin54321

    eList4.forEach { if(it % 2 != 0) println("$it is odd") }
    eList4.forEachIndexed { index, item -> println("index:$index & value: $item") }

    println(eList4.max()) // 5
    println(eList4.maxBy { it * 2 }) // 5

    println(eList4.sum()) // 15
    println(eList4.sumBy { it * 2 }) // 30


    /**
     * take
     *  - take(n: Int): List<T>、takeLast(n: Int): List<T>  返回集合前/后n个元素组成的子集； 如果n=0，返回空集；如果n>size,返回该集合
     *  - takeWhile(predicate: (T) -> Boolean): List<T>
     *    takeLastWhile(predicate: (T) -> Boolean): List<T>  返回满足条件的元素构成的子集。当遇到不满足条件的元素，终止操作
     */
    println("============================ take ==========================")
    val tList = listOf("a","b","c","d")
    println(tList.take(2)) // ["a","b"]
    println(tList.takeWhile { it.length >= 1 }) // ["a","b","c","d"]

    tList.takeLast(3) // ["b","c","d"]

    /**
     *  drop
     *   - drop(n: Int): List<T>、dropLast(n: Int): List<T> 删除集合前/后n个元素，返回剩下元素构成的子集
     *   - dropWhile(predicate: (T) -> Boolean): List<T>
     *     dropLastWhile(predicate: (T) -> Boolean): List<T> 删除满足条件的元素，返回剩下元素构成的子集。当遇到不满足条件的元素，终止操作
     */
    println("============================ drop ==========================")
    println(tList.drop(2)) // ["c","d"]
    println(tList) // [a, b, c, d]

    val dList = listOf(2,4,5,6,8,9)
    println(dList.dropWhile { it % 2 == 0 }) // [5,6,8,9]

    /**
     * slice
     *  - slice(indices: IntRange): List<T> 截取indices(下标范围)上的元素
     *  - slice(indices: Iterable<Int>): List<T> 截取indices(下标集合)上的元素
     */
    val slList = listOf(1,3,4,5,6,7)
    println(slList.slice(1..3)) // [3,4,5]
    println(slList.slice(1 until 3)) // [3,4]
    println(slList.slice(listOf(2, 4, 5))) // [4,6,7]
}