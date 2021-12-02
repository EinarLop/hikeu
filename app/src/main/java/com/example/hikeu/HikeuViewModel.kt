package com.example.hikeu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class HikeuViewModel (val hikeuDao: HikeuDao): ViewModel() {
    suspend fun getAllOfficialTrails(): List<OfficialTrails> = hikeuDao.getAllOfficialTrails()
    suspend fun getOfficialTrailById(id: Int): OfficialTrails = hikeuDao.getOfficialTrailById(id)
    suspend fun addOfficialTrail(officialTrail: OfficialTrails) : Long = hikeuDao.addOfficialTrail(officialTrail)
    suspend fun updateOfficialTrail(officialTrail: OfficialTrails) = hikeuDao.updateOfficialTrail(officialTrail)
    suspend fun deleteOfficialTrail(officialTrail: OfficialTrails) = hikeuDao.deleteOfficialTrail(officialTrail)

    suspend fun getAllUnOfficialTrails(): List<UnOfficialTrails> = hikeuDao.getAllUnOfficialTrails()
    suspend fun getUnOfficialTrailById(id: Int): UnOfficialTrails = hikeuDao.getUnOfficialTrailById(id)
    suspend fun addUnOfficialTrail(unOfficialTrail: UnOfficialTrails) : Long = hikeuDao.addUnOfficialTrail(unOfficialTrail)
    suspend fun updateUnOfficialTrail(unOfficialTrail: UnOfficialTrails) = hikeuDao.updateUnOfficialTrail(unOfficialTrail)
    suspend fun deleteUnOfficialTrail(unOfficialTrail: UnOfficialTrails) = hikeuDao.deleteUnOfficialTrail(unOfficialTrail)

    suspend fun getAllUsers(): List<Users> = hikeuDao.getAllUsers()
    suspend fun getUserById(id: Int): Users = hikeuDao.getUserById(id)
    suspend fun addUser(user: Users) : Long =hikeuDao.addUser(user)
    suspend fun updateUser(user: Users) = hikeuDao.updateUser(user)
    suspend fun deleteUser(user: Users) = hikeuDao.deleteUser(user)

//    val pruebaRutasList = listOf<OfficialTrails>(
//        OfficialTrails(name="Ruta1", country = "Mexico", state = "Nuevo Leon", googleMapsLink = "google",
//        difficulty = 2, duration = 50, warnings = "cuidado", clothing = "comoda", indispensables = "agua",
//        images = "imagen"),
//        OfficialTrails(name="Ruta2", country = "Mexico", state = "Nuevo Leon", googleMapsLink = "google",
//            difficulty = 3, duration = 110, warnings = "cuidado", clothing = "comoda", indispensables = "agua",
//            images = "imagen"),
//        OfficialTrails(name="Ruta3", country = "Mexico", state = "Nuevo Leon", googleMapsLink = "google",
//            difficulty = 1, duration = 10, warnings = "cuidado", clothing = "comoda", indispensables = "agua",
//            images = "imagen")
//    )

}

class HikeuViewModelFactory(private val hikeuDao: HikeuDao): ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HikeuViewModel::class.java)) {
            @Suppress("UNCHEKED_CAST")
            return HikeuViewModel(hikeuDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
