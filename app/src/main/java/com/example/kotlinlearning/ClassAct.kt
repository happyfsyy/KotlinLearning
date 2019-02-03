package com.example.kotlinlearning

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * 类与继承：主构造函数，次构造函数，类的实例，继承，覆盖方法
 * 参考链接：https://www.kotlincn.net/docs/reference/classes.html
 */
class ClassAct:AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Invoice()
        Empty()
        Person("")
        Person2("")
        InitOrderDemo("hello")
        var person=Person3("ale","yuan",13)
        person.age=1
        LogUtil.e(person.lastName)
        //这行是错的，声明了次构造函数之后，如果没有主构造函数，编译器不会生成没有参数的主构造函数
        //no value passed for parameter 'parent'
        //var parentdd=PersonAdd()
        //none of the following functions can be called with the argument supplied
//        var person4=Person4()
        var parent=Person4("ale")
        var child=Person4("xiaoxiaole",parent)
        LogUtil.e("parent:${parent.name}")
        LogUtil.e("childrenSize:${parent.children.size}")
        LogUtil.e("child:${child.name}")
        Constructors(1)
        var parent2=Person5("ddd",1)
        LogUtil.e("下面开始定义子孙的变量了")
        var child2=Person5("zz",1,parent2)
        //cannot access <init>:it is private int 'DontCreateMe'
        //DontCreateMe()
        var customer=Customer3()
        LogUtil.e(customer.customerName)
        var d=Derived4("hello","world")
        val bar4=Bar4()
        bar4.f()
        LogUtil.e(bar4.x)
        val baz=bar4.Baz()
        baz.g()
        val c=C()
        c.f()
        c.a()
        c.b()

    }
}


