package com.sam.csi_user_kotlin

import com.sam.csi_user_kotlin.service.UserServiceTest
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = arrayOf(CsiUserKotlinApplicationTests :: class),
webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CsiUserKotlinApplicationTests {

    @Test
    fun contextLoads() {
    }

}
