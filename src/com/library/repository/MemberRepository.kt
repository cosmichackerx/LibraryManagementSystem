package com.library.repository

import com.library.data.Member
import com.library.data.enums.MembershipType

class MemberRepository {
    private val members = mutableListOf<Member>()

    fun save(member: Member): Member {
        members.add(member)
        return member
    }

    fun findById(id: String): Member? {
        return members.find { it.id == id }
    }

    fun findByEmail(email: String): Member? {
        return members.find { it.email.equals(email, ignoreCase = true) }
    }

    fun findByName(name: String): List<Member> {
        return members.filter { it.name.contains(name, ignoreCase = true) }
    }

    fun findByMembershipType(type: MembershipType): List<Member> {
        return members.filter { it.membershipType == type }
    }

    fun findActiveMembers(): List<Member> {
        return members.filter { it.isActive } // isActive returns Boolean
    }

    fun findMembersWithOverdueBooks(): List<Member> {
        return members.filter { it.isActive && it.borrowedBooks.isNotEmpty() }
    }

    fun updateMemberStatus(id: String, isActive: Boolean): Boolean {
        val member = findById(id)
        return if (member != null) {
            member.isActive = isActive
            true
        } else false
    }

    fun updateMembershipType(id: String, newType: MembershipType): Boolean {
        val member = findById(id)
        return if (member != null) {
            // Clear borrowed books if new limit is lower
            if (newType.loanLimit < member.borrowedBooks.size) {
                member.borrowedBooks.clear()
            }
            true
        } else false
    }

    fun addBorrowedBook(memberId: String, bookId: String): Boolean {
        val member = findById(memberId)
        return if (member != null && member.canBorrowBooks()) {
            if (member.borrowedBooks.contains(bookId).not()) { // .not() converts Boolean to Boolean
                member.borrowedBooks.add(bookId)
                true
            } else false
        } else false
    }

    fun removeBorrowedBook(memberId: String, bookId: String): Boolean {
        val member = findById(memberId)
        return if (member != null) {
            member.borrowedBooks.remove(bookId) // remove returns Boolean
        } else false
    }

    fun getBorrowingStatistics(): Map<MembershipType, Int> {
        return members.groupingBy { it.membershipType }.eachCount()
    }

    fun getMembersWithHighActivity(minLoans: Int = 5): List<Member> {
        return members.filter {
            it.borrowedBooks.size >= minLoans && it.isActive
        }.sortedByDescending { it.borrowedBooks.size }
    }

    fun searchMembers(criteria: MemberSearchCriteria): List<Member> {
        return members.filter { member ->
            (criteria.name?.let { member.name.contains(it, ignoreCase = true) } ?: true) &&
                    (criteria.email?.let { member.email.contains(it, ignoreCase = true) } ?: true) &&
                    (criteria.membershipType?.let { member.membershipType == it } ?: true)
        }
    }

    fun delete(id: String): Boolean {
        val index = members.indexOfFirst { it.id == id }
        return if (index != -1) {
            members.removeAt(index)
            true
        } else false
    }

    fun getAllMembers(): List<Member> = members.toList()

    fun activateMembersInRange(idStart: Int, idEnd: Int) {
        members.filter { member ->
            val idNum = member.id.removePrefix("M").toIntOrNull()
            idNum != null && (idNum >= idStart && idNum <= idEnd) // Explicit Boolean condition
        }.forEach { it.isActive = true }
    }
}

data class MemberSearchCriteria(
    val name: String? = null,
    val email: String? = null,
    val membershipType: MembershipType? = null
)