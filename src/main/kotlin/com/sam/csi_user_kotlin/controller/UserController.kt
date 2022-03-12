package com.sam.csi_user_kotlin.controller

import com.sam.csi_user_kotlin.entity.User
import com.sam.csi_user_kotlin.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * 用RestController回傳JSON
 */
@RestController
class UserController(private val userService: UserService) {

//    @GetMapping("/hello")
//    fun hello():String {
//        return "Hello";
//    }

    /**
     * 列出所有User
     */
    @GetMapping("/users")
    fun getAllUsers(): ResponseEntity<MutableList<User>> {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    /**
     * 列出單一User
     */
    @GetMapping("/user/{userId}")
    fun getUser(@PathVariable userId: Int): ResponseEntity<User> {
        val user: User? = userService.getUserById(userId);
        return if (user != null) {
            ResponseEntity(user, HttpStatus.OK);
        } else {
            ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * 新增User
     */
    @PostMapping("/user")
    fun saveUser(@RequestBody user: User): ResponseEntity<User> {

        return ResponseEntity.ok(userService.saveUser(user))
    }

    /**
     * 更新User
     */
    @PutMapping("/user/{userId}")
    fun updateUser(
        @PathVariable userId: Int,
        @RequestBody user: User
    ): ResponseEntity<User> {
        val user: User? = userService.getUserById(userId);
        return ResponseEntity.ok(user?.let { userService.updateUser(it) });
    }

    /**
     * 刪除User
     */
    @DeleteMapping("/user/{userId}")
    fun deleteUser(@PathVariable userId: Int): ResponseEntity<Any> = userService
        .getUserById(userId)
        .run {
            this ?: return ResponseEntity<Any>(null, HttpStatus.NOT_FOUND)
        }
        .run { return ResponseEntity<Any>(null, HttpStatus.NO_CONTENT) }
}