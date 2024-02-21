package com.example.bottomnavview

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class NotificationsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e("TAG", "onCreateView: notifications", )
        return inflater.inflate(R.layout.fragment_notifications, container, false)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("TAG", "onDestroy: notifications", )
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            NotificationsFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}