package org.hchery.treeleaf

/**
 * DATE: 2024/5/13
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */

open class Tuple2<T0, T1>(
    private val v1: T0,
    private val v2: T1
) {
    operator fun component1() = v1
    operator fun component2() = v2
}

open class Tuple3<T0, T1, T2>(
    v1: T0,
    v2: T1,
    private val v3: T2
) : Tuple2<T0, T1>(v1, v2) {
    operator fun component3() = v3
}

open class Tuple4<T0, T1, T2, T3>(
    v1: T0,
    v2: T1,
    v3: T2,
    private val v4: T3
) : Tuple3<T0, T1, T2>(v1, v2, v3) {
    operator fun component4() = v4
}

open class Tuple5<T0, T1, T2, T3, T4>(
    v1: T0,
    v2: T1,
    v3: T2,
    v4: T3,
    private val v5: T4
) : Tuple4<T0, T1, T2, T3>(v1, v2, v3, v4) {
    operator fun component5() = v5
}

open class Tuple6<T0, T1, T2, T3, T4, T5>(
    v1: T0,
    v2: T1,
    v3: T2,
    v4: T3,
    v5: T4,
    private val v6: T5
) : Tuple5<T0, T1, T2, T3, T4>(v1, v2, v3, v4, v5) {
    operator fun component6() = v6
}

open class Tuple7<T0, T1, T2, T3, T4, T5, T6>(
    v1: T0,
    v2: T1,
    v3: T2,
    v4: T3,
    v5: T4,
    v6: T5,
    private val v7: T6,
) : Tuple6<T0, T1, T2, T3, T4, T5>(v1, v2, v3, v4, v5, v6) {
    operator fun component7() = v7
}

open class Tuple8<T0, T1, T2, T3, T4, T5, T6, T7>(
    v1: T0,
    v2: T1,
    v3: T2,
    v4: T3,
    v5: T4,
    v6: T5,
    v7: T6,
    private val v8: T7,
) : Tuple7<T0, T1, T2, T3, T4, T5, T6>(v1, v2, v3, v4, v5, v6, v7) {
    operator fun component8() = v8
}

fun <T0, T1> tuple(v1: T0, v2: T1) =
    Tuple2(v1, v2)

fun <T0, T1, T2> tuple(v1: T0, v2: T1, v3: T2) =
    Tuple3(v1, v2, v3)

fun <T0, T1, T2, T3> tuple(v1: T0, v2: T1, v3: T2, v4: T3) =
    Tuple4(v1, v2, v3, v4)

fun <T0, T1, T2, T3, T4> tuple(v1: T0, v2: T1, v3: T2, v4: T3, v5: T4) =
    Tuple5(v1, v2, v3, v4, v5)

fun <T0, T1, T2, T3, T4, T5> tuple(v1: T0, v2: T1, v3: T2, v4: T3, v5: T4, v6: T5) =
    Tuple6(v1, v2, v3, v4, v5, v6)

fun <T0, T1, T2, T3, T4, T5, T6> tuple(v1: T0, v2: T1, v3: T2, v4: T3, v5: T4, v6: T5, v7: T6) =
    Tuple7(v1, v2, v3, v4, v5, v6, v7)

fun <T0, T1, T2, T3, T4, T5, T6, T7> tuple(v1: T0, v2: T1, v3: T2, v4: T3, v5: T4, v6: T5, v7: T6, v8: T7) =
    Tuple8(v1, v2, v3, v4, v5, v6, v7, v8)
