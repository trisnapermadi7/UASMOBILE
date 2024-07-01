package com.example.testuas.data.repository

import com.example.testuas.data.model.User

/**
 * Object responsible for user data operations.
 */
object UserRepository {

    // List to store registered users
    private val users = mutableListOf<User>()

    /**
     * Registers a new user.
     *
     * @param user The user object to register.
     * @return `true` if registration is successful, `false` if the user already exists.
     */
    fun registerUser(user: User): Boolean {
        if (users.any { it.email == user.email }) {
            return false
        }
        users.add(user)
        return true
    }

    /**
     * Authenticates user login.
     *
     * @param email The email of the user.
     * @param password The password of the user.
     * @return `true` if login is successful, `false` if no matching user found or incorrect password.
     */
    fun loginUser(email: String, password: String): Boolean {
        return users.any { it.email == email && it.password == password }
    }
}
