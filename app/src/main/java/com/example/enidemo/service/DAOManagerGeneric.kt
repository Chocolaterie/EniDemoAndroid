package com.example.enidemo.service

import kotlin.reflect.KClass

class DAOManagerGeneric {

    // Une liste d'objets
    var daoList = ArrayList<Any>()

    inline fun <reified T : Any> getDAOByClass(className : KClass<T>): T? {
        // Essayer de trouver la DAO avec le meme nom de classe dans la liste
        for (daoBase in daoList) {
            // Si on trouve :
            if (daoBase.javaClass.kotlin === className) {
                // - return la dao retrouvé
                return daoBase as T
            }
        }
        var myObject = T::class.java.newInstance()

        daoList.add(myObject)

        return myObject;

    }

}