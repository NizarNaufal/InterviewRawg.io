package id.technicaltest.interviewrawgio.ui.search

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.SearchView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import id.technicaltest.core.source.remote.local.Resource
import id.technicaltest.core.utils.Status
import id.technicaltest.core.view.SearchAdapter
import id.technicaltest.interviewrawgio.R
import id.technicaltest.interviewrawgio.databinding.FragmentSearchBinding
import id.technicaltest.interviewrawgio.ui.detail.DetailActivity
import id.technicaltest.interviewrawgio.ui.main.MainActivity
import org.koin.android.viewmodel.ext.android.viewModel

class SearchFragment : Fragment() {

    private val searchViewModel: SearchViewModel by viewModel()
    private lateinit var searchAdapter: SearchAdapter
    private var _fragmentSearchBinding: FragmentSearchBinding? = null
    private val fragmentSearchBinding get() = _fragmentSearchBinding!!

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        searchAdapter = SearchAdapter()
        fragmentSearchBinding.notificationErrorSearch.root.visibility = View.GONE
        fragmentSearchBinding.notificationForSearch.root.visibility = View.VISIBLE
        fragmentSearchBinding.notificationLoadingSearch.visibility = View.GONE
        fragmentSearchBinding.rvHorizontalSearchGame.visibility = View.GONE
        fragmentSearchBinding.rvHorizontalSearchGame.adapter = searchAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        menu.clear()
        inflater.inflate(R.menu.search_bar_menu, menu)
        val searchManager = activity?.getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView =
            SearchView((context as MainActivity).supportActionBar?.themedContext ?: context)
        menu.findItem(R.id.app_bar_search).apply {
            setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS or MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW)
            actionView = searchView
        }
        val searchIcon: ImageView = searchView.findViewById(
            searchView.context.resources.getIdentifier(
                "android:id/search_mag_icon",
                null,
                null
            )
        )
        val searchCloseIcon: ImageView = searchView.findViewById(
            searchView.context.resources.getIdentifier(
                "android:id/search_close_btn",
                null,
                null
            )
        )
        searchView.isIconifiedByDefault = false
        searchView.setSearchableInfo(searchManager.getSearchableInfo(activity?.componentName))
        searchView.queryHint = getString(R.string.searchHint)
        searchIcon.setImageResource(R.drawable.ic_search)
        searchCloseIcon.setImageResource(R.drawable.ic_clear)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                loadSearch(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })
        searchAdapter.onClickListenerItem = {
            val intent = Intent(activity, DetailActivity::class.java)
            intent.putExtra("extra_detail", it)
            startActivity(intent)
        }
    }

    private fun loadSearch(text: String) {
        searchViewModel.setGameDetailId(text)
        searchViewModel.searchGames.observe(viewLifecycleOwner, {
            if (it != null) {
                when (it) {
                    is Resource.Loading -> {
                        statusLayoutVisibility(Status.Loading)
                    }
                    is Resource.Success -> {
                        searchAdapter.setData(it.data!!)
                        statusLayoutVisibility(Status.Success)
                    }
                    is Resource.Error -> {
                        statusLayoutVisibility(Status.Error)
                    }
                }
            }
        })
    }

    private fun statusLayoutVisibility(status: Status) {
        fragmentSearchBinding.notificationForSearch.root.visibility = View.GONE
        fragmentSearchBinding.notificationErrorSearch.root.visibility = View.GONE
        fragmentSearchBinding.notificationLoadingSearch.visibility = View.GONE
        fragmentSearchBinding.rvHorizontalSearchGame.visibility = View.GONE

        when (status) {
            Status.Success -> {
                fragmentSearchBinding.rvHorizontalSearchGame.visibility = View.VISIBLE
            }
            Status.Error -> {
                fragmentSearchBinding.notificationErrorSearch.root.visibility = View.VISIBLE
            }
            Status.Loading -> {
                fragmentSearchBinding.notificationLoadingSearch.visibility = View.VISIBLE
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)
        _fragmentSearchBinding = FragmentSearchBinding.inflate(inflater, container, false)
        return fragmentSearchBinding.root
    }

    override fun onDestroyView() {
        _fragmentSearchBinding = null
        super.onDestroyView()
    }
}