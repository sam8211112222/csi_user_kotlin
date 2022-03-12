package com.sam.csi_user_kotlin.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import javax.sql.DataSource

/**
 * 定義WebSecurityConfig類別
 *
 * @author SamChen
 * @version 1
 * @CreateDate 2021-07-13
 */
@Configuration
@EnableWebSecurity
class WebSecurityConfig() : WebSecurityConfigurerAdapter() {
    @Autowired
    private val dataSource: DataSource? = null

    /**
     * 從DB取得Security需要的登入資訊
     *
     * @author SamChen
     * @version 1
     * @CreateDate 2021-07-13
     */
//    @Throws(Exception::class)
//    override fun configure(auth: AuthenticationManagerBuilder) {
//        auth.jdbcAuthentication().dataSource(dataSource)
//            .usersByUsernameQuery("select username, password, enabled from user_entity where username=?")
//            .authoritiesByUsernameQuery(
//                "select username, authority "
//                        + "from user_entity where username=?"
//            )
//            .passwordEncoder(BCryptPasswordEncoder())
//    }
}