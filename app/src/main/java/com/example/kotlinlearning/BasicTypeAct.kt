package com.example.kotlinlearning

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlin.math.log

/**
 * 基本类型，数字，字符，布尔，数组，无符号整型，字符串
 * 链接：https://www.kotlincn.net/docs/reference/basic-types.html
 *
 */
class BasicTypeAct:AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        checkEqual()
        explicitTransform()
        bitOperation()
        Log.e("charToInt",decimalDigitValue('8').toString())
        //直接打印出Exception，Out Of Range
//        Log.e("charToInt",decimalDigitValue('a').toString())
        checkBoolean()
        testArray()
        testArray2()
        testArray3()
        testUnsignedNumber()
        testString()
        testString2()
        testString3()
    }

    /**
     * 打印结果是true，true，true，false
     * 可以看出，当我们需要一个可空的引用或者泛型时，会把数字装箱。
     * 同一性就保证不了，但是还是可以保证相等性的。
     */
    fun checkEqual(){
        var a=1000;
        var b:Int=a
        var c:Int?=a
        Log.e("a==b",(a==b).toString())
        Log.e("a===b",(a===b).toString())
        Log.e("a==c",(a==c).toString())
        Log.e("a===c",(a===c).toString())
    }
    /**较小的类型并不能显式转换为较大的类型，但我们可以显式转换来拓宽数字
     * 算数运算有重载做适当转换，类型会根据上下文推断出来 */
    fun explicitTransform() {
        var a:Int = 1
        //直接报错，类型不匹配，Int并不能转换为Long
//        val b:Long=a
        var b=a.toLong()
        var c=1L+3
        Log.e("explicitTransform","b=$b,c=$c")
    }

    /**对于位运算，没有像java那样的<<特殊字符来表示，而只是采用中缀方式来调用命名函数
     * shl：左移，shr：右移，and：位与，or：位或，xor：位异或
     */
    fun bitOperation(){
        var x=1 shl 2
        Log.e("1<<2",x.toString())
        var y=x and 0x000ff000
        Log.e("x&0x",y.toString())
    }
    //字符用char表示，它们不能被直接的当做数字
    fun checkChar(c:Char){
        //operator"=="can not be applied to Char and Int
//        if(c==1){}
    }
    //我们可以显式地把字符转换为数字
    fun decimalDigitValue(c:Char):Int{
        if(c!in '0'..'9'){
            throw IllegalArgumentException("Out of Range")
        }
        return c.toInt()-'0'.toInt()
    }
    //布尔用Boolean类型来表示，它的值有两个true或者false，内置的运算依旧是&&，||，!
    fun checkBoolean(){
        Log.e("true&&false",(true&&false).toString())
    }
    //直接使用库函数arrayOf可以创建数组并传递元素值给它。
    //我们还可以使用库函数arrayOfNulls()创建一个指定大小、所有元素为空的数组
    fun testArray(){
        var a= arrayOf("1","2","3")
        var b= arrayOfNulls<String>(3)
        b[0]="b"
        a[0]="4"
        Log.e("b[0]",b[0])
        for(index in a.indices){
            Log.e("in $index is",a[index])
        }
    }
    /**
     * Array构造函数，需要两个参数，第一个参数代表数组的数量，第二个参数是一个函数
     * 这个用作参数的函数能够返回给定索引的每个元素初始值，也就是int->String
     * 打印结果是0,1,4,9,16
     */
    fun testArray2(){
        var a=Array<String>(5,{i->(i*i).toString()})
        a.forEach { Log.e("testArray2",it) }
    }
    //原生类型数组有ByteArray，ShortArray，IntArray，这些类与Array没有继承关系
    //但是它们有同样的方法属性集，它们也有相应的工厂方法
    fun testArray3(){
        val x:IntArray= intArrayOf(1,2,3)
        x[0]=x[1]+x[2]
        Log.e("x[0]",x[0].toString())
    }

    /**
     * 为使无符号整型更加易于使用，kotlin提供了使用后缀标记整型字面值来表示指定无符号类型
     * 后缀u与U都可以将字面常量标记为无符号，确切类型会根据预期类型来确定。
     * 如果没有提供预期的类型，会根据字面值大小选择UInt或者ULong
     */
    fun testUnsignedNumber(){
        val a:UByte= 1u
        val b:UShort=1u
        val c:UInt=1u
        val d=1u //未提供预期类型，常量使用于UInt
        val e=1uL //后缀UL显式将字面值标记为无符号长整型
        Log.e("unsigned",e.toString())
    }
    /**
     * 字符串用String类型来表示，字符串是不可变的。
     * 字符串的元素（字符）可以使用索引运算符访问;s[i]
     * 还可以使用for循环迭代字符串
     * 可以用+操作符连接字符串。这也适用于连接字符串和其他类型的值，只要表达式中的第一个值是字符串。
     * 大多数情况下，优先使用字符串模板或原始字符串，而不是字符串连接
     */
    fun testString(){
        var str="abcd"
        //No set method providing array access
//        str[0]='1'
        for(a in str){
            Log.e("testString",a.toString())
        }
        var str2=str+1
        Log.e("testString",str2)
        //none of the following functions can be called with the arguments supplied
//        var str3=1+str2
    }

    /**
     * 字符串包含两种，第一种普通字符串，其中可以有转义字符
     * 第二种，原始字符串，使用三个引号括起来，内部没有转义，并且可以包含换行以及任何其他字符
     *
     */
    fun testString2(){
        var s="Hello,world!\n"
        Log.e("testString2",s);
        var s2="""|Tell me and I forget.
            |Teach me and I remember.
            |Involve me and I learn.
            |(Benjamin Franklin)""".trimMargin()
        Log.e("testString2",s2)
        var s3="""abced"""
        for(c in s3){
            Log.e("testString2",c.toString())
        }
    }
    fun testString3(){
        val i=10;
        Log.e("testString3","i=$i")
        val s="abcd"
        Log.e("testString3","$s.length is ${s.length}")
    }
}