package com.codingchallenge.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.codingchallenge.MainActivityViewModel
import com.codingchallenge.databinding.LessonFragmentBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class LessonFragment: Fragment() {

    private val viewModel: MainActivityViewModel by sharedViewModel()

    private lateinit var binding: LessonFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = LessonFragmentBinding.inflate(inflater, container, false)
        .also {
            binding = it
        }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNext.isVisible = false
    }

    //todo send events

    1. progress
    2. show firts lesson (note time when started)
    3. after clicking next button update to next lesson (observed from view model)
    4. after all lessons passed show done button

    tests:

    - test use case
    - test mock web seb server
    - test view model after switching lessons
}