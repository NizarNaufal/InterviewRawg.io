package id.technicaltest.core.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.technicaltest.core.R
import id.technicaltest.core.databinding.ItemGameBinding
import id.technicaltest.core.domain.Games
import id.technicaltest.core.utils.backgroundImageContainer

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {
    private val gamesData = ArrayList<Games>()
    var onClickListenerItem: ((Int) -> Unit)? = null

    fun setData(data: List<Games>) {
        gamesData.clear()
        gamesData.addAll(data)
        notifyDataSetChanged()
    }

    inner class HomeViewHolder(val itemGameBinding: ItemGameBinding) :
        RecyclerView.ViewHolder(itemGameBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder =
        HomeViewHolder(
            ItemGameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        with(holder) {
            with(gamesData[position]) {
                val contextHolder = holder.itemView.context
                val contentItemGameBinding = itemGameBinding.contentItemGame
                backgroundImageContainer(
                    contextHolder,
                    null,
                    backgroundImage,
                    itemGameBinding.backgroundImage
                )
                contentItemGameBinding.txtGameTitle.text = name
                contentItemGameBinding.txtReleaseDate.text = released
                contentItemGameBinding.txtPlaytime.text = contextHolder.getString(
                    R.string.playtimeNumber, playtime
                )
                contentItemGameBinding.txtSuggested.text =
                    contextHolder.getString(R.string.suggested_byNumber, suggestionsCount)
                contentItemGameBinding.txtRating.text =
                    contextHolder.getString(R.string.ratingNumber, rating)
                holder.itemView.setOnClickListener {
                    onClickListenerItem?.invoke(id)
                }
            }
        }
    }

    override fun getItemCount(): Int = gamesData.size

}