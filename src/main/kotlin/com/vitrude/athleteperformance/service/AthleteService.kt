package com.vitrude.athleteperformance.service

import com.vitrude.athleteperformance.model.Athlete
import com.vitrude.athleteperformance.repository.AthleteRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
class AthleteService(private val athleteRepository: AthleteRepository) {

    fun getAllAthletes(): List<Athlete> = athleteRepository.findAll()

    fun getAthleteById(id: Long): Athlete = athleteRepository.findById(id)
        .orElseThrow { NoSuchElementException("Athlete not found with id: $id") }

    fun getAthletesBySport(sport: String): List<Athlete> = athleteRepository.findBySport(sport)

    fun searchAthletesByName(name: String): List<Athlete> = athleteRepository.findByNameContainingIgnoreCase(name)

    @Transactional
    fun createAthlete(athlete: Athlete): Athlete = athleteRepository.save(athlete)

    @Transactional
    fun updateAthlete(id: Long, athleteDetails: Athlete): Athlete {
        val existingAthlete = getAthleteById(id)
        return existingAthlete.apply {
            name = athleteDetails.name
            sport = athleteDetails.sport
            updatedAt = LocalDateTime.now()
        }.let { athleteRepository.save(it) }
    }

    @Transactional
    fun deleteAthlete(id: Long) {
        if (athleteRepository.existsById(id)) {
            athleteRepository.deleteById(id)
        } else {
            throw NoSuchElementException("Athlete not found with id: $id")
        }
    }
} 