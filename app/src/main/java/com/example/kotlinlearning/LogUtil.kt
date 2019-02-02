package com.example.kotlinlearning

import android.util.Log

fun error(msg:String){
    Log.e("Log",msg)
}
object LogUtil{
    fun e(msg:String){
        Log.e("LogUtil",msg)
    }
    fun e(msg:Int){
        Log.e("LogUtil",msg.toString())
    }
    fun e(msg: Float){
        Log.e("LogUtil",msg.toString())
    }
    fun e(tag:String,msg:String){
        Log.e(tag,msg)
    }
}