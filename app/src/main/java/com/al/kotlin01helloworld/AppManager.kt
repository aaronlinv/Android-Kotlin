package com.al.kotlin01helloworld

import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import java.util.*
import kotlin.system.exitProcess

/**
 * <pre>
 *     author : Aaron
 *     time   : 2022/03/27
 *     desc   :
 *     version: 1.0
 * </pre>
 */
// 避免实例化，单例
class AppManager private constructor() {
    private val activityStack: Stack<Activity> = Stack()

    // 保证只有一个实例运行
    companion object {
        // 延迟委托
        val instance: AppManager by lazy {
            AppManager()
        }
    }

    // 查询数量
    val activityCount: Int
        get() = activityStack.size

    // 追加
    fun addActivity(activity: Activity) {
        activityStack.push(activity)
    }

    // 销毁
    fun finishActivity(activity: Activity) {
        activity.finish()
        activityStack.remove(activity)
    }

    // 当前栈顶
    fun currentActivity(): Activity {
        return activityStack.peek()
    }

    private fun finishAllActivity() {
        for (activity in activityStack) {
            activity.finish()
        }
        activityStack.clear()
    }

    // 清空栈，并杀死进程
    fun exitApp(context: Context) {
        finishAllActivity()

        val activityManager = context.getSystemService(
            Context.ACTIVITY_SERVICE
        ) as ActivityManager
        activityManager.killBackgroundProcesses(context.packageName)
        exitProcess(0)
    }
}