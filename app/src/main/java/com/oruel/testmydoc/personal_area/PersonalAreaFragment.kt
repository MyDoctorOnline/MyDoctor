package com.oruel.testmydoc.personal_area

import android.app.AlertDialog
import android.content.DialogInterface
import android.icu.text.LocaleDisplayNames
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.oruel.testmydoc.databinding.FragmentPersonalAreaBinding
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.oruel.testmydoc.R
import com.oruel.testmydoc.data_class.SavingTicket
import com.oruel.testmydoc.data_class.Ticket
import com.oruel.testmydoc.l
import com.oruel.testmydoc.order_ticket.OrderTicketFragment

class PersonalAreaFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = FragmentPersonalAreaBinding.inflate(inflater, container, false)
        val factory = ViewModelProvider.AndroidViewModelFactory(activity!!.application)
        val adapter = ObserverSavingTicketAdapter(listOf(
            SavingTicket(Ticket("123", "123", "123"), "123", "123"),
            SavingTicket(Ticket("321", "321", "321"), "321", "321"),
            SavingTicket(Ticket("456", "456", "456"), "456", "456")
        ))
        val layoutManager = StaggeredGridLayoutManager(
            3,
            LinearLayoutManager.VERTICAL
        )
        val vm = ViewModelProviders.of(
            this,
            factory
        ).get(PersonalAreaViewModel::class.java)

        view.adapterRecycler = adapter
        view.layoutManager = layoutManager
        view.vm = vm

//        l(view.adapterRecycler.toString())
        vm.observeSavingTicket(adapter)
        return view.root
    }

    //отсюда функция для диалога
    private lateinit var alertDialog: AlertDialog
    fun showDialog() {
        val inflater: LayoutInflater = this.layoutInflater
        val dialogView: View = inflater.inflate(R.layout.fragment_order_ticket, null)

        val showingText = dialogView.findViewById<TextView>(R.id.dialog_text)
        val buttonYes = dialogView.findViewById<Button>(R.id.button_yes)
        val buttonNo = dialogView.findViewById<Button>(R.id.button_no)

        buttonYes.setOnClickListener(){

        }
        buttonNo.setOnClickListener{

        }

        val dialogBuilder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        dialogBuilder.setOnDismissListener(object: DialogInterface.OnDismissListener{
            override fun onDismiss(p0: DialogInterface?) {
                TODO("Not yet implemented")
            }
        })
        dialogBuilder.setView(dialogView)

        alertDialog = dialogBuilder.create()
        alertDialog.show()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val logo_image: ImageView = view.findViewById(R.id.logo_image)
        logo_image.setOnClickListener{
            showDialog()
        }
    }
}