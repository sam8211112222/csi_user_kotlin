package com.sam.csi_user_kotlin.entity

import javax.persistence.*

/**
 * 使用Kotlin的Data Class 用途類似於JAVA的POJO
 */
@Entity
@Table(name = "user_entity")
data class User(@Id
                // Oracle要設置GenerationType.SEQUENCE
                @GeneratedValue(
                    strategy = GenerationType.SEQUENCE,
                    generator = "user_seq"
                )
                // 這邊的sequenceName對應DB的sequence
                @SequenceGenerator(sequenceName = "userseq", allocationSize = 1, name = "user_seq")
                @Column(name = "ID")
                var id: Int? = null,

                @Column(name = "formalname", nullable = false)
                var formalname: String,

                @Column(name = "username", unique = true)
                var username: String,

                @Column(name = "password", nullable = false)
                var password: String,

                @Column(name = "enabled")
                var enabled: Boolean,

                @Column(name = "authority")
                var authority: String)
