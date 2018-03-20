package application.mike.fragments

import android.app.Activity
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import application.mike.AccessToken

import application.mike.R
import com.github.kittinunf.fuel.android.core.Json
import com.github.kittinunf.fuel.android.extension.responseJson
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result

class ProfilFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
        }
    }

    fun Fragment.toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(getActivity(), message, duration).show()
    }

    companion object {
        fun newInstance(): ProfilFragment {
            var fragment = ProfilFragment()
            var args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val URL : String = "https://mike.arrogant.space/v1/user/me"
        var profile: Json

        URL.httpGet().header(Pair("Authorization", "Bearer ${AccessToken.ACCESS_TOKEN}")).responseJson()
        { request, response, result ->
            when (result) {
                is Result.Success -> {
                    profile = result.get()
                    val profileObject = profile.obj()
                    println("Result: ${profile}")
                    var username = profileObject.getString("username")
                    var lastname = profileObject.getString("lastname")
                    var firstname = profileObject.getString("firstname")
                    var email = profileObject.getString("email")
                    var birthday = profileObject.getString("birthday")
                    var language = profileObject.getString("language")
                    val xp = profileObject.getInt("xp")
                    val musclor = profileObject.getString("musclor")
                }
                is Result.Failure -> {
//                    Context().(this@ProfilFragment, "Check your connexion", Toast.LENGTH_LONG).show()
                    //ProfilFragment().toast("Check your connexion")
                }
            }
        }
        println(AccessToken.ACCESS_TOKEN)

        return inflater!!.inflate(R.layout.fragment_profil, container, false)
    }
}// Required empty public constructor