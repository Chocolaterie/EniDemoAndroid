package com.example.enidemo.game

class Head{

}
class Arm{

}

class Leg{

}

class BodyComponent : ActorComponent(){

    var heads : ArrayList<Head> = arrayListOf();
    var arms :  ArrayList<Arm> = arrayListOf();
    var legs : ArrayList<Leg> = arrayListOf();
    var height = 1.65f;

}