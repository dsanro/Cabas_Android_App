package ed.app.eatlist.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ed.app.eatlist.databinding.FragmentHomeBinding
import ed.app.eatlist.services.impl.FoodServiceImpl

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {

        var foodServiceImpl: FoodServiceImpl = FoodServiceImpl()

        val homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        val textTest: TextView = binding.TESTTEXT
        val listView: ListView = binding.foodList


        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        homeViewModel.textTest.observe(viewLifecycleOwner) {
            textTest.text = foodServiceImpl.food
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}