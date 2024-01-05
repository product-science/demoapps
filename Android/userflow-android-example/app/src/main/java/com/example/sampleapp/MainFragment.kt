package com.example.sampleapp

import com.example.sampleapp.databinding.FragmentMainBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.productscience.userflow.v2.UserFlow
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainFragment: Fragment() {

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.Default) {
            // We will use Thread#sleep to simulate loading an image from the network
            UserFlow.custom(APP_START_USER_FLOW_ID, "Loading avatar")
            Thread.sleep(500)
            withContext(Dispatchers.Main) {
                binding.progressAvatar.visibility = View.GONE
                binding.avatar.visibility = View.VISIBLE
                UserFlow.custom(APP_START_USER_FLOW_ID, "Avatar loaded")
            }
            Thread.sleep(500)
            UserFlow.custom(APP_START_USER_FLOW_ID, "Loading banner")
            Thread.sleep(500)
            withContext(Dispatchers.Main) {
                binding.progressBanner.visibility = View.GONE
                binding.bannerimage.visibility = View.VISIBLE
                UserFlow.custom(APP_START_USER_FLOW_ID, "Banner loaded")
            }
            Thread.sleep(500)
            UserFlow.end(APP_START_USER_FLOW_ID)
        }
        return binding.root
    }
}