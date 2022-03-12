package com.sam.csi_user_kotlin.repository

//import com.sam.csi_user_kotlin.entity.UserEntity
import com.sam.csi_user_kotlin.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

/**
 * UserRepository 繼承JpaRepository對資料庫進行數據持久化操作
 *
 * @author SamChen
 */
@Repository
interface UserRepository : JpaRepository<User,Int> {

    /**
     * 列出enabled=true的使用者
     *
     * @author SamChen
     * @version 1
     * @CreateDate 2021-07-13
     */
    @Query("select user from User user where user.enabled = true ")
    fun findAllByEnabled(): List<User>?

    /**
     * 列出enabled=false的使用者
     *
     * @author SamChen
     * @version 1
     * @CreateDate 2021-07-13
     */
    @Query("select user from User user where user.enabled = false ")
    fun findAllByUnabled(): List<User>?


    /**
     * 把enabled狀態改成true已啟用使用者
     * 必須加@Transactional和@Modifying，來代表這是一個事務級別的操作
     *
     * @author SamChen
     * @version 1
     * @CreateDate 2021-07-13
     */
    @Transactional
    @Modifying
    @Query("update User user SET user.enabled = true where user.id = :id")
    fun setEnabledtoTrue(@Param("id") id: Int)
}