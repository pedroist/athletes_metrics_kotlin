package com.vitrude.athleteperformance.repository

import com.vitrude.athleteperformance.model.Athlete
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AthleteRepository : JpaRepository<Athlete, Long> {
    fun findBySport(sport: String): List<Athlete>
    fun findByNameContainingIgnoreCase(name: String): List<Athlete>
} 