package com.sozge.fairyflick_

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.ai.client.generativeai.GenerativeModel
import com.sozge.fairyflick_.databinding.FragmentHomeBinding
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? { _binding = FragmentHomeBinding.inflate(inflater,container, false)
    val view = binding.root
    return view }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val generativeModel = GenerativeModel(
            modelName = "gemini-1.5-flash",
            // Access your API key as a Build Configuration variable (see "Set up your API key" above)
            apiKey = "AIzaSyCp0UwezGR19olTPjmyo58owhmc7awNvnY"
        )

        val prompt = "merhaba."
        MainScope().launch {
            val response = generativeModel.generateContent(prompt)
            binding.textView.text = response.text
        }
    }
}