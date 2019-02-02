package com.example.kotlinlearning

import android.content.Context
import android.util.AttributeSet
import android.view.View

class Invoice{
}
class Empty

class Person constructor(firstName:String){
}
class Person2 (firstName: String){
}
class InitOrderDemo(name:String){
    val firstProperty="第一个属性:$name".also(::error)
    init {
        LogUtil.e("第一个初始化块，打印name:$name")
    }
    val secondProperty="第二个属性:${name.length}".also(::error)
    init {
        LogUtil.e("第二个初始化块，打印name.length:${name.length}")
    }
}
class Customer(name:String){
    //Property is explicitly assigned to parameter name,can be declared directed in constructor instead
    val name=name
}
class Person3(private var firstname:String,val lastName:String,var age:Int){
}
class Customer2 public constructor(name:String){
}
class PersonAdd{
    var children= arrayListOf<PersonAdd>()
    constructor(parent: PersonAdd){
        parent.children.add(this)
    }
}
class Person4(var name:String){
    var children= arrayListOf<Person4>()
    constructor(name1:String, parent:Person4):this(name1){
        parent.children.add(this)
    }
}
class Person5(var name:String){
    init {
        LogUtil.e("初始化块，年龄")
    }
    var age:Int=-1
    var children= arrayListOf<Person5>()
    constructor(name1: String,age1:Int):this(name1){
        LogUtil.e("构造器->姓名年龄")
        age=age1
    }
    constructor(name2:String,age2:Int,parent: Person5):this(name2,age2){
        LogUtil.e("构造器->姓名年龄父亲")
        parent.children.add(this)
    }
}
class Constructors{
    init {
        LogUtil.e("Constructors","初始化块")
    }
    constructor(i:Int){
        LogUtil.e("Constructors","构造器")
    }
}
class DontCreateMe private constructor()
class Customer3(var customerName:String="ale")
open class Base(p:Int)
open class Base2
class Derived(p:Int):Base(p){
    //Base必须有open修饰，否则就是final，无法被继承
}
class Derived2:Base2(){
    //Base2()->Base2，直接提示This type has a constructor,and thus must be initialized here
}
class MyView:View{
    constructor(ctx:Context):super(ctx)
    constructor(ctx:Context,attrs:AttributeSet):super(ctx,attrs){
    }
}
open class Base3{
    open fun v(){}
    fun nv(){}
}
class Derived3:Base3(){
    override fun v(){}
    //'nv' in Base3 is final and cannot be overridden
    //override fun nv(){}
}
open class AnotherDerived:Base3(){
    final override fun v() {}
}