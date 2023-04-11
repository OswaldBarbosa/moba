package br.senai.sp.jandira.triproom.repository

import android.content.Context
import br.senai.sp.jandira.triproom.dao.TripDb
import br.senai.sp.jandira.triproom.model.User

class UserRepository(context: Context) {

    private val db = TripDb.getDataBase(context)

    fun save(user: User): Long {
        return db.userDao().save(user)
    }
    fun findUserByEmail (email: String): User {
        return db.userDao().findUserByEmail(email)
    }
}