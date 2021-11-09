package com.example.hikeu

import android.provider.ContactsContract
import androidx.room.*


@Dao
interface HikeuDao {

    //////////////////OfficialTrails//////////////////
    @Query("Select * from OfficialTrails")
    suspend fun getAllOfficialTrails(): List<OfficialTrails>

    @Query("Select * from OfficialTrails where id=:id")
    suspend fun getOfficialTrailById(id: Int): OfficialTrails

    @Insert
    suspend fun addOfficialTrail(officialTrail: OfficialTrails) : Long

    @Update
    suspend fun updateOfficialTrail(officialTrail: OfficialTrails)

    @Delete
    suspend fun deleteOfficialTrail(officialTrail: OfficialTrails)


    //////////////////UnOfficialTrails//////////////////
    @Query("Select * from UnOfficialTrails")
    suspend fun getAllUnOfficialTrails(): List<UnOfficialTrails>

    @Query("Select * from UnOfficialTrails where id=:id")
    suspend fun getUnOfficialTrailById(id: Int): UnOfficialTrails

    @Insert
    suspend fun addUnOfficialTrail(unOfficialTrail: UnOfficialTrails) : Long

    @Update
    suspend fun updateUnOfficialTrail(unofficialTrail: UnOfficialTrails)

    @Delete
    suspend fun deleteUnOfficialTrail(unofficialTrail: UnOfficialTrails)

    //////////////////Users//////////////////
    @Query("Select * from Users")
    suspend fun getAllUsers(): List<Users>

    @Query("Select * from Users where id=:id")
    suspend fun getUserById(id: Int): Users

    @Insert
    suspend fun addUser(user: Users) : Long

    @Update
    suspend fun updateUser(user: Users)

    @Delete
    suspend fun deleteUser(user: Users)

}