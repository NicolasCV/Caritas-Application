package com.example.caritas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.RelativeLayout
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.android.material.snackbar.Snackbar
import com.prof.rssparser.Channel
import com.prof.rssparser.Parser

import kotlinx.coroutines.launch
import okhttp3.OkHttpClient

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private lateinit var parser: Parser
    private lateinit var adapter: ArticleAdapter
    private lateinit var progressBar: ProgressBar
    private lateinit var recyclerView: RecyclerView
    private lateinit var swipeLayout: SwipeRefreshLayout
    private lateinit var rootLayout: RelativeLayout

    private lateinit var articleListLive: MutableLiveData<Channel>

    private val _snackbar = MutableLiveData<String>()
    val snackbar: LiveData<String>
        get() = _snackbar

    private val _rssChannel = MutableLiveData<Channel>()
    val rssChannel: LiveData<Channel>
        get() = _rssChannel

    private val okHttpClient by lazy {
        OkHttpClient()
    }

    private val url = "https://www.caritas.org.mx/area/eventos/feed/"


class EventsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        parser = Parser.Builder()
            .context(requireContext())
            //.charset(Charset.forName("ISO-8859-7"))
            .cacheExpirationMillis(24L * 60L * 60L * 100L) // one day
            .build()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_events, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recycler_view)
        progressBar = view.findViewById(R.id.progressBar)
        swipeLayout = view.findViewById(R.id.swipe_layout)
        rootLayout = view.findViewById(R.id.root_layout)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.setHasFixedSize(true)

        rssChannel.observe(viewLifecycleOwner, { channel ->
            if (channel != null) {
                adapter = ArticleAdapter(channel.articles)
                recyclerView.adapter = adapter
                adapter.notifyDataSetChanged()
                progressBar.visibility = View.GONE
                swipeLayout.isRefreshing = false
            }
        })

        snackbar.observe(viewLifecycleOwner, { value ->
            value?.let {
                Snackbar.make(rootLayout, value, Snackbar.LENGTH_LONG).show()
                onSnackbarShowed()
            }
        })

        swipeLayout.setColorSchemeResources(
            R.color.design_default_color_primary,
            R.color.design_default_color_primary_dark
        )
        swipeLayout.canChildScrollUp()
        swipeLayout.setOnRefreshListener {
            adapter.clearArticles()
            swipeLayout.isRefreshing = true
            fetchFeed(parser)
        }

        fetchFeed(parser)

    }



    private fun onSnackbarShowed() {
        _snackbar.value = null
    }

    private fun fetchFeed(parser: Parser){
        viewLifecycleOwner.lifecycleScope.launch {
            try {
                val channel = parser.getChannel(url)
                _rssChannel.postValue(channel)
            } catch (e: Exception) {
                e.printStackTrace()
                _snackbar.value = "An error has occurred. Please retry"
                _rssChannel.postValue(Channel(null, null, null, null, null, null, mutableListOf()))
            }
        }
    }
}