package com.vitrude.athleteperformance.model

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "performance_metric")
data class PerformanceMetric(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "athlete_id", nullable = false)
    val athlete: Athlete,

    @Column(nullable = false)
    var metricName: String,

    @Column(nullable = false)
    var value: Double,

    @Column(nullable = false)
    var unit: String,

    @Column(nullable = false)
    var date: LocalDateTime,

    @Column(name = "created_at")
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "updated_at")
    var updatedAt: LocalDateTime = LocalDateTime.now()
) 