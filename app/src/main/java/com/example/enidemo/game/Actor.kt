package com.example.enidemo.game

import kotlin.reflect.KClass

open class Actor {

    var components: ArrayList<ActorComponent> = arrayListOf()

    inline fun <reified T : ActorComponent> getComponentByClass(className: KClass<T>): T? {
        // Essayer de trouver la DAO avec le meme nom de classe dans la liste
        for (component in components) {
            // Si on trouve :
            if (component.javaClass.kotlin === className) {
                // - return la dao retrouvé
                return component as T
            }
        }
        var component = T::class.java.newInstance()

        components.add(component)

        return component;
    }
}