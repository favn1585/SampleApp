package com.codingchallenge.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.codingchallenge.MainActivityViewModel
import com.codingchallenge.databinding.LessonFragmentBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class LessonFragment : Fragment() {

    private val model: MainActivityViewModel by sharedViewModel()

    private lateinit var binding: LessonFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = LessonFragmentBinding.inflate(inflater, container, false)
        .apply {
            binding = this
            viewModel = model
        }.root

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
        }
        model.apply {
            model.viewState.observe(viewLifecycleOwner, { viewState ->
                binding.editText.reset()
                viewState.currentLessonSpanData?.let { currentLessonSpanData ->
                    binding.editText.setSpanData(currentLessonSpanData)
                }
                viewState.currentLessonInputData?.let { currentLessonInputData ->
                    binding.editText.apply {
                        setSelectionLocks(
                            start = currentLessonInputData.prefix.length,
                            end = currentLessonInputData.suffix.length
                        )
                        setText("${currentLessonInputData.prefix}${currentLessonInputData.suffix}")
                        setSelection(currentLessonInputData.prefix.length)
                    }
                }
            })
            init()
        }
    }

    //todo send events

    /* 1. progress
     2. show first lesson (note time when started)
     3. after clicking next button update to next lesson (observed from view model)
     4. after all lessons passed show done button

     tests:

     - test use case
     - test mock web seb server
     - test view model after switching lessons*/
}