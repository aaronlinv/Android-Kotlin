package com.al.kotlin01helloworld

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * <pre>
 *     author : Aaron
 *     time   : 2022/03/27
 *     desc   :
 *     version: 1.0
 * </pre>
 */
@Parcelize
class User(var name: String, var age: Int) : Parcelable {
    override fun toString(): String {
        return "User(name='$name', age=$age)"
    }
}