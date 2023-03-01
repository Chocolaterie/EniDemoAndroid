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
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.enidemo.databinding.ActivityMainBinding
import com.example.enidemo.model.*
import com.example.enidemo.room.*
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var counterViewModel: CounterViewModel
    private lateinit var baptistes: CharacterViewModel

    private lateinit var db: AppDatabase

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

        // Demo inventaire
        demoInventory()
    }

    fun demoInventory() {
        // Tache async
        lifecycleScope.launch {
            db = AppDatabase.getInstance(this@MainActivity)

            // Je creer un joueur et son inventaire (One to One)
            db.playerDao().insert(Player(1, "xXXDarkSasukeXxx"))
            db.playerDao().insert(Inventory(1, 36, 1))

            // Creer joueur 2
            db.playerDao().insert(Player(2, "Toto"))

            // Recuperer le joueur et son inventaire (One to One)
            val playerInventory = db.playerDao().getPlayerInventory(1)

            Log.i(
                "EniDemo",
                String.format(
                    "Voici l'inventaire %d du joueur %s",
                    playerInventory.inventory.maxSlot,
                    playerInventory.player?.pseudo
                )
            )


            // Ajouter des items en base
            db.playerDao().insert(Item(0, "Epee de Tom", 1))
            db.playerDao().insert(Item(0, "Le baton de Deni", 1))
            db.playerDao().insert(Item(0, "Le casque du roi Gaetan", 1))
            db.playerDao().insert(Item(0, "Le casque du chien Isaac", 1))

            // Recupérer les items de mon inventaire
            val inventoryItems =
                db.playerDao().getInventoryItems(playerInventory.inventory.inventoryId)

            // Pour chaque items de mon inventaire
            for (item: Item in inventoryItems.items) {
                Log.i(
                    "EniDemo",
                    String.format(
                        "Voici l'item %s de l'inventaire %d",
                        item.label,
                        playerInventory.inventory.inventoryId
                    )
                )
            }

            // Creer des quetes
            db.playerDao().insert(Quest(0, "Trouver une chocolatine"))
            db.playerDao().insert(Quest(0, "Battre Bastien au Kahoot"))
            db.playerDao()
                .insert(Quest(0, "Craft une pizza crevette nutella sans se faire insulter"))

            // Associer le joueur 1 avec la quete 1
            db.playerDao().insert(QuestPlayer(1, 1))
            // Associer le joueur 1 avec la quete 3
            db.playerDao().insert(QuestPlayer(3, 1))

            // Associer le joueur 2 avec la quete 1
            db.playerDao().insert(QuestPlayer(1, 2))
            // Associer le joueur 2 avec la quete 2
            db.playerDao().insert(QuestPlayer(2, 2))

            // Récupérer la quest 1 avec les joueurs qui l'utilise
            val questOneWithPlayers = db.playerDao().getQuestWithPlayers(1)

            // Pour chaque joueur qui utilise cette quete
            for (player: Player in questOneWithPlayers.players) {

                // On récupère les quetes de ce joueurs
                val playerWithQuests = db.playerDao().getPlayerQuests(player.playerId)

                // Pour afficher toutess ces quetes
                for (quest: Quest in playerWithQuests.quests) {
                    Log.i(
                        "EniDemo",
                        String.format(
                            "Le joueur %s utilise la quête %s",
                            player.pseudo,
                            quest.name
                        )
                    )
                }
            }

        }
    }

    fun demoPerson() {
        // Tache async
        lifecycleScope.launch {
            db = AppDatabase.getInstance(this@MainActivity)

            var dao = db.personDao();
            dao?.insert(Person(0, "Tom", 5))

            // Get une person
            val person = dao.get(1)
            Log.i(
                "ENIDemo",
                String.format("Voici la personne %d nommé %s", person.id, person.firstname)
            )
        }
    }

    /**
     * Coucou j'ai glissé chef
     * @param test Test
     * @return Un entierr
     */
    fun exampleGenericResponse(test: Int): Int {
        var reponse = PersonManager.getPersonId(1)
        reponse.objectResult // C'est une personne

        assert(reponse.codeResponse.equals("702"))
        Log.i("EniDemo", reponse.getMessage())

        var reponseGetAll = PersonManager.getAllPerson(1)

        return 0
    }

    private fun checkPermission() {
        val permission = checkSelfPermission(
            this, Manifest.permission.ACCESS_FINE_LOCATION
        )
        if (permission != PackageManager.PERMISSION_GRANTED) {
            permissionsResultCallback.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        } else {
            println("Permission isGranted")
        }
    }

    private val permissionsResultCallback = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) {
        when (it) {
            true -> {
                Toast.makeText(
                    this,
                    "Permission has been granted by user (Crevette Nutella",
                    Toast.LENGTH_SHORT
                ).show()
            }
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