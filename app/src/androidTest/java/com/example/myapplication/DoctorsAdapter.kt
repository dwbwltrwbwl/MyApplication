package com.example.myapplication
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemDoctorsBinding

class DoctorsAdapter(private val doctorsList: List<Doctors>) :
        RecyclerView.Adapter<DoctorsAdapter.DoctorsViewHolder>(){
                inner class DoctorsViewHolder (val binding: ItemDoctorsBinding) : RecyclerView.ViewHolder(binding.root)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorsViewHolder {
                val binding = ItemDoctorsBinding.inflate(LayoutInflater.from(parent.context),parent, false)
                return DoctorsViewHolder(binding)

        }

        override fun onBindViewHolder(holder: DoctorsViewHolder, position: Int) {
                val doctor = doctorsList[position]
                holder.binding.textViewFirstName.text = doctor.firts_name
                holder.binding.textViewLastName.text = doctor.last_name
                holder.binding.textViewMiddleName.text = doctor.middle_name
        }

        override fun getItemCount(): Int = doctorsList.size
        }