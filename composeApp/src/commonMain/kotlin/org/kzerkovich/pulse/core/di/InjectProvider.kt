package org.kzerkovich.pulse.core.di

import org.kzerkovich.pulse.core.database.AppDatabase

object InjectProvider {
    private val dependencies: HashMap<String, Any> = hashMapOf()

    fun addDependency(key: String, dependency: Any) {
        dependencies[key] = dependency
    }


    fun <T> getDependency(key: String): T {
        @Suppress("UNCHECKED_CAST")
        return dependencies[key] as T
    }

    fun getDataBase(): AppDatabase = getDependency("database")
 }