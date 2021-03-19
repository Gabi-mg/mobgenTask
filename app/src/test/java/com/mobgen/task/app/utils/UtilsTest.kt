package com.mobgen.task.app.utils

import com.mobgen.task.data.network.model.CategoryData
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class UtilsTest{

    private lateinit var serviceDateString: String


    @Before
    fun setUp() {
        serviceDateString = "2021-03-19T20:00:00"
    }

    @Test
    fun getPatternFormatFromDateString(){
        val date = Utils.getPatternFormatFromDateString(serviceDateString)
        Assert.assertEquals(date, "19/03/2021")
    }

}