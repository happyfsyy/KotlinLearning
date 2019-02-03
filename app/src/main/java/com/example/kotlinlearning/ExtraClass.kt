package com.example.kotlinlearning

interface MyInterface{
    var name:String
    fun bar()
    fun foo(){
    }
}
class Child:MyInterface{
    override var name: String
        get()=""
        set(value) {}
    override fun bar() {
        //方法体
    }
}
interface MyInterface2{
    val prop:Int //public abstract
    val propertyWithImplementation:String get()="foo"//public open
    fun foo(){
        LogUtil.e(prop)
    }
}
class Child2:MyInterface2{
    override val prop: Int=29
}
interface Named{
    val name:String
}
interface PersonImpl:Named{
    val firstName:String
    val lastName:String
    override val name:String get()="$firstName $lastName"
}
class Employee(
    override val firstName:String,
    override val lastName:String,
    val position:String):PersonImpl{
}
interface A1{
    fun a()
    fun a1(){LogUtil.e("a1")}
    fun foo(){LogUtil.e("A1")}
    fun bar()
}
interface B1{
    fun b()
    fun b1(){LogUtil.e("b1")}
    fun foo(){LogUtil.e("B1")}
    fun bar(){LogUtil.e("B1:bar")}
}
class C1:A1{
    override fun a(){LogUtil.e("C1:a")}
    override fun bar(){LogUtil.e("C1:bar")}
}
class D1:A1,B1{
    override fun a() {}
    override fun b() {}
    override fun foo() {
        super<A1>.foo()
        super<B1>.foo()
    }
    override fun bar() {
        super<B1>.bar()
    }
}
class Outer{
    val bar:Int=1
    class Nested{
        fun foo()=2
    }
}
class Outer2{
    val bar:Int=1
    inner class Inner{
        fun foo()=bar
    }
}