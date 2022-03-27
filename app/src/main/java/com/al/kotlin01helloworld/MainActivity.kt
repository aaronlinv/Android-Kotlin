package com.al.kotlin01helloworld

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {
    private lateinit var permissionLauncher: ActivityResultLauncher<Array<String>>
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // 隐藏 ActionBar
        supportActionBar?.hide()
        var tvInfo: TextView = findViewById(R.id.textView)

        permissionLauncher =
            registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {
                permissionCallback(it, tvInfo)
            }

        val btnGetCurrentPermission: Button = findViewById(R.id.buttonCurrent)
        btnGetCurrentPermission.setOnClickListener {
            tvInfo.text = showPermission()
        }
        val btnGetPermission: Button = findViewById(R.id.button)
        btnGetPermission.setOnClickListener {
            requestPermission()
        }
    }

    private fun permissionCallback(permissions: Map<String, Boolean>, tvInfo: TextView) {
        val sb = StringBuffer()

        sb.append("权限回调函数被调用\n")
        permissions.forEach { permission, enabled ->
            sb.append("$permission 是否被被授予 $enabled \n")
        }
        tvInfo.text = sb.toString()
    }

    // 检查电话权限是否被授予
    private fun hasCallPhonePermission() = ActivityCompat.checkSelfPermission(
        this,
        Manifest.permission.CALL_PHONE
    ) == PackageManager.PERMISSION_GRANTED

    private fun hasCameraPermission() = ActivityCompat.checkSelfPermission(
        this,
        Manifest.permission.CAMERA
    ) == PackageManager.PERMISSION_GRANTED


    private fun hasBackgroundLocationPermission() = ActivityCompat.checkSelfPermission(
        this,
        Manifest.permission.ACCESS_BACKGROUND_LOCATION
    ) == PackageManager.PERMISSION_GRANTED


    private fun requestPermission() {
        val permissionToRequestList = mutableListOf<String>()

        if (!hasCallPhonePermission()) {
            permissionToRequestList.add(Manifest.permission.CALL_PHONE)
        }
        if (!hasCameraPermission()) {
            permissionToRequestList.add(Manifest.permission.CAMERA)
        }
        if (!hasBackgroundLocationPermission()) {
            permissionToRequestList.add(Manifest.permission.ACCESS_BACKGROUND_LOCATION)
        }

        myLog("需要获取权限的列表：$permissionToRequestList")

        if (permissionToRequestList.isNotEmpty()) {
            permissionLauncher.launch(permissionToRequestList.toTypedArray())
        }
    }

    private fun showPermission(): String {
        val permissionToRequestList = mutableListOf<String>()

        val sb = StringBuffer()

        sb.append("权限回调函数被调用\n")

        sb.append("CALL_PHONE 是否被被授予 ${hasCallPhonePermission()} \n")
        sb.append("CAMERA 是否被被授予 ${hasCameraPermission()} \n")
        sb.append("ACCESS_BACKGROUND_LOCATION 是否被被授予 ${hasBackgroundLocationPermission()} \n")

        if (!hasCallPhonePermission()) {
            permissionToRequestList.add(Manifest.permission.CALL_PHONE)
        }
        if (!hasCameraPermission()) {
            permissionToRequestList.add(Manifest.permission.CAMERA)
        }
        if (!hasBackgroundLocationPermission()) {
            permissionToRequestList.add(Manifest.permission.ACCESS_BACKGROUND_LOCATION)
        }
        return sb.toString()
    }
}