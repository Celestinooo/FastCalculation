package br.edu.ifsp.sdm.dad1.fastcalculation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.edu.ifsp.sdm.dad1.fastcalculation.Extras.EXTRA_RESULT
import br.edu.ifsp.sdm.dad1.fastcalculation.databinding.FragmentResultBinding


class ResultFragment : Fragment() {
    private lateinit var fragmentResultBinding: FragmentResultBinding
    private lateinit var result : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            result = it.getString(EXTRA_RESULT) ?: ""
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentResultBinding = FragmentResultBinding.inflate(inflater,container,false).apply {
            resultTv.text = result
            restartGameBt.setOnClickListener {
                (context as OnPlayGame).onPlayGame()
            }
        }
        return fragmentResultBinding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(result: String) =
            ResultFragment().apply {
                arguments = Bundle().apply {
                    putString(EXTRA_RESULT, result)
                }
            }
    }
}