package com.info.launchfy

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CarsAdapter(private val mContext:Context, private val carsList:List<Cars>)
    : RecyclerView.Adapter<CarsAdapter.CardDesignObjectsHolder>(){

    private lateinit var mListener : onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){

        mListener = listener
    }

    inner class CardDesignObjectsHolder(view:View, listener: onItemClickListener):RecyclerView.ViewHolder(view){

        var imageViewCarImage:ImageView
        var textViewCarModel:TextView
        var textViewCity:TextView

        init{

            imageViewCarImage = view.findViewById(R.id.imageViewCarImage)
            textViewCarModel = view.findViewById(R.id.textViewCarModel)
            textViewCity = view.findViewById(R.id.textViewCity)

            view.setOnClickListener {

                listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun getItemCount(): Int {
        return carsList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignObjectsHolder {
        val design = LayoutInflater.from(mContext).inflate(R.layout.card_event,parent,false)

        return CardDesignObjectsHolder(design,mListener)
    }

    override fun onBindViewHolder(holder: CardDesignObjectsHolder, position: Int) {
        val car = carsList[position]

        holder.textViewCarModel.text = car.car_model
        holder.textViewCity.text = car.city

        holder.imageViewCarImage.setImageResource(
                mContext.resources.getIdentifier(car.car_image_name,"drawable",mContext.packageName))
    }
}