package com.example.imagefilterview.ui.Contact

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import androidx.recyclerview.widget.RecyclerView.RecycledViewPool
import com.example.imagefilterview.ContactView
import com.example.imagefilterview.databinding.FragmentContactsBinding

class ContactsFragment : Fragment() {

    val items = ArrayList<Items>()
    lateinit var recView : RecyclerView
    lateinit var adapter :ItemAdapter
    private var _binding: FragmentContactsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val contactsViewModel =
            ViewModelProvider(this).get(ContactsViewModel::class.java)

        _binding = FragmentContactsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        items.add(Items("Elsa Marti"))
        items.add(Items("Manuel Bosch"))
        items.add(Items("Jorge Tomas"))
        items.add(Items("David Martinez"))
        items.add(Items("Silvia Serrano"))
        items.add(Items("Diego Domenech"))
        items.add(Items("Alba Bisbal"))
        items.add(Items("Daniel Soler"))

        recView=binding.recyclerContacts

        adapter = ItemAdapter(items){view -> onClick(view) }
        val decorator=DividerItemDecoration(context,DividerItemDecoration.VERTICAL)
        contactsViewModel.text.observe(viewLifecycleOwner){
            recView.adapter = adapter
            recView.layoutManager = LinearLayoutManager(context,RecyclerView.VERTICAL,false)
            recView.addItemDecoration(decorator)
        }

        return root
    }

    fun onClick(view: View):Boolean{
        val item = items.get(recView.getChildAdapterPosition(view))
        val intent = Intent(context,ContactView::class.java)
        intent.putExtra("nombre",item.text)
        startActivity(intent)
        return true
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}