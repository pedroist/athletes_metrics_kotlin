package com.vitrude.athleteperformance.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "athlete")
data class Athlete(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    var name: String,

    @Column(nullable = false)
    var sport: String,

    @OneToMany(mappedBy = "athlete", cascade = [CascadeType.ALL], orphanRemoval = true)
    val performanceMetrics: MutableList<PerformanceMetric> = mutableListOf(),

    @Column(name = "created_at")
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "updated_at")
    var updatedAt: LocalDateTime = LocalDateTime.now()
) 