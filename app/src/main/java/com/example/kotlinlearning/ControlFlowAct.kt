package com.example.kotlinlearning

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

/**
 * 控制流(if表达式，when表达式，for循环，while循环）
 * 返回和跳转(break，continue，return以及标签处返回）
 * 参考链接：https://www.kotlincn.net/docs/reference/control-flow.html
 * https://www.kotlincn.net/docs/reference/returns.html
 */
class ControlFlowAct:AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        testIf()
        testWhen(3)
        Log.e("hasPrefix",hasPrefix("xx").toString())
        testWhen2(10)
        testFor()
        testWhile2()
        testDoWhile()
        testBreakLabel()
        testReturnLabel()
        testReturnLabel2()
        testReturnLabel3()
        testReturnLabel4()
    }

    fun testIf(){
        var a=3
        var b=4
        var max=a
        if(a<b) max=b

        var max2:Int
        if(a>b){
            max2=a
        }else{
            max2=b
        }

        var max3=if(a>b) a else b

        Log.e("testIf","max=$max")
        Log.e("testIf","max2=$max2")
        Log.e("testIf","max3=$max3")
        var max4=if(a>b){
            Log.e("testIf","Choose a")
            a
        }else{
            Log.e("testIf","Choose b")
            b
        }
        Log.e("testIf","max4=$max4")
    }
    fun testWhen(x:Int){
        when(x){
            1->Log.e("testWhen","x=1")
            2->Log.e("testWhen","x=2")
            else->{
                Log.e("testWhen","x is neither 1 nor 2")
            }
        }
        when(x){
            1,2->Log.e("testWhen","x==1 or x==2")
            else->Log.e("testWhen","otherwise")
        }
        var s="1"
        when(x){
            parseInt(s)->Log.e("testWhen","s encodes x")
            else->Log.e("testWhen","s does not encode x")
        }
        when(x){
            in 1..10->Log.e("testWhen","x is in the range")
            !in 10..20->Log.e("testWhen","x is outside the range")
            else->Log.e("testWhen","none of the above")
        }
    }
    fun parseInt(s:String):Int{
        return s.toInt()
    }
    fun hasPrefix(x:Any)=when(x){
        is String->x.startsWith("prefix")
        else->false
    }
    fun testWhen2(x:Int){
        when{
            isOdd(x)->Log.e("testWhen2","$x is odd")
            !isOdd(x)->Log.e("testWhen2","$x is even")
            else->Log.e("testWhen2","x if funny")
        }
    }
    fun isOdd(x:Int)=x%2==0
    fun testFor(){
        var collection= arrayOf("1",22,"3")
        for(item in collection)
            Log.e("array",item.toString())
        val ints:IntArray= intArrayOf(4,5,6)
        for(item:Int in ints){
            Log.e("array",item.toString())
        }
        for(i in 1..3){
            Log.e("range",i.toString())
        }
        for(i in 6 downTo 0 step 2){
            Log.e("range","$i")
        }
        var array= arrayOf("a","b","c")
        for(i in array.indices){
            Log.e("indices",array[i])
        }
        for((index,value)in array.withIndex()){
            Log.e("indices","the element at $index is $value")
        }
    }

    /** 原来，函数的参数肯定就是不变的了。。。
     * var on fuction parameter is not allowed */
    fun testWhile( x:Int){
        while(x>0){
            Log.e("while","x=$x")
            //val cannot be reassigned
            //x--
        }
    }
    fun testWhile2(){
        var x:Int=3
        while(x>0){
            Log.e("testWhile2",x.toString())
            x--
        }
    }
    fun testDoWhile(){
        var num=3;
        do{
            var y:String?="dd"
            if(num==0){
                y=null
            }else{
                Log.e("testDoWhile","num=$num")
                num--
            }
        }while(y!=null)
    }
    fun testBreakLabel(){
        loop@ for(i in 1..5){
            for(j in 1..5){
                Log.e("testBreakLabel","i=$i,j=$j")
                if(i==1&&j==2){
                    break@loop
                }
            }
        }
    }
    fun testReturnLabel(){
        listOf(1,2,3,4,5).forEach {
            if(it==3) return
            Log.e("testReturnLabel",it.toString())
        }
        Log.e("testReturnLabel","到不了这里咯")
    }
    fun testReturnLabel2(){
        listOf(1,2,3,4,5).forEach{
            if(it==3) return@forEach
            Log.e("testReturnLabel2",it.toString())
        }
        Log.e("testReturnLabel2","真能到这里")
    }
    fun testReturnLabel3(){
        listOf(1,2,3,4,5).forEach(fun(value:Int){
            if(value==3) return
            Log.e("testReturnLabel3",value.toString())
        })
        Log.e("testReturnLabel3","加了个匿名函数替代lambda表达式")
    }
    fun testReturnLabel4(){
        run loop@{
            listOf(1,2,3,4,5).forEach{
                if (it==3) return@loop
                Log.e("testReturnLabel4",it.toString())
            }
        }
        Log.e("testReturnLabel4","这种外层嵌套lambda蛮靠谱的")
    }
}
