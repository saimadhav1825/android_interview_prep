package com.example.prepareinterview.kotlinConcepts

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.prepareinterview.databinding.FragmentHomeBinding

class KotlinConceptsFragment : Fragment() {
    var msg = "KotlinConceptsFragment : "
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        letScope()
        applyScope()
        withScope()
        runScope()
        alsoScope()
        return binding.root
    }

    fun letScope() {
        var leta: String? = null
        println(leta)
        leta = ""
        val out = leta?.let {
            println(it)
            "let"
        }
        println(out)
    }

    class MyObject {
        lateinit var name: String
        lateinit var value: String
    }

    fun applyScope() {
        val apply = MyObject().apply {
            name = "sai"
            value = "hdciu"
        }
        println(apply)
    }

    fun withScope() {
        val gfg = MyObject().apply {
            name = "GeeksforGeeks"
            value = "A computer science portal for Geeks"
        }

        // with function
        val with = with(gfg) {
            // similar to println( "${this.name}" )
            println(" $name ")
            "dbcjk"
        }
        println(with)
    }

    fun runScope() {
        var company: MyObject? = null
        // body only executes if
        // company is non-null
        company?.run {
            print(name)
        }
        print("Company Name : ")
        // re-initialize company
        company = MyObject().apply {
            name = "GeeksforGeeks"
            value = "Sandeep Jain"
        }
        // body executes as
        // 'company' is non-null
        val s = company?.run {
            print(name)
            "ouiegc"
        }
        println(s)
    }

    fun alsoScope() {
        // initialized
        val list = mutableListOf(1, 2, 3)

        // later if we want to perform
        // multiple operations on this list
        list.also {
            it.add(4)
            it.remove(2)
            // more operations if needed
        }
        println(list)
    }
}