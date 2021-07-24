package com.nordpass.tt.api.backend.todo

import com.nordpass.tt.usecase.Todo
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class TodoResponseMapperTest {

    private lateinit var mapper: TodoResponseMapper


    @Before
    fun setUp() {

        mapper = TodoResponseMapper()

    }

    @Test
    fun testMap_sameOutput() {

       val model = TodoResponse().apply {
            id = 1;
            title = "title"
            completed = false
            createdAt = "2021-01-13T03:50:03.794+05:30"
            userId = 2
            updatedAt = "2021-02-13T03:50:03.794+05:30"

        }
        val  expect = Todo(
            id = 1,
            title = "title",
            isCompleted = false,
            createdAt = "2021-01-13T03:50:03.794+05:30",
            userId = 2,
            updatedAt = "2021-02-13T03:50:03.794+05:30"
        )

        val response = mapper.map(model)

        Assert.assertEquals(expect, response)


    }


    @Test
    fun testMap_handleOptionalNullValue() {

        val model = TodoResponse().apply {
            id = 1
            title = "title"
            completed = null
            createdAt = null
            userId = null
            updatedAt =null

        }
        val  expect = Todo(
            id = 1,
            title = "title",
            isCompleted = false,
            createdAt = "",
            userId = 0,
            updatedAt = ""
        )

        val response = mapper.map(model)

        Assert.assertEquals(expect, response)

    }


    @Test
    fun testMap_handleRequiredNullValue() {

        val model = TodoResponse().apply {
            id = null
            title = "title"
            completed = false
            createdAt = "2021-01-13T03:50:03.794+05:30"
            userId = 2
            updatedAt = "2021-02-13T03:50:03.794+05:30"

        }
        val  expect = null

        val response = mapper.map(model)

        Assert.assertEquals(expect, response)

    }
}