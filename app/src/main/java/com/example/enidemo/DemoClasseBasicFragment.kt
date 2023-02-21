package com.example.enidemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.enidemo.databinding.FragmentFirstBinding
import com.example.enidemo.model.Person

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class DemoClasseBasicFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        // Nos demos

        // Instanciéé une personne
        var a = Person(1, "Toto")
        var b = Person(2, "Shiba")

        // Afficher les deux personnes
        System.out.println("Test")
        System.out.println(a.firstname)
        System.out.println(b.firstname)
        System.out.println("==================================")
        // Pointer/Referencer  b sur a
        a = b // Warning : Attention on ne copie pas la valeur, on associé l'adresse

        // Je modifie une Seule personne
        b.firstname = "Mon Nouveau Prenom"

        // Afficher les deux personnes
        System.out.println(a.firstname)
        System.out.println(b.firstname)
        System.out.println("==================================")

        // Piege : Example
        // get person 1
        var personToCopy = Person(1, "Jean Yves")
        var listPerson = ArrayList<Person>()

        for (i in 0..10){
            listPerson.add(personToCopy);
        }

        System.out.println("=== TEST PERSON ===")
        // je modifie une personne de la liste
        listPerson.get(0).firstname = "LOL"

        // Afficher toute les personnes
        for (person in  listPerson){
            System.out.println(person.firstname)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}