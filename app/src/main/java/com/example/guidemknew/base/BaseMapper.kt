package com.example.guidemknew.base


abstract class BaseMapper<T, V> {

    abstract fun map(value: T): V

    abstract fun listMap(list: MutableList<T>): MutableList<V>
}