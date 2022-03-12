package com.sam.csi_user_kotlin.service

//import com.sam.csi_user_kotlin.entity.UserEntity
import com.sam.csi_user_kotlin.entity.User
import com.sam.csi_user_kotlin.repository.UserRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

/**
 * 實際在測試方法撰寫中，可以採取 3A 測試原則，如下：
 * Arrange 初始化目標物件、相依物件、方法參數、預期結果
 * Act 執行測試工作單元，取得實際測試結果
 * Assert 驗證結果是否符合預期結果
 */
@SpringBootTest
class UserServiceTest {

    @Autowired
    lateinit var userRepository: UserRepository

    @Autowired
    lateinit var userService: UserService


    @Test
    fun getAllUsersTest() {
        val bcryptPasswordEncoder = BCryptPasswordEncoder()
        // Arrange 初始化測試資料與預期結果
        val expectedResult: MutableList<User> = mutableListOf<User>()
        expectedResult.add(User(1, "Sam Chen", "samchen", "123456", true, "MANAGER"))
        expectedResult.add(User(2, "Morris Mao", "morrismao", "123456", true, "EMPLOYEE"))
        expectedResult.add(User(3, "Yiche Chung", "yichechung", "123456", false, "ADMIN"))

        // Act 執行測試工作單元，取得實際測試結果
        val actual: MutableList<User> = userService.getAllUsers()

        // Assert 驗證結果是否符合預期結果
        assertEquals(expectedResult, actual)

    }

    @Test
    fun getUserByIdTest() {

        // Arrange 初始化測試資料與預期結果
        val expectedResult: User = User(1, "Sam Chen", "samchen", "123456", true, "MANAGER")

        // Act 執行測試工作單元，取得實際測試結果
        val actual: User? = userService.getUserById(1);

        // Assert 驗證結果是否符合預期結果
        assertEquals(expectedResult, actual)
    }

    @Test
    fun saveUserTest() {

        // Arrange 初始化測試資料與預期結果
        val expectedResult: User = User(1, "Sam Chen", "samchen", "123456", true, "MANAGER")

        // Act 執行測試工作單元，取得實際測試結果
        val actual: User? = userService.saveUser(expectedResult);

        // Assert 驗證結果是否符合預期結果
        assertEquals(expectedResult, actual)

    }

    @Test
    fun updateUserTest() {

        // Arrange 初始化測試資料與預期結果
        val expectedResult: User = User(1, "Sam Chen", "samchen", "1234567", true, "MANAGER")

        // Act 執行測試工作單元，取得實際測試結果
        val actual: User? = userService.updateUser(expectedResult);

        // Assert 驗證結果是否符合預期結果
        assertEquals(expectedResult, actual)

    }

    @Test
    fun setEnabledtoTrueTest() {

        // Arrange 初始化測試資料與預期結果
        val expectedResult: User = User(3, "Yiche Chung", "yichechung", "123456", true, "ADMIN")

        // Act 執行測試工作單元，取得實際測試結果
        val actual: User? = userService.setEnabledtoTrue(3)
            .run {
                userService.getUserById(3)
            };

        // Assert 驗證結果是否符合預期結果
        assertEquals(expectedResult, actual)
    }


    @Test
    fun deleteUserTest() {

        // Arrange 初始化測試資料與預期結果
        val expectedResult: User = User(1, "Sam Chen", "samchen", "1234567", true, "MANAGER")

        // Act 執行測試工作單元，取得實際測試結果
        val actual: User? = userService.updateUser(expectedResult);

        // Assert 驗證結果是否符合預期結果
        assertEquals(expectedResult, actual)
    }

}