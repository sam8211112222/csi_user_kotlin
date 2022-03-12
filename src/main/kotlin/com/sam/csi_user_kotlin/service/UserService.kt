package com.sam.csi_user_kotlin.service

//import com.sam.csi_user_kotlin.entity.UserEntity
import com.sam.csi_user_kotlin.entity.User
import com.sam.csi_user_kotlin.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import java.util.*

/**
 * Service層
 */
@Service
class UserService(private val userRepository: UserRepository) {

    /**
     * 取得所有user
     * @author SamChen
     */
    fun getAllUsers(): MutableList<User> {
        return userRepository.findAll();
    }

    /**
     * 以Id取得單一user
     * @param userId
     * @author SamChen
     */
    fun getUserById(id: Int): User? {

        return userRepository.findByIdOrNull(id);
    }

    /**
     * 新增User
     * @param user
     * @author SamChen
     */
    fun saveUser(user: User): User {
        val bcryptPasswordEncoder = BCryptPasswordEncoder()
        if (user.password.isNotEmpty()) {
            user.password = bcryptPasswordEncoder.encode(user.password)
            return userRepository.save(user)
        } else {
            user.enabled = false
            return userRepository.save(user)
        }
    }

    /**
     * 更新User
     * @param user
     * @author SamChen
     */
    fun updateUser(user: User): User {

        return userRepository.save(user)
    }

    /**
     * 依照userId刪除 user資料
     *
     * @param userId
     * @author SamChen
     */
    fun deleteUser(userId: Int): Boolean = userRepository
        .deleteById(userId)
//        .run { this ?: false }
        .run {
            return try {
//                userRepository.delete(this as User)
                true
            } catch (exception: Exception) {
                false
            }
        }

    /**
     * 依userId啟用User
     *
     * @param userId
     * @return 依userId啟用User
     * @author SamChen
     */
    fun setEnabledtoTrue(id: Int) {
        return userRepository.setEnabledtoTrue(id)
    }
}