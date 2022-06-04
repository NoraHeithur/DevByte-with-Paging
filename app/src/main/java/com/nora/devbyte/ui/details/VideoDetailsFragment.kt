package com.nora.devbyte.ui.details

import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.Intent.*
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.google.android.material.transition.MaterialContainerTransform
import com.nora.devbyte.R
import com.nora.devbyte.databinding.FragmentVideoDetailsBinding
import com.nora.devbyte.ui.utils.themeColor
import org.koin.androidx.viewmodel.ext.android.viewModel

class VideoDetailsFragment : Fragment(), VideoListener {

    private val viewModel: VideoDetailsViewModel by viewModel()

    private val args: VideoDetailsFragmentArgs by navArgs()

    private val binding: FragmentVideoDetailsBinding by lazy {
        FragmentVideoDetailsBinding.inflate(layoutInflater)
    }

    private fun bindingView() {
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewmodel = viewModel
        binding.listener = this
    }

    private fun bindingData() {
        viewModel.getVideo(args.video)
    }

    private fun bindingIntentAction(url: String) {
        var intent = Intent()
        try {
            val packageManager = requireContext().packageManager ?: return

            if (intent.resolveActivity(packageManager) != null) {
                intent = Intent(
                    ACTION_VIEW,
                    viewModel.video.value!!.getYoutubeSchemeUri(url)
                ).apply {
                    addCategory(CATEGORY_BROWSABLE)

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                        flags = FLAG_ACTIVITY_NEW_TASK or FLAG_ACTIVITY_REQUIRE_NON_BROWSER
                    }
                }
            }

            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            intent = Intent(ACTION_VIEW, viewModel.video.value!!.getUri(url))
            startActivity(intent)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        sharedElementEnterTransition = MaterialContainerTransform().apply {
            drawingViewId = R.id.main_nav_host
            duration = resources.getInteger(R.integer.motion_duration_normal).toLong()
            scrimColor = Color.TRANSPARENT
            setAllContainerColors(requireContext().themeColor(com.google.android.material.R.attr.colorSurface))
        }

        bindingView()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindingData()
    }

    override fun onButtonWatchOnYoutubeClicked(url: String) {
        bindingIntentAction(url)
    }
}