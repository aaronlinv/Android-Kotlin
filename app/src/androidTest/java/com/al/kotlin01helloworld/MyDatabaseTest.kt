package com.al.kotlin01helloworld

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.al.kotlin01helloworld.dao.MyDataDao
import com.al.kotlin01helloworld.db.MyDatabase
import com.al.kotlin01helloworld.helper.DbHelper
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * <pre>
 *     author : Aaron
 *     time   : 2022/04/17
 *     desc   :
 *     version: 1.0
 * </pre>
 */
@RunWith(AndroidJUnit4::class)
class MyDatabaseTest {
    private lateinit var myDataDao: MyDataDao
    private lateinit var db: MyDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context,
            MyDatabase::class.java
        ).build()

        myDataDao = db.myDataDao()
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun addTest() {
        val mydata = DbHelper.createExampleMyData()
        myDataDao.add(mydata)
        myLog("插入的数据：$mydata")
        val objFromDb = mydata.id?.let { myDataDao.findById(it) }
        myLog("读取的数据：$objFromDb")
        Assert.assertNotNull(objFromDb)
    }
}