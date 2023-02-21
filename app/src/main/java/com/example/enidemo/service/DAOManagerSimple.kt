package com.example.enidemo.service

class DAOManagerSimple {

    lateinit var daoPerson: DAOPerson;
    lateinit var daoArticle: DAOArticle;

    fun getDAOPerson() : DAOPerson{
        if (daoPerson == null){
            daoPerson = DAOPerson()
        }
        return daoPerson
    }

    fun getDAOArticle() : DAOArticle{
        if (daoArticle == null){
            daoArticle = DAOArticle()
        }
        return daoArticle
    }
}