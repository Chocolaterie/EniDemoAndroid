package com.example.enidemo

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.AlarmClock
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity



import androidx.core.content.ContextCompat.*
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.enidemo.databinding.ActivityMainBinding
import com.example.enidemo.model.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var counterViewModel: CounterViewModel
    private lateinit var baptistes: CharacterViewModel

    var historyMgr = HistoryMgr()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //   ActivityMainBinding.inflate(layoutInflater)
        //  setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        // Creer perso 1
        baptistes = CharacterViewModel()
        baptistes.pseudo.value = "SuperBaptistes"
        baptistes.level.value = 1

        // Connecté au view model
       // counterViewModel = ViewModelProvider(this).get(CounterViewModel::class.java)

        /*
        counterViewModel.counter.observe(this, Observer {
            binding.counterViewModel = counterViewModel;
        })
        */

        baptistes.level.observe(this, Observer {
            binding.superBaptiste = baptistes
        })

        // Sur les deux boutons
        binding.btnPlus.setOnClickListener { view ->
            // Modifier pseudo
            baptistes.editPseudo(binding.edtPseudo.text.toString())
            // Level up
            baptistes.levelUp()
        }
        //
    }

    /**
     * Coucou j'ai glissé chef
     * @param test Test
     * @return Un entierr
     */
    fun exampleGenericResponse(test : Int) : Int{
        var reponse = PersonManager.getPersonId(1)
        reponse.objectResult // C'est une personne

        assert(reponse.codeResponse.equals("702"))
        Log.i("EniDemo", reponse.getMessage())

        var reponseGetAll = PersonManager.getAllPerson(1)

        return 0
    }

    private fun checkPermission() {
        val permission = checkSelfPermission(
            this, Manifest.permission.ACCESS_FINE_LOCATION)
        if (permission != PackageManager.PERMISSION_GRANTED) {
            permissionsResultCallback.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        } else {
            println("Permission isGranted")
        }
    }

    private val permissionsResultCallback = registerForActivityResult(
        ActivityResultContracts.RequestPermission()){
        when (it) {
            true -> {
                Toast.makeText(this, "Permission has been granted by user (Crevette Nutella", Toast.LENGTH_SHORT).show() }
            false -> {
                Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
                //show your custom dialog and naviage to Permission seetings
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}