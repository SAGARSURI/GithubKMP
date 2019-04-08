package com.example.githubkmp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.Greetings
import com.example.UpdateProblem
import com.example.models.Member
import com.example.presentation.MembersPresenter
import com.example.presentation.MembersView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MembersView {

    private val repository by lazy { (application as GithubKMPApplication).repository }
    private val presenter by lazy { MembersPresenter(this, repository = repository) }
    private lateinit var adapter: MemberAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        greeting.text = Greetings().greeting()
        setupRecyclerView()
        presenter.onCreate()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override var isUpdating: Boolean = false

    override fun onUpdate(members: List<Member>) {
        adapter.members = members
        runOnUiThread {
            adapter.notifyDataSetChanged()
        }
    }

    override fun showError(error: Throwable) {
        val errorMessage = when (error) {
            is UpdateProblem -> "Failed to get data"
            else -> "Unknown error"
        }
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show()
    }

    private fun setupRecyclerView(){
        membersRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MemberAdapter(listOf())
        membersRecyclerView.adapter = adapter
    }
}
