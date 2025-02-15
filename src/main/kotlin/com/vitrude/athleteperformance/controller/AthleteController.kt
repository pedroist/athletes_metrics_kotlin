package com.vitrude.athleteperformance.controller

import com.vitrude.athleteperformance.model.Athlete
import com.vitrude.athleteperformance.service.AthleteService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/athletes")
class AthleteController(private val athleteService: AthleteService) {

    @GetMapping
    fun getAllAthletes(): ResponseEntity<List<Athlete>> =
        ResponseEntity.ok(athleteService.getAllAthletes())

    @GetMapping("/{id}")
    fun getAthleteById(@PathVariable id: Long): ResponseEntity<Athlete> =
        ResponseEntity.ok(athleteService.getAthleteById(id))

    @GetMapping("/sport/{sport}")
    fun getAthletesBySport(@PathVariable sport: String): ResponseEntity<List<Athlete>> =
        ResponseEntity.ok(athleteService.getAthletesBySport(sport))

    @GetMapping("/search")
    fun searchAthletes(@RequestParam name: String): ResponseEntity<List<Athlete>> =
        ResponseEntity.ok(athleteService.searchAthletesByName(name))

    @PostMapping
    fun createAthlete(@RequestBody athlete: Athlete): ResponseEntity<Athlete> =
        ResponseEntity.status(HttpStatus.CREATED).body(athleteService.createAthlete(athlete))

    @PutMapping("/{id}")
    fun updateAthlete(
        @PathVariable id: Long,
        @RequestBody athleteDetails: Athlete
    ): ResponseEntity<Athlete> =
        ResponseEntity.ok(athleteService.updateAthlete(id, athleteDetails))

    @DeleteMapping("/{id}")
    fun deleteAthlete(@PathVariable id: Long): ResponseEntity<Unit> =
        ResponseEntity.ok(athleteService.deleteAthlete(id))

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(e: NoSuchElementException): ResponseEntity<Map<String, String>> =
        ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(mapOf("error" to (e.message ?: "Not found")))
} 