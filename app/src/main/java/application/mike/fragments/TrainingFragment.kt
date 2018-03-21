package application.mike.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import application.mike.AccessToken

import application.mike.R
import com.github.kittinunf.fuel.android.core.Json
import com.github.kittinunf.fuel.android.extension.responseJson
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import org.json.JSONException
import org.json.JSONObject



class TrainingFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val URL : String = "https://mike.arrogant.space/v1/trainings"
        var training: Json
        val view = inflater!!.inflate(R.layout.fragment_training, container, false)
//        var ProfilTextView: TextView? = null
//        var LevelTextView: TextView? = null
//        var mAdapter: ProfilFragment? = null
//        ProfilTextView = view.findViewById(R.id.Salle) as TextView
//        LevelTextView = view.findViewById(R.id.Level) as TextView

        URL.httpGet().header(Pair("Authorization", "Bearer ${AccessToken.ACCESS_TOKEN}")).responseJson()
        { request, response, result ->
            when (result) {
                is Result.Success -> {

                }
                is Result.Failure -> {
//                    Context().(this@ProfilFragment, "Check your connexion", Toast.LENGTH_LONG).show()
                    //ProfilFragment().toast("Check your connexion")
                }
            }
        }
        return view
    }
    companion object {
        fun newInstance(): TrainingFragment {
            var fragmentHome = TrainingFragment()
            var args = Bundle()
            fragmentHome.arguments = args
            return fragmentHome
        }
    }
    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //var editTextHome = view!!.findViewById(R.id.textTraining) as TextView
    }
}