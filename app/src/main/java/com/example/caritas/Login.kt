package com.example.caritas

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.provider.ContactsContract
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.Navigation
import com.example.caritas.model.database.DbEntryPoint
import com.example.caritas.model.entities.User
import com.example.caritas.model.entities.UserLogin


class Login : Fragment() {
    lateinit var emailForm : EditText
    lateinit var contraForm : EditText

    var emaily : String = ""
    var contra : String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var pref : SharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE)

        var isFirstRun : Boolean = pref.getBoolean("FIRSTRUN", true)
        val editor = pref.edit()

        if (isFirstRun) {
            //Inicializar base de datos
            val userToAdd = User(1,"Jose","Lopez","Martinez","joloma@gmail.com",21,"H","21-08-1998",6621235367,6621234369,1,2,333.3,"21-08-2021")
            val userToAdd2 = User(2,"Carlos","Ramirez","Valdez","carava@gmail.com",29,"H","20-12-2000",8821231237,7721234123,2,3,618.5,"22-09-2021")

            val loginToAdd = UserLogin(1,"joloma@gmail.com","contra")
            val loginToAdd2 = UserLogin(2,"carava@gmail.com","contra123")

            val dbInstance = DbEntryPoint.getDatabase(requireContext())
            val userDao = dbInstance.userDao()

            userDao.insertUser(userToAdd)
            userDao.insertUser(userToAdd2)
            userDao.insertMailPass(loginToAdd)
            userDao.insertMailPass(loginToAdd2)

            dbInstance.close()

            editor.putBoolean("FIRSTRUN", false)
            editor.commit()
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        var ingresar : Button = view.findViewById(R.id.Ingresar)
        var restContra : Button = view.findViewById(R.id.clickaqui)
        var invi : Button = view.findViewById(R.id.invitado)
        var recuerdame : CheckBox = view.findViewById(R.id.recordar)

        emailForm = view.findViewById(R.id.correoInput)
        contraForm = view.findViewById(R.id.contraInput)

        loadValues()


        if(emailForm.text.toString() != "" || contraForm.text.toString() != ""){
            recuerdame.isChecked = true
        }


        ingresar.setOnClickListener{

            val emailIngresado : String = emailForm.text.toString()
            val contraIngresada : String = contraForm.text.toString()

            if( contraIngresada != "" && isValidEmail(emailIngresado) ){

                if(validCredentials(emailIngresado,contraIngresada)){

                    loadSession(emailIngresado)

                    if(recuerdame.isChecked){
                        saveValues()
                    }

                    Navigation.findNavController(view).navigate(R.id.mainMenu)

                }

                else{
                    Toast.makeText(activity, "Correo o contrasena incorrectos", Toast.LENGTH_SHORT).show()
                }
            }

            else{
                Toast.makeText(activity, "Correo o contrasena invalidos", Toast.LENGTH_SHORT).show()
            }
        }

        restContra.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.restablecerContra)
        }

        invi.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.menuInvitados)
        }

    }

    private fun validCredentials(email: String, password: String) : Boolean {
        val dbInstance = DbEntryPoint.getDatabase(requireContext())
        val userDao = dbInstance.userDao()
        val userlogin = userDao.findByMail(email)



        dbInstance.close()

        if(userlogin !== null){
            if(userlogin.password == password) {
                return true
            }
        }

        return false
    }

    private fun loadSession(currMail: String) {
        var pref : SharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE);
        val editor = pref.edit()

        editor.putString("sessionEmail",currMail)

        editor.commit()
    }
    private fun loadValues() {

        var pref : SharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE);

        emaily = pref.getString("email","").toString()
        contra = pref.getString("contra","").toString()

        emailForm.setText(emaily)
        contraForm.setText(contra)

    }

    private fun saveValues() {
        emaily = emailForm.text.toString()
        contra = contraForm.text.toString()

        var pref : SharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE);
        val editor = pref.edit()

        editor.putString("email",emaily)
        editor.putString("contra",contra)

        editor.commit()
    }


    private fun isValidEmail(email: String?): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

}