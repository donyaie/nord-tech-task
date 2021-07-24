package com.nordpass.tt.storage.todo

import com.nordpass.tt.usecase.Todo
import org.junit.Assert
import org.junit.Before
import org.junit.Test


class TodoMapperTest {

    private lateinit var mapper: TodoMapper

    @Before
    fun setUp() {
        mapper = TodoMapper()
    }


    @Test
    fun testMap_entity_sameOutput() {


        val model = TodoEntity(
            id = 1,
            title = "title",
            isCompleted = false,
            createdAt = "2021-01-13T03:50:03.794+05:30",
            userId = 2,
            updatedAt = "2021-02-13T03:50:03.794+05:30"
        )
        val expect = Todo(
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
    fun testMap_model_sameOutput() {

        val model = Todo(
            id = 1,
            title = "title",
            isCompleted = false,
            createdAt = "2021-01-13T03:50:03.794+05:30",
            userId = 2,
            updatedAt = "2021-02-13T03:50:03.794+05:30"
        )
        val expect = TodoEntity(
            id = 1,
            title = "title",
            isCompleted = false,
            createdAt = "2021-01-13T03:50:03.794+05:30",
            userId = 2,
            updatedAt = "2021-02-13T03:50:03.794+05:30"
        )


        val response = mapper.map(model)

        Assert.assertEquals(expect.id, response.id)
        Assert.assertEquals(expect.createdAt, response.createdAt)
        Assert.assertEquals(expect.isCompleted, response.isCompleted)
        Assert.assertEquals(expect.title, response.title)
        Assert.assertEquals(expect.userId, response.userId)
        Assert.assertEquals(expect.updatedAt, response.updatedAt)



    }


}