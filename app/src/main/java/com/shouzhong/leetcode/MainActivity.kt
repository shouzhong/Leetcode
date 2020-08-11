package com.shouzhong.leetcode

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.blankj.utilcode.util.BusUtils
import com.blankj.utilcode.util.LogUtils
import com.shouzhong.tensor.TensorUtils
import org.tensorflow.lite.Interpreter

class MainActivity : AppCompatActivity() {
    var interpreter: Interpreter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Thread {
            interpreter = TensorUtils.getInterpreter(this)
            val out = TensorUtils.decode(interpreter, BitmapFactory.decodeResource(resources, R.drawable.a), 6)
            LogUtils.e(out == null)
            out?.forEach {
                LogUtils.e(it)
            }
        }.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        TensorUtils.release(interpreter)
        interpreter = null
    }
}