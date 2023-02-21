package com.example.enidemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.enidemo.databinding.FragmentFirstBinding
import com.example.enidemo.service.DAOFacture
import com.example.enidemo.service.DAOManagerGeneric
import com.example.enidemo.service.DAOPerson

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class DemoDAOGenericFragment : Fragment() {

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

        // DAO Manager exemple en generique
        var daoManager = DAOManagerGeneric()

        // Get la DAO Person
        var daoPerson = daoManager.getDAOByClass(DAOPerson::class);

        // Utiliser un fonction de DAO Person
        daoPerson!!.addPerson()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}