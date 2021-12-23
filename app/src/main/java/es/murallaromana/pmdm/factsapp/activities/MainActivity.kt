package es.murallaromana.pmdm.factsapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import es.murallaromana.pmdm.factsapp.R
import es.murallaromana.pmdm.factsapp.fragments.ListaEventosFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, ListaEventosFragment.newInstance())
            .commit()
    }
}