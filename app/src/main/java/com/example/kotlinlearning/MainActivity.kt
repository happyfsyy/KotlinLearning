package com.example.kotlinlearning

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

/**
 * 参考链接：https://www.kotlincn.net/docs/reference/basic-syntax.html
 * 基础语法
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init_text.textSize=16f
        init_text.setText(R.string.hello_kotlin)
        init_text.setTextColor(resources.getColor(R.color.red))
        Log.e("sum: ",sum(1,2).toString())
        Log.e("sum2: ",sum2(2,3).toString())
        logSum(3,4)
        logSum2(5,6)
        logVariable()
        logString()
        Log.e("maxOf：", maxOf(1,2).toString())
        Log.e("maxOf2: ",maxOf2(2,3).toString())
        logProduct()
        logStringLength()
        logFor()
        logFor2()
        printDescribe()
        checkRange()
        checkListRange()
        logFor3()
        logFor4()
        checkIsInItems()
        listFilterMap()
    }

    /** 带有两个Int参数、返回Int的函数 */
    private fun sum(a:Int,b:Int):Int{
        return a+b
    }
    // 将表达式作为函数体、返回值类型自动推断的函数
    fun sum2(a:Int,b:Int)=a+b
    //函数返回无意义的值：
    fun logSum(a:Int,b:Int):Unit{
        Log.e("logSum: ",(a+b).toString())
    }
    //Unit返回类型可以省略
    //这里的$标识，只适合在""双引号之下，字符串之中，如果直接log.e($a)会报错，还是应该使用a.toString
    fun logSum2(a:Int,b:Int):Unit{
        Log.e("logSum2: ","$a+$b= ${(a+b)}")
    }
    //定义变量
    fun logVariable(){
        val a:Int =1
        val b=2;
        val c:Int
        c=3
        //直接出错，ide提示val不能重新赋值
//        c+=1
        var x=5;
        x+=1;
        Log.e("logVariable: ","a=$a,b=$b,c=$c,x=$x")
    }
    //使用字符串模板
    fun logString(){
        var a=1
        val s1="a is $a"
        a=2
        val s2="${s1.replace("is","was")},but now is $a"
        Log.e("logString:","s1=$s1,s2=$s2")
    }
    //使用条件表达式
    fun maxOf(a:Int,b: Int):Int{
       return if (a>b) a else b
    }
    //使用if作为表达式，有点类似java中的三元运算符a>b?a:b
    fun maxOf2(a:Int,b:Int)=if(a>b) a else b
    //当某个变量的值可以为null的时候，必须在声明处的类型后添加？来标示该引用可为空
    //定义变量的时候是var a:Int?=b，同样，定义函数的时候也可以这样
    fun parseInt(str:String):Int?{
        return str.toIntOrNull()
    }
    fun printProduct(arg1:String,arg2:String){
        val x=parseInt(arg1)
        val y=parseInt(arg2)
        //直接显示错误，不允许非空
//        val z=x*y
        if(x!=null&&y!=null){
            Log.e("x*y=","${x*y}")
        }else{
            Log.e("error","either '$arg1' or '$arg2' is not a number")
        }
    }
    fun logProduct(){
        printProduct("6","7")
        printProduct("a","6")
        printProduct("a","b")
    }

    //is运算符检测一个表达式是否某类型的一个实例。
    //如果一个不可变的局部变量或属性已经判断出为某类型，那么检测后的分支中可以直接当作该类型使用，无需显示转换。
    fun getStringLength(obj:Any):Int?{
        if(obj is String){
            //obj在该条件分支内自动转换成String
            return  obj.length
        }
        //在离开类型检测分支后，obj仍然是Any类型
        return null
    }
    //打印结果显示，这里的null居然也可以调用toString()，直接返回“null”
    fun logStringLength(){
        Log.e("stringLength",getStringLength("xdafdflasdfadf").toString())
        Log.e("null Length",getStringLength(1000).toString())
    }
    //使用for循环，使用集合，对集合进行迭代
    fun logFor(){
        val items= listOf("apple","banana","grape","orange")
        for(item in items){
            Log.e("logFor ",item)
        }
    }
    fun logFor2(){
        val items= listOf("apple","orange")
        for(index in items.indices){
            Log.e("logFor2 ","item at $index is ${items[index]}")
        }
    }
    //使用when表达式，有点类似switch，但是这里是表达式
    fun describe(obj:Any):String=
            when(obj){
                1 -> "One"
                "Hello" -> "Greeting"
                is Long  ->
                    if(obj>100) "Long" else "Short"
                !is Long -> "Not a String"
                else -> "UnKnown"
            }
    //打印结果显示，这里的describe(100L)结果是short
    fun printDescribe(){
        Log.e("describe(1)",describe(1))
        Log.e("describe(Hello)",describe("Hello"))
        Log.e("describe(100L)",describe(100L))
        Log.e("describe(1000L)",describe(1000L))
        Log.e("describe(100)",describe(100))
        Log.e("describe(other)",describe("other"))
    }
    //使用in运算符来检测某个数字是否在指定区间内
    //打印结果显示，1和10都在1..10的范围内
    fun checkRange(){
        val a=1
        val x=10
        val y=9
        if(x in 1..y+1){
            Log.e("$x is or not in 1..${y+1}","fits in range")
        }
        if(a in 1..y+1){
            Log.e("$a is or not in 1..${y+1}","fits in range")
        }
    }
    //检测某个数字不在某个区间，在指定区间外
    fun checkListRange(){
        //这里的list是只读的
        //list.indices返回0..size-1的区间
        var list= listOf("a","b","c")
        if(-1 !in 0..list.lastIndex){
            Log.e("checkListRange","-1 is out of range")
        }
        if(list.size !in list.indices){
            Log.e("checkListRange","list size is out of valid indices range")
        }
    }
    //区间迭代，打印结果显示，这里是打印出0到5，并不是0到4
    fun logFor3(){
        for(i in 0..5){
            Log.e("logFor3()",i.toString())
        }
    }
    //数列迭代，可以看出这里的step就是for循环的第三个条件i++
    //打印结果：0,2,4,6,8,10以及9,6,3,0
    fun logFor4(){
        for(x in 0..10 step 2){
            Log.e("0..10 step 2 ",x.toString())
        }
        for(x in 9 downTo 0 step 3){
            Log.e("9 downTo 0 step 3","$x")
        }
    }
    //使用in运算符来判断集合内是否包含某实例
    //这里的when表达式，真的像switch case，我如果将第一个orange采用！in items
    //那么，打印结果就直接显示,orange is not in items，而不去继续执行apple的语句
    fun checkIsInItems(){
        val items= setOf("apple","banana","grape")
        when{
            "orange" in items ->
                Log.e("check orange","is not in items")
            "apple" in items ->
                Log.e("check apple","is in items")
        }
    }
    //使用lambda表达式来过滤(filter）与映射(map）集合
    fun listFilterMap(){
        val fruits= listOf("apple","banana","asdfgs","csdf","anfa")
        fruits.filter {it.startsWith("a")}
            .sortedBy { it }
            .map { it.toUpperCase() }
            .forEach{ Log.e("fruit",it)}
    }
}