package com.vitrude.athleteperformance.controller

import com.vitrude.athleteperformance.model.PerformanceMetric
import com.vitrude.athleteperformance.service.PerformanceMetricService
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@RestController
@RequestMapping("/api/metrics")
class PerformanceMetricController(private val performanceMetricService: PerformanceMetricService) {

    @GetMapping
    fun getAllMetrics(): ResponseEntity<List<PerformanceMetric>> =
        ResponseEntity.ok(performanceMetricService.getAllMetrics())

    @GetMapping("/{id}")
    fun getMetricById(@PathVariable id: Long): ResponseEntity<PerformanceMetric> =
        ResponseEntity.ok(performanceMetricService.getMetricById(id))

    @GetMapping("/athlete/{athleteId}")
    fun getMetricsByAthlete(@PathVariable athleteId: Long): ResponseEntity<List<PerformanceMetric>> =
        ResponseEntity.ok(performanceMetricService.getMetricsByAthleteId(athleteId))

    @GetMapping("/athlete/{athleteId}/metric/{metricName}")
    fun getMetricsByAthleteAndName(
        @PathVariable athleteId: Long,
        @PathVariable metricName: String
    ): ResponseEntity<List<PerformanceMetric>> =
        ResponseEntity.ok(performanceMetricService.getMetricsByAthleteAndName(athleteId, metricName))

    @GetMapping("/athlete/{athleteId}/dateRange")
    fun getMetricsByDateRange(
        @PathVariable athleteId: Long,
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) startDate: LocalDateTime,
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) endDate: LocalDateTime
    ): ResponseEntity<List<PerformanceMetric>> =
        ResponseEntity.ok(performanceMetricService.getMetricsByAthleteAndDateRange(athleteId, startDate, endDate))

    @PostMapping("/athlete/{athleteId}")
    fun createMetric(
        @PathVariable athleteId: Long,
        @RequestBody metric: PerformanceMetric
    ): ResponseEntity<PerformanceMetric> =
        ResponseEntity.status(HttpStatus.CREATED)
            .body(performanceMetricService.createMetric(athleteId, metric))

    @PutMapping("/{id}")
    fun updateMetric(
        @PathVariable id: Long,
        @RequestBody metricDetails: PerformanceMetric
    ): ResponseEntity<PerformanceMetric> =
        ResponseEntity.ok(performanceMetricService.updateMetric(id, metricDetails))

    @DeleteMapping("/{id}")
    fun deleteMetric(@PathVariable id: Long): ResponseEntity<Unit> =
        ResponseEntity.ok(performanceMetricService.deleteMetric(id))

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(e: NoSuchElementException): ResponseEntity<Map<String, String>> =
        ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(mapOf("error" to (e.message ?: "Not found")))
} 