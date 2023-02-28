package com.example.enidemo.game

class ClasseComponent : ActorComponent(){

    var attributes : Map<String, Int> = mapOf( "mp" to 300)

    fun getAttribue(attr: String): Int {
        return attributes.get(attr)!!
    }
 }