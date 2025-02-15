package com.vitrude.athleteperformance.service

import com.vitrude.athleteperformance.model.PerformanceMetric
import com.vitrude.athleteperformance.repository.PerformanceMetricRepository
import com.vitrude.athleteperformance.repository.AthleteRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
class PerformanceMetricService(
    private val performanceMetricRepository: PerformanceMetricRepository,
    private val athleteRepository: AthleteRepository
) {

    fun getAllMetrics(): List<PerformanceMetric> = performanceMetricRepository.findAll()

    fun getMetricById(id: Long): PerformanceMetric = performanceMetricRepository.findById(id)
        .orElseThrow { NoSuchElementException("Performance metric not found with id: $id") }

    fun getMetricsByAthleteId(athleteId: Long): List<PerformanceMetric> =
        performanceMetricRepository.findByAthleteId(athleteId)

    fun getMetricsByAthleteAndName(athleteId: Long, metricName: String): List<PerformanceMetric> =
        performanceMetricRepository.findByAthleteIdAndMetricName(athleteId, metricName)

    fun getMetricsByAthleteAndDateRange(
        athleteId: Long,
        startDate: LocalDateTime,
        endDate: LocalDateTime
    ): List<PerformanceMetric> =
        performanceMetricRepository.findByAthleteIdAndDateBetween(athleteId, startDate, endDate)

    @Transactional
    fun createMetric(athleteId: Long, metric: PerformanceMetric): PerformanceMetric {
        val athlete = athleteRepository.findById(athleteId)
            .orElseThrow { NoSuchElementException("Athlete not found with id: $athleteId") }
        
        val newMetric = metric.copy(athlete = athlete)
        return performanceMetricRepository.save(newMetric)
    }

    @Transactional
    fun updateMetric(id: Long, metricDetails: PerformanceMetric): PerformanceMetric {
        val existingMetric = getMetricById(id)
        return existingMetric.apply {
            metricName = metricDetails.metricName
            value = metricDetails.value
            unit = metricDetails.unit
            date = metricDetails.date
            updatedAt = LocalDateTime.now()
        }.let { performanceMetricRepository.save(it) }
    }

    @Transactional
    fun deleteMetric(id: Long) {
        if (performanceMetricRepository.existsById(id)) {
            performanceMetricRepository.deleteById(id)
        } else {
            throw NoSuchElementException("Performance metric not found with id: $id")
        }
    }
} 