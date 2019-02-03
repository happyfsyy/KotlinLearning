package com.example.kotlinlearning

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

/**
 * 接口：定义接口，接口属性，接口函数，接口继承
 * 参考链接：https://www.kotlincn.net/docs/reference/interfaces.html
 * 嵌套类，内部类
 * 参考链接：https://www.kotlincn.net/docs/reference/nested-classes.html
 */
class ExtraClassAct:AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val arg1=Child2()
        LogUtil.e(arg1.propertyWithImplementation)
        arg1.foo()
        val arg2=Employee("ale","yuan","xxx")
        LogUtil.e(arg2.name)
        val d1=D1()
        d1.foo()
        val nestedParam=Outer.Nested().foo()
        val innerParam=Outer2().Inner().foo()
    }
}