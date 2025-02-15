package com.vitrude.athleteperformance.repository

import com.vitrude.athleteperformance.model.PerformanceMetric
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
interface PerformanceMetricRepository : JpaRepository<PerformanceMetric, Long> {
    fun findByAthleteId(athleteId: Long): List<PerformanceMetric>
    fun findByAthleteIdAndMetricName(athleteId: Long, metricName: String): List<PerformanceMetric>
    fun findByAthleteIdAndDateBetween(athleteId: Long, startDate: LocalDateTime, endDate: LocalDateTime): List<PerformanceMetric>
} 